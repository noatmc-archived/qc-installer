import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter version (0.5.0, 0.5.1, 0.5.2, 0.6.0) -> ");
        String str=sc.nextLine();
        if (checks(str)) {
            try {
                System.out.println("your quantum file will be found at -> "+System.getProperty("user.home") + "\\AppData\\Roaming\\.minecraft\\mods\\1.12.2\\quantum-client.jar");
                downloadFile(new URL("https://github.com/fan4145/quantum-continued-releases/releases/download/" + str + "/quantum-continued-" + str + ".jar "), System.getProperty("user.home") + "\\AppData\\Roaming\\.minecraft\\mods\\1.12.2\\quantum-client.jar");
                File jarFile = new File(System.getProperty("user.home") + "\\AppData\\Roaming\\.minecraft\\mods\\1.12.2\\quantum-client.jar");
                System.out.println("downloaded! (" + jarFile.length() + ")");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("invalid :face_with_symbols_over_face:");
        }
    }

    static boolean checks(String str) {
        return str.equals("0.5.0") || str.equals("0.5.1") || str.equals("0.5.2") || str.equals("0.6.0");
    }

    public static void downloadFile(URL url, String fileName) {
        try (InputStream in = url.openStream()) {
            Files.copy(in, Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
