package NIO;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by lijiahe on 2018/6/2.
 */
public class Channel {


    public static void copydata(ReadableByteChannel  readableByteChannel,WritableByteChannel writableByteChannel){


        ByteBuffer byteBuffer=ByteBuffer.allocate(200);

        try {
            byteBuffer.clear();
            while((readableByteChannel.read(byteBuffer))!=-1 ){

                byteBuffer.flip();

                while (byteBuffer.hasRemaining()){
                    writableByteChannel.write(byteBuffer);
                }
                byteBuffer.compact();
            }


            byteBuffer.flip();

            while(byteBuffer.hasRemaining()){
                writableByteChannel.write(byteBuffer);
            }
            writableByteChannel.close();

            readableByteChannel.close();

        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }






    }

    public static void main(String[] args) {


        ReadableByteChannel readableByteChannel= Channels.newChannel(System.in);

        WritableByteChannel writableByteChannel=Channels.newChannel(System.out);

        copydata(readableByteChannel,writableByteChannel);



    }


}
