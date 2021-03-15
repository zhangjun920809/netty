package com.hongyi.nio.buffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Zhangjun
 * @create 2021-03-15 22:16
 */
public class BufferCopy {
    public static void main(String[] args) throws Exception{
        //创建输入流
        FileInputStream fileInputStream = new FileInputStream(new File("from.txt"));
        FileChannel channel = fileInputStream.getChannel();
        //创建输出流
        FileOutputStream fileOutputStream = new FileOutputStream(new File("to.txt"));
        FileChannel channel1 = fileOutputStream.getChannel();
        //创建buffer
        ByteBuffer allocate = ByteBuffer.allocate(512);
        //循环读写取数据
        while(true){
            //读取数据
            int read = channel.read(allocate);
            if (read == -1){
                break;
            }
            //写数据
            allocate.flip();
            int write = channel1.write(allocate);
            //把buffer中的几个属性重置。 本质没有删除数据。
            allocate.clear();
          /*  public final Buffer clear() {
                position = 0;
                limit = capacity;
                mark = -1;
                return this;
            }*/
        }

    }
}
