package NIO2.File;

import java.io.*;
import java.nio.file.*;


import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;

/**
 * Created by lijiahe on 2017/10/12.
 */
//BASE ON JDK8
public class base_read_file {
    private  Path file;

    public base_read_file(String url){
        this.file=Paths.get(url);
    }

    //nio2.0读取文件

    //nio创建文件
    public  void create_file(){
        //Posix文件权限集合
       // Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-rw-rw-");
      //  FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
        try {
            Files.createFile(file);
        }catch (IOException E){
            E.printStackTrace();
        }
    }
    //nio写文件
    public  void read_file(){
        InputStream is=null;
        try {
            is=Files.newInputStream(file,READ);
            /** --------Method1
            int datas=0;
            while((datas=is.read())!=-1){
                System.out.print((char)datas);
            }*/
            /**
             * --------Method2,正常读取中文字符串
             */
            byte[] data=new byte[1024];
            int len=0;
            while ((len=is.read(data))!=-1){
                System.out.print(new String(data,0,len));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                is.close();
            }catch (IOException E){
                E.printStackTrace();
            }
        }
    }
    public void stream_file_write(){
        try {
            /*File jj=new File("");
            FileOutputStream fops=new FileOutputStream(jj);//io*/
            OutputStream is= Files.newOutputStream(file,WRITE);//nio
            is.write("adasdsad".getBytes());
            is.close();
        }catch ( Exception e){
            e.printStackTrace();
        }
    }
    public void bufferedStream_read(){
        try {
          //BufferedReader br=Files.newBufferedReader()
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public void directly_file_get(){
        try {
            System.out.print(Files.getFileStore(file));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //MOVE_FILE
    public  void move_file(String...urls){
            for(String h:urls){
                try {
                    Files.move(file,Paths.get(h),REPLACE_EXISTING);
                }catch (IOException E){
                    E.printStackTrace();
                }
            }
    }

    public  void  delete_file(){
        try {
            Files.delete(file);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //拷贝复制文件
    public  void copy_file(String...files){
       for(String k : files){
           try {
               Files.copy(file,Paths.get(k),REPLACE_EXISTING);
           }catch (Exception e){
               e.printStackTrace();
           }
       }
    }

    public static void main(String[] args) {
        base_read_file brf=new base_read_file("text_new1.txt");
       // brf.create_file();
       /* brf.copy_file("text_new1.txt","text_new2.txt");
        brf.move_file("text_move1.txt");*/
        brf.read_file();

    }


}
