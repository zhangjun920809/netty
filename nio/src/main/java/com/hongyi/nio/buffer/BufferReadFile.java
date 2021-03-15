package com.hongyi.nio.buffer;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author User
 * @date 2021/3/15 12:25
 */
public class BufferReadFile {
    public static void main(String[] args) throws Exception{
        //创建一个输入流
        FileInputStream fileInputStream = new FileInputStream(new File("2.txt"));
        //通过输入流获取channel
        FileChannel channel = fileInputStream.getChannel();
        //创建输入流长度的buffer
        ByteBuffer allocate = ByteBuffer.allocate(fileInputStream.available());
        //将输入读入到buffer中
        int read = channel.read(allocate);
        //读写切换
        allocate.flip();
        //取出buffer中的数据
        byte[] array = allocate.array();
        //输出buffer中的数据
        System.out.println(new String(array));
        //关闭流
        fileInputStream.close();
    }
}
