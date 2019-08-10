package com.example.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SimpleServer {
    public static void main(String[] args) throws IOException {

        try {
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.configureBlocking(false);
            channel.socket().bind(new InetSocketAddress(8081));

            Selector selector = Selector.open();
            channel.register(selector, SelectionKey.OP_ACCEPT);


            while (true) {

                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    // SelectionKey封装了一个通道和选择器的注册关系
                    SelectionKey key = (SelectionKey) iterator.next();
                    if (key.isAcceptable()) {
                        System.out.println("接受连接");

                    } else if (key.isConnectable()) {
                        System.out.println("连接");
                    } else if (key.isReadable()) {
                        System.out.println("读取");
                        ServerSocketChannel socketChannel = (ServerSocketChannel)  key.channel();
                        //socketChannel.accept().read("");
                    } else if (key.isWritable()) {
                        System.out.println("写入");
                    }
                }
                    // Selector不会移除SelectionKey 处理完了手动移除
                    // iterator.remove();
            }

        } catch (Exception e) {
            e.printStackTrace();

        }


    }
}
