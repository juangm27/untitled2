import java.io.*;
import java.util.Scanner;

public class Practica2_E1_AD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file=new File("persona.dat");
        int opcion;
            do {
                System.out.println("Menu:");
                System.out.println("1. Crear Persona");
                System.out.println("2. Imprimir fichero");
                System.out.println("3. Salir");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        sc.nextLine();
                        System.out.println("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.println("Edad: ");
                        int edad = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Ciudad: ");
                        String ciudad = sc.nextLine();
                        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
                            dos.writeUTF(nombre);
                            dos.writeInt(edad);
                            dos.writeUTF(ciudad);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 2:
                        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {

                            String nombre2 = dis.readUTF();
                            int edad2 = dis.readInt();
                            String ciudad2 = dis.readUTF();
                            System.out.println("Nombre: " + nombre2);
                            System.out.println("Edad: " + edad2);
                            System.out.println("Ciudad: " + ciudad2);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 3:
                        System.out.println("Adios!!!");
                        break;
                }
            } while (opcion != 3);
    }
}
