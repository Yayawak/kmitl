package backup_ass_1.Controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageApi {

    public static ImageIcon readImageIconFromFile(String pathstr, int w, int h) 
    {
        return new ImageIcon(
            readImageFromFile(pathstr, w, h)
        );
    }

    public static BufferedImage readImageFromFile(String pathstr, int w, int h) 
    {
        BufferedImage ret = readImageFromFile(pathstr);
        return resizeImage(ret, w, h);
    }

    public static BufferedImage readImageFromFile(String pathstr) 
    {
        // System.out.println(pathstr);
        BufferedImage bufferedImage = null;
        try 
        {
            bufferedImage = ImageIO.read(
                    Files.newInputStream(
                            Paths.get(pathstr)));
        }
        catch (IOException e) 
        {
            System.out.println("Error can't read image path = " + pathstr);
            e.printStackTrace();
        }

        return bufferedImage;
    }

    // public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
    public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight)
    {
        BufferedImage resizedImage = new BufferedImage(
            targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB
        );
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }


}
