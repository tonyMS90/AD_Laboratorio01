import controller.PruebaFicheros;

public class EntradaPruebaFicheros {
    public static void main(String[] args) {
        PruebaFicheros pruebaFicheros = new PruebaFicheros();
        //pruebaFicheros.nuevoFichero("src/resources/"); //ABRIR NUEVO FICHERO Y LEER TODOS LOS ARCHIVOS DESDE RESOURCES
        //pruebaFicheros.escribirFichero("src/resources/ficheros/pruebaFichNuevo.txt"); //ESCRIBIR EN FICHERO
        pruebaFicheros.leerFichero("src/resources/ficheros/pruebaFichNuevo.txt");
    }
}
