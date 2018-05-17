import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.security.auth.Refreshable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;

/**
 * mian
 */
public class Hello extends JFrame{
    private static final long serialVersionUID = 1L;
    private static Point fPoint;
    public static float zoom;
    public static Hello hello;
    /**
     * Creates new form NewJFrame
     */
    public Hello() {
        setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
	public static void main(String args[]) throws IOException {
        SplitFile.splitFileDemo(new File("RTC55.bin"), 1);
        // AdbCaller.printScreen();
        // hello = new Hello();
        // hello.setVisible(true);
        // JPanel jPanel = new JPanel(){
        //     /**
        //      * serialVersionId
        //      */
        //     private static final long serialVersionUID = -1183754274585001429L;

        //     protected void paintComponent(Graphics g){
        //         super.paintComponent(g);
        //         try{
        //             BufferedImage bufferedImage = ImageIO.read(new File(Constants.SCREENSHOT_LOCATION));
        //             setPointZoom(bufferedImage);
        //             BufferedImage newImage = new BufferedImage(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, bufferedImage.getType());
        //             /**
        //              * try to resize
        //              */
        //             Graphics gTemp = newImage.getGraphics();
        //             gTemp.drawImage(bufferedImage, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
        //             gTemp.dispose();
        //             bufferedImage = newImage;
        //             g.drawImage(bufferedImage, 0, 0, null);
        //         } catch (IOException e) {
        //             e.printStackTrace();
        //         }
        //     }
        // };
        // hello.getContentPane().add(jPanel);
        // hello.getContentPane().getComponent(0).addMouseListener(new MouseListener(){
        
        //     @Override
        //     public void mouseReleased(MouseEvent e) {
                
        //     }
        
        //     @Override
        //     public void mousePressed(MouseEvent e) {
                
        //     }
        
        //     @Override
        //     public void mouseExited(MouseEvent e) {
                
        //     }
        
        //     @Override
        //     public void mouseEntered(MouseEvent e) {
                
        //     }
        
        //     @Override
        //     public void mouseClicked(MouseEvent e) {
        //         System.out.println("first " + e.getX() + " " + e.getY());
        //             fPoint = e.getPoint();
        //             AdbCaller.call(changePoint(fPoint));
        //     }
        // }); 
        // Timer timer = new Timer(true);
        // timer.schedule(new TimerTask(){
        
        //     @Override
        //     public void run() {
        //         refresh();
        //     }
        // }, 1000, 1000);  
    }
    /**
     * 刷新屏幕
     */
    public static void refresh(){
        AdbCaller.printScreen();
        JPanel jp = ((JPanel) Hello.hello.getContentPane().getComponent(0));
        jp.validate();
        jp.repaint();
    }
    /**
     * 鼠标点击坐标缩放比例
     */
    public static void setPointZoom(BufferedImage image){
        zoom = (float)image.getWidth()/(float)Constants.SCREEN_WIDTH;
    }
    /**
     * 坐标转化
     */
    public static Point changePoint(Point point){
        point.x *= zoom; 
        point.y *= zoom;
        return point;
    }
    /**
     * 实现图像的等比缩放
     *
     * @param source  待处理的图片流
     * @param targetW 宽度
     * @param targetH 高度
     * @return
     */
    public static BufferedImage resize(BufferedImage source) {
        int width = source.getWidth();// 图片宽度
        int height = source.getHeight();// 图片高度
        return zoomInImage(source, width, height);
    }

    /**
     * 对图片进行强制放大或缩小
     *
     * @param originalImage 原始图片
     * @return
     */
    public static BufferedImage zoomInImage(BufferedImage originalImage, int width, int height) {
        BufferedImage newImage = new BufferedImage(width, height, originalImage.getType());

        Graphics g = newImage.getGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();
        return newImage;
    }
}


