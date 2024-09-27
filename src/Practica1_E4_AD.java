import java.io.*;
import java.util.Scanner;

public class Practica1_E4_AD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion,n = 0;
        int [] numeros=new int[101];
        String nombre,apellidos,ciudad,archivo="",linea;
        do {
            System.out.println("Menu ficheros:");
            System.out.println("1.Crear fichero");
            System.out.println("2.Mostrar fichero");
            System.out.println("3.Salir");
            opcion=sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Introduce el nombre del fichero: ");
                    sc.nextLine();
                    archivo=sc.nextLine();
                    try(BufferedWriter bf=new BufferedWriter(new FileWriter(archivo))) {
                        for (int i=0;i<=200;i=i+2) {
                            numeros[n]=i;
                            n++;
                        }
                        for (int numero : numeros) {
                            bf.write(numero+"\n");
                        }
                        System.out.println("Se han escrito con exito!!!");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case 2:
                    if (archivo==""){
                        System.out.println("No existe el fichero");
                    }else {
                        try(BufferedReader br=new BufferedReader(new FileReader(archivo))){
                            while(true){
                                linea=br.readLine();
                                if(linea==null) break;
                                System.out.println(linea);
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Adios!!!");
                    break;
            }
        }while (opcion!=3);
    }
}
