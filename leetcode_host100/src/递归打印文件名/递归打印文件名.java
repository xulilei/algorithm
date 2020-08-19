package 递归打印文件名;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

public class 递归打印文件名 {
    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("C:\\Users\\xu\\Desktop\\MyHEXO\\blog\\source\\_posts");
        printSrc(file);

    }
    public static void printSrc(File src){
        if(src==null||!src.exists())return;
        System.out.println(src.getName());
        if(src.isDirectory()){
            for(File file: src.listFiles()){
                printSrc(file);
            }
        }
    }
}
