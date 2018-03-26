public class Constants{
    /**
     * adb所在位置
     */
    public static final String ADB_PATH = "C:\\Users\\Administrator\\AppData\\Local\\Android\\Sdk\\platform-tools\\adb.exe";
    /**
     * 截屏文件所在位置
     */
    public static final String SCREENSHOT_LOCATION = "D:\\vsproject\\s.png";
    // 原作者 675x1200 的尺寸该参数取 2.19
    // 我手机是小米max，1080x1920 分辨率，按比例缩放至 540x960，取 2.85 正合适
    public static final float SWIPE_DEPTH = 2.85f;
    public static final int SCREEN_WIDTH = 540;
    public static final int SCREEN_HEIGHT = 960;    
}