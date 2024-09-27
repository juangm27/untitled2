import java.io.*;
import java.util.Scanner;

public class Practica1_E3_AD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
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
                        System.out.println("Nombre: ");
                        nombre=sc.nextLine();
                        System.out.println("Apellidos: ");
                        apellidos=sc.nextLine();
                        System.out.println("Ciudad: ");
                        ciudad=sc.nextLine();
                        bf.write(nombre +"\n");
                        bf.write(apellidos +"\n");
                        bf.write(ciudad + "\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    if (archivo==""){
                        System.out.println("No existe el fichero");
                    }else {
                        System.out.println("Contenido del fichero: ");
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
