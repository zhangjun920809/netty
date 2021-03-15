package com.hongyi.nio.buffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author User
 * @date 2021/3/15 12:25
 */
public class BufferWriteToFile {
    public static void main(String[] args) throws Exception{
        String str = "上海hongyi";
        //创建输出流  默认创建在项目根目录下
        FileOutputStream fileOutputStream = new FileOutputStream(new File("1.txt"));
        FileChannel channel = fileOutputStream.getChannel();
        //创建buffer  并且将str数据存入buffer
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        ByteBuffer put = allocate.put(str.getBytes());
        //读写切换
        put.flip();
        //把buffer中的数据写入到channel
        int read = channel.write(allocate);
        //关闭流
        channel.close();
        System.out.println(new String(allocate.array()));
    }

}
