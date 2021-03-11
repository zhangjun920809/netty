package com.hongyi.nio.buffer;

import java.nio.IntBuffer;

/**
 * @author User
 * @date 2021/3/11 12:20
 */
public class BufferTest {
    public static void main(String[] args) {
        /**
         * buffer源码中几个重要的属性：
         *    关系: mark <= position <= limit <= capacity
         *    mark：
         *    limit ：在写模式下，Buffer的limit表示你最多能往Buffer里写多少数据。 写模式下，limit等于Buffer的capacity。
         *             当切换Buffer到读模式时， limit表示你最多能读到多少数据。因此，当切换Buffer到读模式时，limit会被设置成写模式下的position值。换句话说，你能读到之前写入的所有数据（limit被设置成已写数据的数量，这个值在写模式下就是position）

         *    position：当你写数据到Buffer中时，position表示当前的位置。初始的position值为0.当一个byte、long等数据写到Buffer后， position会向前移动到下一个可插入数据的Buffer单元。position最大可为capacity.
         *              当读取数据时，也是从某个特定位置读。当将Buffer从写模式切换到读模式，position会被重置为0. 当从Buffer的position处读取数据时，position向前移动到下一个可读的位置

         *    capacity：创建buffer时指定的容量，不可修改的。
         */
        //创建一个容量为5的intbuffer
        IntBuffer intBuffer = IntBuffer.allocate(5);
        //循环添加数据
        for (int i = 1; i <= intBuffer.capacity() ; i++) {
            intBuffer.put(i*2);
        }
        //buffer的读写切换
        intBuffer.flip();
        // 读取数据
        for (int i = 0; i < intBuffer.capacity() ; i++) {
            int i1 = intBuffer.get();
            System.out.println(i1);
        }
        //清空缓冲区
        intBuffer.clear();
    }
}
