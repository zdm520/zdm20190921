package ioStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String HOST="127.0.0.1";
    private static final int PORT=9000;

    public static void main(String[] args)throws IOException {
        Socket client=new Socket(HOST,PORT);
        BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out=new PrintWriter(client.getOutputStream(),true);
        //这读取会阻塞在main线程，要创建一个线程来处理这个任务
        Scanner sc=new Scanner(System.in);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (sc.hasNext()){
                    String line=sc.nextLine();
                    out.println(line);
                }
            }
        }).start();
        String str;
        while ((str=in.readLine())!=null){
            System.out.println(str);
        }
    }
}
