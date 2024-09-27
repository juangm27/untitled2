import java.io.*;

public class Practica1_E2_AD {
    public static void main(String[] args){
        String linea;
        File directorio=new File("texto.txt");
        try(BufferedReader br=new BufferedReader(new FileReader(directorio))){
            while(true){
                linea=br.readLine();
                if(linea==null) break;
                System.out.println(linea);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
