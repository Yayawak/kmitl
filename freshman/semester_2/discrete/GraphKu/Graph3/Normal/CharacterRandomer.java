import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

import javax.xml.transform.Source;

public class CharacterRandomer {
    public static void main(String[] args) {
        String newFileName = "log.py";
        writeRandomCharsFile(newFileName);
    }

    static void writeRandomCharsFile(String fName) {
        String absPath = new File("").getAbsolutePath()
            + "/" + fName;
        // System.out.println(absPath);
        try {
            FileWriter fw = new FileWriter(absPath);
            fw.write(
                randomChars(100)
            );
            fw.close();
        } catch (Exception e) {
            System.out.println("some error occured");
            e.printStackTrace();
        }
    }

    static char[] randomChars(int len) {
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            char c = (char)(Math.random() * 1000);
            while (Character.isWhitespace(c))
                c = (char)(Math.random() * 1000);
            if (i % 20 == 0) {
                c = '\n';
                continue;
            }
            chars[i] = c;
        }
        return chars;
    }
}
