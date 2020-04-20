package ioStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int PORT=8080;

    private static final ExecutorService pool=Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket ser=new ServerSocket(PORT);
        while (true){
            //阻塞等待，直到有新的客户端连接
            Socket client=ser.accept();
            pool.execute(new Task(client));
        }

    }
    private static class Task implements Runnable{
        private Socket client;
        Scanner sc=new Scanner(System.in);
        public Task(Socket client){
            this.client=client;
        }
        @Override
        public void run(){
            try {
                BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out=new PrintWriter(client.getOutputStream(),true);
                String str;
                while ((str=in.readLine())!=null){
                    System.out.println(str);
                    String rs=sc.nextLine();
                    out.println(rs);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}




