import java.io.*;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {

        

        try{

            Scanner scanner = new Scanner(System.in);

            File projectPath = new File("src/scripts/script.py");

            ProcessBuilder pb = new ProcessBuilder().command("python.exe", projectPath.getAbsolutePath() );  
            
            Process elPruses = pb.start();

            InputStream inputStream = elPruses.getInputStream();

            BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));
            String line;


            line = bfr.readLine();
            System.out.println(line);


            System.out.println("Decíme tu nombre");
            String nombre = scanner.nextLine();

            OutputStream outStream = elPruses.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outStream));
            bw.write(nombre);

            /* hacemos enter y borramos la data de este lado*/

            bw.newLine();
            bw.flush();

            /* escuchamos a ver que nos dice */

            line = bfr.readLine();
            System.out.println(line);

            System.out.println("¿Cómo te apellidas?");
            String apellidos = scanner.nextLine();
            bw.write(apellidos);

            bw.newLine();
            bw.flush();

            line = bfr.readLine();
            System.out.println(line);

            System.out.println("Dime el número de tu cuenta bancaria");
            String cuentaBank = scanner.nextLine();
            bw.write(cuentaBank);

            bw.newLine();
            bw.flush();

            line = bfr.readLine();
            System.out.println(line);

            inputStream.close();
            bfr.close();
            outStream.close();
            bw.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }



}
