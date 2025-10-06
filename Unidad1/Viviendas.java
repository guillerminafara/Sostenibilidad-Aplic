
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Viviendas {

    static class Municipio {

        String territorio;
        String codigo;
        double mediana;

        Municipio(String territorio, String codigo, double mediana) {
            this.territorio = territorio;
            this.codigo = codigo;
            this.mediana = mediana;
        }
    }

    public static void main(String[] args) {
        // if (args.length == 0) {
        //     System.err.println("❌ Debes indicar la ruta al archivo CSV como primer argumento.");
        //     return;
        // }

        String ruta = ".\\viviendas.csv";
        int limite = 3; // valor por defecto

        if (args.length >= 2) {
            try {
                limite = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ El segundo parámetro no es un número válido, se usará el valor por defecto (3).");
            }
        }

        List<Municipio> municipios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea = br.readLine(); // saltar encabezado
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";", -1); // o "," según el separador

                // Asegúrate de que las columnas coinciden con el CSV real:
                // Ejemplo de columnas: "Territorio";"Código";"Mediana"
                if (partes.length >= 3) {
                    // String territorio = partes[0].replace("\"", "").trim();
                    // String codigo = partes[1].replace("\"", "").trim();
                    // String valorStr = partes[2].replace("\"", "").trim();

                    String codigo = partes[2].replace("\"", "").trim();
                    String territorio = partes[3].replace("\"", "").trim();
                    String valorStr = partes[4].replace("\"", "").trim();
                    if (!valorStr.isEmpty()) {
                        try {
                            double mediana = Double.parseDouble(valorStr);
                            municipios.add(new Municipio(territorio, codigo, mediana));
                        } catch (NumberFormatException e) {
                            // ignorar líneas con valores no numéricos
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
            return;
        }

        // Ordenar descendente por mediana
        municipios.sort((a, b) -> Double.compare(b.mediana, a.mediana));

        // Mostrar los N primeros
        System.out.println("=== Municipios con mayor mediana ===");
        municipios.stream()
                .limit(limite)
                .forEach(m -> System.out.printf("Territorio: %s | Código: %s | Valor: %.2f%n",
                m.territorio, m.codigo, m.mediana));
    }
}
