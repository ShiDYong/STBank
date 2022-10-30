package com.mason.chapter_02;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * @author yongshi
 * @date 2022/10/30 17:02
 * @Description File类可以使得普通文件的操作变得快捷，该类提供了一组丰富的静态方法，用于
 *              读取，写入和操作文件和目录。File类适用于处理中等长度的文本文件，如果要处理的文件长度比较大，
 *              或者是二进制文件，应使用熟知的输入/输出/流或者读入器/写出器
 */
public class MethodsOfFile {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
      //   String fileName = "bank-data-simple.csv";
         Path path = Paths.get(RESOURCES);
        //将文件当作二进制读入
        byte[] bytes = Files.readAllBytes(path);
        //将文件当作字符串读入
       String content = new String(bytes,"utf-8");
        System.out.println("content = " + content);

        //将文件当作行序列读入，可以调用
        final List<String> lines = Files.readAllLines(path);

        //将一个字符串写到文件中，可以调用
        Files.write(path,content.getBytes(StandardCharsets.UTF_8));
        //向指定文件追加内容，可以调用
        //Files.write(path,content.getBytes(StandardCharsets.UTF_8, StandardOpenOption.APPEND));
        //将一行的集合写到文件中
        Files.write(path,lines);
        //创建新目录:如果文件已经存在类，那这个调用就会抛出异常
        final Path directory = Files.createDirectory(path);
        System.out.println("directory = " + directory);


    }
}
