
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Energia {

    public static void main(String[] args) throws IOException {
        mediana(args[0], args[1]);
    }

    static class Municipio {

        String codigo;
        String territorio;
        Double valor;
        String anio;

        public Municipio(String codigo, String territorio, Double valor, String anio) {
            this.codigo = codigo;
            this.territorio = territorio;
            this.valor = valor;
            this.anio = anio;
        }
    }

    public static void mediana(String archivoCsv, String cantidad) throws IOException {
        System.out.println("El top 3 medianas de consumo por Municipios:");
        // String archivoCsv = ".\\viviendas.csv";
        int cant = Integer.parseInt(cantidad);
        int contador = 1;
        try {

            BufferedReader br = new BufferedReader(new FileReader(archivoCsv));
            String linea = br.readLine();
            linea = br.readLine();
            List<Municipio> listaValorMunicipios = new ArrayList<>();
            while ((linea = br.readLine()) != null) {
                String[] fragmento = linea.split(";", -1);
                String codigo = fragmento[2] + " - ";
                String territorio = fragmento[3] + " - ";
                String valor = fragmento[4];
                String anio = fragmento[0];

                if (!valor.isEmpty() && !valor.contains("-")) {
                    double mediana = Double.parseDouble(valor);

                    listaValorMunicipios.add(new Municipio(codigo, territorio, mediana, anio));
                    listaValorMunicipios.sort((a, b) -> Double.compare(a.valor, b.valor));

                }
            }
            // int i = 0;
            // for (Municipio municipio : listaValorMunicipios.reversed()) {
            //     if (i < cant) {
            //         System.out.printf("%d - codigo: %s Territorio: %s  valor: %.0f \n",contador, municipio.codigo, municipio.territorio, municipio.valor);
            //       
            //     }
            //     i++;
            //     contador++;
            // }


            listaValorMunicipios.stream()
                    .limit(cant)
                    .forEach(m ->System.out.printf("codigo: %s Territorio: %s  valor: %.0f \n",m.codigo, m.territorio, m.valor));

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
