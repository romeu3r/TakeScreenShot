package application;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Program {

    public static void main(String[] args) {
        getNameSelfClass();
        firstTimePrint("c://temp", "First print.jpg");
    }

    static void getNameSelfClass() {
        String test = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println(test);
    }

    static void firstTimePrint(String path, String fileName) {
        try {
            Robot robot = new Robot();
            int x = Toolkit.getDefaultToolkit().getScreenSize().width;
            int y = Toolkit.getDefaultToolkit().getScreenSize().height;
            /*Create Folders*/ boolean destiny = new File(path).mkdirs();
            File file = new File(path + File.separator + fileName);
            BufferedImage bi = robot.createScreenCapture(new Rectangle(x, y));
            ImageIO.write(bi, "jpg", file);
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
