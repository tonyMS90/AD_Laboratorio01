import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.io.IOException;


public class Entrada {
    public static void main(String[] args) {
        //File fichero = new File("src/resources/directorio/ejemplo_fichero1.txt");

        //File nuevoFichero = new File("src/resources/directorio/ejemplo_fichero3.txt");

        /*File directorio = new File("src/resources/directorio");
        if (!nuevoFichero.exists()){
            try {
                nuevoFichero.createNewFile();
            } catch (IOException e) {
                System.out.println("El nombre del fichero ya existe");
            }
        }*/
        //NOMBRE DEL FICHERO
        //System.out.println(fichero.getName());
        //System.out.println(nuevoFichero.getName());



        //ACTIVIDAD PROPUESTA

        /*Parte 1: Listar el nombre de todos los ficheros ubicados en un directorio
        (en clase hemos puesto como ejemplo un directorio creado en el paquete resources)
         */

        //FILE [] --> todos los FICHEROS que estan dentro del directorio


        File directorio1 = new File("src/resources/directorio");

        File [] files = directorio1.listFiles();


        for (File fichero : files){
            System.out.println("El nombre de los ficheros que contiene la carpeta directorio es: " + fichero.getName());
        }

        /*Parte 2: Crear un subdirectorio dentro de la carpeta anterior
        y listar el nombre de todos los archivos */

        File subdirectorio = new File("src/resources/directorio/subdirectorio");

        File [] files2 = subdirectorio.listFiles();

        for(File ficheros : files2) {
            System.out.println("el nombre de los ficheros del subdirectorio es: " + ficheros.getName());
        }

        /*Parte 3: Listar el nombre de todos los ficheros y directorios
        de una ruta concreta, como por ejemplo C:/Users
         */

        // Ruta del directorio raíz
        String rutaDirectorioRaiz = "src/resources"; // Cambia esta ruta por la de tu directorio

        // Crear un objeto File apuntando al directorio raíz
        File directorioRaiz = new File("src/resources");

        // Comenzar la recursión
        System.out.println("");
        System.out.println("lista de ficheros y directorios: ");
        System.out.println("");
        listarArchivos(directorioRaiz);
    }

    // Método recursivo par alistar los archivos

    public static void listarArchivos(File directorio) {
        // Asegurarse de que el objeto es un directorio
        if (directorio.isDirectory()) {
            // Obtener todos los archivos y directorios dentro del directorio actual
            File[] listaArchivos = directorio.listFiles();

            if (listaArchivos != null) { // Verifica si no es null
                // Primero recorremos los subdirectorios (llamada recursiva)
                for (File archivo : listaArchivos) {
                    if (archivo.isDirectory()) {
                        listarArchivos(archivo); // Llamada recursiva para subdirectorios
                    }
                }

                // Luego imprimimos los archivos del directorio actual
                for (File archivo : listaArchivos) {
                    if (archivo.isFile()) {
                        System.out.println("Archivo: " + archivo.getAbsolutePath());
                    }
                }

                // Finalmente, mostramos el nombre del directorio después de haber listado los archivos
                System.out.println("Directorio: " + directorio.getAbsolutePath());
            }
        } else {
            System.out.println(directorio.getAbsolutePath() + " no es un directorio válido.");
        }

    }

}
