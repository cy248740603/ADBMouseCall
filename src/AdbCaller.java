import java.awt.Point;
import java.io.IOException;

public class AdbCaller{

    public static void call(Point m) {
        try {
            Runtime.getRuntime().exec(Constants.ADB_PATH + " shell input touchscreen swipe "+ m.x +" "+ m.y +" "+ m.x +" "+ m.y +" 100");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printScreen() {
        try {
            String[] args = new String[]{
                "bash",
                "-c",
                Constants.ADB_PATH + " exec-out screencap -p > " + Constants.SCREENSHOT_LOCATION};
            String os = System.getProperty("os.name");
            if (os.toLowerCase().startsWith("win")) {
                args[0] = "cmd";
                args[1] = "/c";
            }
            Process p1 = Runtime.getRuntime().exec(args);
            p1.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}