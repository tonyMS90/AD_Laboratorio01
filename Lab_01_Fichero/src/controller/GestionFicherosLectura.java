package controller;

import java.io.*;

public class GestionFicherosLectura {

    //ACTIVIDAD PROPUESTA

        /*Parte 1: Listar el nombre de todos los ficheros ubicados en un directorio
        (en clase hemos puesto como ejemplo un directorio creado en el paquete resources)
         */
    //src/resources/directorio
    public void lecturaDirectorios(String path) {
        //File (logico) --> File (fisico)

        File file = new File(path);
        //String [] nombres = file.list(); PARA HACERLO DE OTRA FORMA
        File[] ficheros = file.listFiles();
        for (File item : ficheros) {
            //if (item.isHidden()) -> solo mostrar los que no son ocultos
            System.out.println(item.getName());
            if (item.isDirectory()) {
                File[] subdirectorio = item.listFiles();
                for (File sub : subdirectorio) {
                    System.out.println("\t" + sub.getName());
                }
            }
        }
    }    /*
           Forma de hacerlo con String

           for(String item : nombres){
            if(!(item.charAt(0) == '.')){
                System.out.println(item);
            }
            File file2 = new File("/path");
            System.out.println(file2.getName());

        }*/

        /*Parte 2: Crear un subdirectorio dentro de la carpeta anterior
        y listar el nombre de todos los archivos */

        public void lecturaRecursiva(String path){
            File file = new File(path);//Paso a un fichero logico y fisico
            File[] ficheros = file.listFiles();

            //PREGUNTO SI ES DIRECTORIO
            //SACO TODOS LOS FICHEROS DEL DIRECTORIO Y LOS MUESTRO --> NO SE CUANTAS VECES PREGUNTO
            for(File item : ficheros){
                System.out.println(item.getName());
                if(item.isDirectory()){
                    lecturaSubdirectorios(item);
                }

            }

        }
        //LE DECIMOS AL METODO PRIVADO QUE SE RECORRA LA LISTA DE LOS FICHERO Y QUE CUANDOS SEA DIRECTORIO, IMPRIMA LOS FICHEROS DE ESE DIRECTORIO
        //RECURSIVIDAD -> EJECUCION QUE SE LLAMA A ELLA MISMA, CON CUIDADO QUE TENGA UNA SALIDA
        private void lecturaSubdirectorios(File ficheros){
            for(File file : ficheros.listFiles()){
                System.out.println("\t" + file.getName());
                if(file.isDirectory()){
                    lecturaSubdirectorios(file);
                }
            }
        }

    public void lecturaTextoPlano(String path) {
        // FILE -> FILEREADER -> BUFFEREDREADER  -> cuando se terminan SE CIERRAN
        File file = new File(path);
        //FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        if (file.exists() && file.isFile()) {
            // existe y ademas es un fichero
            // trato la excepcion aqui
            try {
                //fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(new FileReader(file));
                /* LECTURA CON FILEREADER
                int lectura=0;
                // mientras exista el numero haz la lectura e imprime
                while ((lectura = fileReader.read())!=-1){
                    // imprime
                    System.out.print((char) lectura);
                }*/
                String lectura = null;
                // String lecturaCompleta = null;
                // StringBuffer lecturaCompleta = new StringBuffer(); -> sincronizado (si tengo varios hilos, se
                // cominucan entre ellos para decir quien tiene el objeto ocupado
                StringBuilder lecturaCompleta = new StringBuilder(); // solo lo va a utilizar un hilo
                while ((lectura = bufferedReader.readLine())!=null){
                    //System.out.println(lectura);
                    //lecturaCompleta+=lectura;
                    lecturaCompleta.append(lectura);
                    lecturaCompleta.append("\n");
                }
                System.out.println(lecturaCompleta.toString());
                // JSON
                // toda la lectura
                /*int lectura = fileReader.read(); // int -> UNICODE ASCI
                System.out.print((char) lectura);
                lectura = fileReader.read(); // int -> UNICODE ASCI
                System.out.print((char) lectura);
                lectura = fileReader.read(); // int -> UNICODE ASCI
                System.out.print((char) lectura);*/

            } catch (FileNotFoundException e) {
                System.out.println("Fallo en la lectura");
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("Error en la escritura, fallo de permisos");
            } finally {
                // se ejecuta SI o SI
                try {
                    bufferedReader.close(); // NULLPOINTEREXCEPTION
                } catch (IOException e) {
                    System.out.println("Error en el cerrado del flujo");
                    System.out.println(e.getMessage());
                    // por favor introduce una ruta valida
                } catch (Exception e) {
                    System.out.println("Error en el cerrado por ser nulo");
                }
            }
        }

    }



}
