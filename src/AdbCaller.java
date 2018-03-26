import java.awt.Point;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AdbCaller{
    static Lock lock = new ReentrantLock();
    public static void call(Point m) {
        try {
            lock.lock();
            Runtime.getRuntime().exec(Constants.ADB_PATH + " shell input touchscreen swipe "+ m.x +" "+ m.y +" "+ m.x +" "+ m.y +" 100");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public static void printScreen() {
        try {
            lock.lock();
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
        }finally{
            lock.unlock();
        }
    }
}