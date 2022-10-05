import java.io.*;
import java.util.Scanner;

public class doblePruses {

    public static void main(String[] args) throws IOException {



        try{

            File projectPath = new File("src/scripts/getVariables.py");

            File printPath = new File("src/scripts/print.py");

            ProcessBuilder pb = new ProcessBuilder().command("python.exe", projectPath.getAbsolutePath() );

            ProcessBuilder pb2 = new ProcessBuilder().command("python.exe", printPath.getAbsolutePath() );

            pb.redirectInput(ProcessBuilder.Redirect.INHERIT);

            pb2.redirectOutput(ProcessBuilder.Redirect.INHERIT);

            Process elPruses = pb.start();
            Process sisplauCatalunya = pb2.start();

            InputStream inputStream = elPruses.getInputStream();

            BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            String resp = null;

            while ((line = bfr.readLine()) != null){
                System.out.println(line);
                resp = line;
            }

            InputStream IS = sisplauCatalunya.getInputStream();

            BufferedReader bfrCAT = new BufferedReader(new InputStreamReader(IS));

            OutputStream outStream = sisplauCatalunya.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outStream));
            bw.write(resp);


            /* hacemos enter y borramos la data de este lado*/

            bw.newLine();
            bw.flush();

            inputStream.close();
            bfr.close();
            IS.close();
            bfrCAT.close();
            outStream.close();
            bw.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }



}

