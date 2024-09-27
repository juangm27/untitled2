import java.io.File;

public class Practica1_E1_AD {
    public static void main(String[] args) {
        File directorio=new File(".");
        if (!directorio.exists()){
            System.out.println("El directorio no existe");
        }else{
            for (File file : directorio.listFiles()) {
                System.out.println(file.getName());
            }
        }
    }
}
