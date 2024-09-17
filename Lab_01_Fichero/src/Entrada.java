import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.io.IOException;


public class Entrada {
    public static void main(String[] args) {
        File fichero = new File("src/resources/directorio/ejemplo_fichero1.txt");

        File nuevoFichero = new File("src/resources/directorio/ejemplo_fichero3.txt");

        File directorio1 = new File("src/resources/directorio");
        if (!nuevoFichero.exists()){
            try {
                nuevoFichero.createNewFile();
            } catch (IOException e) {
                System.out.println("El nombre del fichero ya existe");
            }
        }
        //NOMBRE DEL FICHERO
        System.out.println(fichero.getName());
        System.out.println(nuevoFichero.getName());
        //FILE [] --> todos los FICHEROS que estan dentro del directorio
        directorio1.listFiles();
        System.out.println(directorio1.listFiles());

        System.out.println();
    }

}
