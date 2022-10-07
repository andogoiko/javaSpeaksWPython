import java.io.*;
import java.util.Scanner;

public class Lookup {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        //comando nslookup en consola

        /*

        ProcessBuilder nsLookupPB = new ProcessBuilder("cmd", "/C", "nslookup ");
        nsLookupPB.inheritIO(); // hace las 3 redirectInput, redirectOutput y redirectError en (ProcessBuilder.Redirect.INHERIT)

        System.out.println("Introduzca una dirección ip (escriba exit para finalizar):");

        try{

            Process nsLookupProcess = nsLookupPB.start();
            nsLookupProcess.waitFor();

        }catch(IOException e){

            e.printStackTrace();
        }*/

        // mismo ejercicio pero con bufferedWriter

        ProcessBuilder nsLookupPBBuff = new ProcessBuilder("cmd", "/C", "nslookup ");

        try{

            Process process = nsLookupPBBuff.start();

            OutputStream outStream = process.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outStream));

            InputStream inputStream = process.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            while (true){

                System.out.println("Introduzca una dirección ip (escriba exit para finalizar):");

                String dominio = scanner.nextLine();

                bw.write(dominio);
                bw.newLine();
                bw.flush();

                String line;
                String resp = null;

                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                    resp = line;
                    if (line == null){
                        break;
                    }
                }

                if(resp.equalsIgnoreCase("exit")){
                    break;
                }

            }



        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
