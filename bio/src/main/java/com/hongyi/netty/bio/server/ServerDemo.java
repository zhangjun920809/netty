package com.hongyi.netty.bio.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author User
 * @date 2021/3/10 13:06
 */
public class ServerDemo {
    public static void main(String[] args) throws Exception {
        //启动后通过telnet测试  ctrl + ], 'send xxxx' 发送消息
        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(9988);

        while(true){
            System.out.println("server等待接收消息----,线程名："+Thread.currentThread().getName());
            Socket socket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    procesMessage(socket);
                }
            });
        }
    }
    public static void procesMessage(Socket socket)  {

        try {
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            System.out.println("线程名称："+Thread.currentThread().getName());
            while(true){
                System.out.println("read...");
                int read = inputStream.read(bytes);
                if (read > -1) {
                    System.out.println(new String(bytes,0,read));
                }else {
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
