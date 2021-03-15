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
        String str = "上海鸿翼";
        FileOutputStream fileOutputStream = new FileOutputStream(new File("1.txt"));
        FileChannel channel = fileOutputStream.getChannel();

        ByteBuffer allocate = ByteBuffer.allocate(1024);
        ByteBuffer put = allocate.put(str.getBytes());

        int read = channel.write(allocate);

        System.out.println(new String(allocate.array()));
    }

}
