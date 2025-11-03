
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
        int valor;
        String anio;

        public Municipio(String codigo, String territorio, int valor, String anio) {
            this.codigo = codigo;
            this.territorio = territorio;
            this.valor = valor;
            this.anio = anio;
        }
    }

    public static void mediana(String archivoCsv, String cantidad) throws IOException {
        System.out.printf("El top %s medianas de consumo por Municipios:\n", cantidad);
        // String archivoCsv = ".\\viviendas.csv";
        int cant = Integer.parseInt(cantidad);
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
                    int mediana = Integer.parseInt(valor);

                    listaValorMunicipios.add(new Municipio(codigo, territorio, mediana, anio));
                    listaValorMunicipios.sort((municipioA, municipioB) -> Integer.compare(municipioB.valor, municipioA.valor));
                }
            }

            listaValorMunicipios.stream()
                    .limit(cant)
                    .forEach(m -> System.out.printf("codigo: %s Territorio: %s  valor: %d \n", m.codigo, m.territorio, m.valor));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
    //   int i = 0;
    //     int contador = 1;
    //     for (Municipio municipio : listaValorMunicipios.reversed()){
    //             if (i < cant) {
    //                 System.out.printf("%d - codigo: %s Territorio: %s  valor: %d \n",contador, municipio.codigo, municipio.territorio, municipio.valor);
    //             }
    //              i++;
    //              contador++;
    //          }
