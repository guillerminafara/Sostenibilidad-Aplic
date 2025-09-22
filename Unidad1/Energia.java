import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Energia{
    public static void main(String[]args) throws IOException{
        System.out.println("Hola");
        String archivoCsv= "/home/marfarsan/Escritorio/daw/Sostenibilidad-Aplic/Unidad1/viviendas.csv";
        List<String> lista= new ArrayList<>();
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(archivoCsv));
            String linea=br.readLine();
            while (linea != null) {
                String[] fragmento=
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
