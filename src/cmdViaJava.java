import java.io.IOException;
import java.util.Scanner;

public class cmdViaJava {

    public static void main(String[] args) throws IOException {

        try{

            //cmd

            Scanner cmdScanner = new Scanner(System.in);

            String comando;

            ProcessBuilder cmdProcess = new ProcessBuilder();
            cmdProcess.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            cmdProcess.redirectError(ProcessBuilder.Redirect.INHERIT);

            while (true){

                comando = cmdScanner.nextLine();

                cmdProcess.command("cmd", "/C", comando);

                cmdProcess.start();

                if(comando.equalsIgnoreCase("exit")){
                    break;
                }
            }

        }   catch(Exception e){
            e.printStackTrace();
        }

    }
}
