import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SplitFile{
    /**
     * 
     * @Description 文件分割

     * @param src    分割文件路径
     * @param m        大小    
     * @throws IOException
     */
    public static void splitFileDemo(File src, int m) throws IOException {
        if(src.isFile()) {
            //获取文件的总长度
            long l = src.length();
            //获取文件名
            String fileName = src.getName().substring(0, src.getName().indexOf("."));
            //获取文件后缀
            String endName = src.getName().substring(src.getName().lastIndexOf("."));
            System.out.println(endName);
            InputStream in = null;
            try {
                in = new FileInputStream(src);
                for(int i = 1; i <= m; i++) {
                    StringBuffer sb = new StringBuffer();
                    // sb.append(src.getParent());
                    // sb.append("\\");
                    sb.append(fileName);
                    sb.append("_data");
                    sb.append(i);
                    sb.append(endName);
                    System.out.println(sb.toString());
                    
                    File file2 = new File(sb.toString());
                    //创建写文件的输出流
                    OutputStream out = new FileOutputStream(file2);
                    int len = -1;
                    byte[] bytes = new byte[10*1024*1024];
                    
                    while((len = in.read(bytes))!=-1) {
                        for(int j = 0;j < len ; j++){
                            out.write(0xaa);
                            out.write(bytes[j]);
                            out.write(0x0a);
                        }
                        // out.write(bytes, 0, len);
                        // if(file2.length() > (l / m)) {
                        //     break;
                        // }
                    }
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if(in != null)
                    in.close();
            }
            System.out.println("--- 文件分割完成 ---");
        }
    }
}