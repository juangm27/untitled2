import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Practica1_E6_AD {
    public static void main(String[] args) {
        File archivo = new File("numeros.txt");
        String linea;
        int numero = 0;
        try(BufferedReader br=new BufferedReader(new FileReader(archivo))){
            while(true){
                linea=br.readLine();
                if(linea==null) break;
                numero+=Integer.parseInt(linea);
            }
            System.out.println(numero);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
