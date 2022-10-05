package scripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class waitFor {

    public static void main(String[] args) throws IOException, InterruptedException {

        File infinito = new File("src/scripts/infinito.py");

        File printUnico = new File("src/scripts/printUnico.py");

        ProcessBuilder pb = new ProcessBuilder().command("python.exe", infinito.getAbsolutePath() );

        ProcessBuilder pb2 = new ProcessBuilder().command("python.exe", printUnico.getAbsolutePath() );

        //para que salga en la consola

        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb2.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        Process p1 = pb.start();

        p1.waitFor(3000, TimeUnit.MILLISECONDS);
        p1.destroy();
        Process p2 = pb2.start();

    }
}
