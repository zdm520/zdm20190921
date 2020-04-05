package ioStudy;
import org.junit.Test;
import java.io.*;
public class FileOperatorTest {
    @Test
    public void fileRead1()throws IOException {
        //字节流转换为字符流，需要使用字节字符转换流
        //InputStreamReader:输入的字节字符转换流
        //OutStreamReader:输入的字节字符转换流
        //转换流可以设置编码：java的文件编码格式，文件的编码格式
        FileInputStream fis=new FileInputStream (
                new File("E:\\java13\\thread-study\\res/info.txt")
        );
        BufferedReader br=new BufferedReader(new InputStreamReader(fis,"UTF-8"));
            //按行输出
//        String line;
//        while ((line=br.readLine())!=null){
//            System.out.println(line);
//        }
        //转换为字符数组
        char[] chars=new char[1024];
        int len;
        while ((len=br.read(chars,0,1024))!=-1){
            String str=new String(chars,0,len);
            System.out.println(str);
        }
    }
    @Test
    public void filewrite1()throws IOException{
        FileOutputStream fos=new FileOutputStream(
                new File("E:\\java13\\thread-study\\res/info.txt"));
                BufferedWriter bw=new BufferedWriter
                (new OutputStreamWriter(fos,"UTF-8"));
                bw.write("毛不易好帅\n");
                bw.write("巨星啊巨星\n");
                bw.write("未来加油");
                bw.flush();
    }
    @Test
    public void fileCopy()throws IOException{
        FileInputStream fis=null;
        BufferedInputStream bi=null;
        FileOutputStream fos=null;
        BufferedOutputStream bo=null;
        try {
            //使用缓冲流操作复制文件内容到另一个文件
            fis=new FileInputStream (
                    new File("E:\\java13\\thread-study\\res/info.txt")
            );
            bi=new BufferedInputStream(fis);
            fos=new FileOutputStream(
                    new File("E:\\java13\\thread-study\\res/info1.txt"));
            bo=new BufferedOutputStream(fos);
            byte[] bytes=new byte[1024*8];
            while ((fis.read(bytes))!=-1){
                bo.write(bytes);
                bo.flush();
            }
        }finally {
            if(fis!=null){
                fis.close();
            }
            if(bi!=null){
                bi.close();
            }
            if(fos!=null){
                fos.close();
            }
            if(bo!=null){
                bo.close();
            }
        }
    }

}
