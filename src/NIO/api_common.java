package NIO;


import java.nio.ByteBuffer;

/**
 * @author shawn
 * @date 2018/6/2 10:39
 * @methodname
 * @param  * @param null    api的学习
 * @return
 * @discription*/
public class api_common {



     //


     public  void  put(){

     }

    public static void main(String[] args) {
        //buffer 四个基本概念的顺序
        //mark<=postion<=limit<=cap
        //allocate space for bytebuffer
        ByteBuffer byteBuffer= ByteBuffer.allocate(16);
        //allocateDirect,可以创建一个直接缓冲区，提高io传输的效率，推荐
        ByteBuffer byteBuffer_direct=ByteBuffer.allocateDirect(16);

        // 默认新创建的buffer limit=cap，，使用HeapByteBuffer(limit,cap) 来分别指定；
    //put byte-----------存入数据
        byteBuffer.putChar('H').putChar('E').putChar('l').putChar('l').putChar('o');
    //从buffer中获取数据，，将limit置于现在的postion，并将起始节点postion置为0
        byteBuffer.limit(byteBuffer.position()).position(0);  //==byteBuffer.flip()
        //
     //   byteBuffer.rewind(); //rewind将position置为0，重读已经被翻转的缓冲区中的数据
        //get方法获取下个postion的数据，postion++
//        System.out.println(byteBuffer.getChar());
//        System.out.println(byteBuffer.position());
//        System.out.println(byteBuffer.getChar());
//        System.out.println(byteBuffer.getChar());
//        System.out.println(byteBuffer.position());

        StringBuilder sb=new StringBuilder();
        for (int i=0; byteBuffer.hasRemaining();i++){
            sb.append(byteBuffer.getChar());
        }

        System.out.println(sb.toString());
        System.out.println(byteBuffer.position());

        ByteBuffer by=byteBuffer.duplicate();

        System.out.println(by.hasArray());
        System.out.println(by.array().length);
        //clear 方法将缓冲区重置
        by.clear();
        System.out.println(by.array().length);





    }

}
