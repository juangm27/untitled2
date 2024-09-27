import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Practica2_E2_AD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre,apellido,residencia,sexo;
        int suspensos,edad;
        double ingresosAnuales;
        System.out.println("Ingrese su nombre: ");
        nombre = sc.nextLine();
        System.out.println("Ingrese su apellido: ");
        apellido = sc.nextLine();
        System.out.println("Ingrese su sexo(H/M): ");
        sexo = sc.nextLine();
        System.out.println("Ingrese su suspensos(0-4): ");
        suspensos = sc.nextInt();
        System.out.println("Ingrese su edad(20-60): ");
        edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Residencia familiar(Si/No): ");
        residencia = sc.nextLine();
        System.out.println("Ingrese sus ingresos anuales: ");
        ingresosAnuales = sc.nextDouble();

        Becario b=new Becario(nombre,apellido,sexo,edad,suspensos,residencia,ingresosAnuales);

        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("datosbeca.bin"))) {
            oos.writeObject(b);
            System.out.println("Datos becario guardado");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
