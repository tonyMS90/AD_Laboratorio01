package controller;

import java.io.*;
import java.util.Scanner;

import static java.lang.System.*;

public class PruebaFicheros {

    //Crear un nuevo fichero

    public void nuevoFichero(String path){
        File file = new File(path);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                out.println("El fichero ya existe, error en la creación.");
            }
        }
        //Listar los ficheros por nombre de un directorio

       File[] ficheros = file.listFiles();

        for (File item: ficheros) {
            out.println(item.getName());
            if (item.isDirectory()){
                File[] subdir = item.listFiles();
                for (File s : subdir){
                    out.println("\t" + s.getName());
                }

            }
        }



    }

    public void escribirFichero(String path){

        //Scanner scanner = new Scanner(System.in);
        File file = new File(path);
        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(file);
            printWriter.println("linea escrita de prueba");
            printWriter.println("linea con salto de prueba. Yeeeees conseguidoooo");
        } catch (FileNotFoundException e) {
            out.println("error al escribir el archivo.");;
        }finally {
            try{
                printWriter.close();
            }catch (NullPointerException e){
                out.println("Error en el cierre del flujo.");
            }
        }
    }

    public void leerFichero(String path){
        File file = new File(path);
        BufferedReader bufferedReader = null;

        if (file.exists() && file.isFile()){
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                String lectura = null;
                StringBuilder lecturaCompleta = new StringBuilder();
                while ((lectura = bufferedReader.readLine())!=null){
                    lecturaCompleta.append(lectura);
                    lecturaCompleta.append("\n");
                }
                out.println(lecturaCompleta.toString());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                try{
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }

    //Escribir "Dale a tu cuerpo alegria macarena en un archivo existente"
    //Leer lo que hemos escrito anteriormente en el fichero.
}
