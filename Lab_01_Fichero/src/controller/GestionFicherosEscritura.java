package controller;

import java.io.*;
import java.util.Scanner;

public class GestionFicherosEscritura {
    public void escribirFichero(String path){

        //FILE --> FILWRITER (caracter a carcater)-> BUFFEREDWRITTER (linea a linea)-> PRINTWRITTER -> CERRAR

        Scanner scanner = new Scanner(System.in);
        File file = new File(path);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null;



        try {
            fileWriter = new FileWriter(file, false); //append -> anexar o no la escritura
            //bufferedWriter = new BufferedWriter(fileWriter);
            // fileWriter.write(lecturaFrase);
            //bufferedWriter.newLine();
            //bufferedWriter.write(432);
            printWriter = new PrintWriter(file);
            printWriter.println("Linea escrita con un print writer");
            printWriter.println("Otra escrita con un print writer"); // \n

        } catch ( IOException e) {
            System.out.println("Error en la escritura del fichero, por permisos");;
        }finally{
           try{
               //bufferedWriter.close();
               printWriter.close();
           } catch (NullPointerException e) {
               System.out.println("Error en el cierre del flujo");
           }
        }
    }
}
