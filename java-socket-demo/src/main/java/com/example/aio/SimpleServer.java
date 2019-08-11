package com.example.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannel;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

public class SimpleServer {

    public void startUp() throws IOException {
        AsynchronousServerSocketChannel socketChannel = AsynchronousServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress(8082));
        socketChannel.accept(null, new Handler());

    }

    class Handler implements CompletionHandler<AsynchronousSocketChannel,Object> {

        @Override
        public void completed(AsynchronousSocketChannel result, Object attachment) {
            final ByteBuffer buffer = ByteBuffer.allocate(1024);
            try {
                result.read(buffer).get();
                System.out.println("接受:" + new String(buffer.array()));
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void failed(Throwable exc, Object attachment) {

        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        SimpleServer simpleServer = new SimpleServer();
        simpleServer.startUp();
        while(true) {
            System.out.println("main thread");
            Thread.sleep(1000);
        }

    }
}
