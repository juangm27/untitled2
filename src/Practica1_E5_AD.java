import java.io.*;
import java.util.Scanner;

public class Practica1_E5_AD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String archivo,texto,linea2="",linea;
        char [] resultado;
        System.out.println("Introduce el nombre del fichero: ");
        archivo=sc.nextLine();
        System.out.println("Introduce el texto que quieras:");
        texto=sc.nextLine();
        try(BufferedWriter bf=new BufferedWriter(new FileWriter(archivo))) {
            bf.write(texto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(BufferedReader br=new BufferedReader(new FileReader(archivo))) {
            while(true){
                linea=br.readLine();
                if(linea==null) break;
                for (char c:linea.toCharArray()) {
                    if(Character.isUpperCase(c)){
                        linea2= linea2 + Character.toLowerCase(c);
                    }else{
                        linea2= linea2 + Character.toUpperCase(c);
                    }
                }
                System.out.println(linea2);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
