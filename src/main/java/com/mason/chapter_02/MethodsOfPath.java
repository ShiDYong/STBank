package com.mason.chapter_02;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author yongshi
 * @date 2022/10/30 09:37
 * @Description Java读取目录路径的Path和读取文件的Files类的常见使用
 */
public class MethodsOfPath {
    public static void main(String[] args) {

        /**
         * Java.nio.file包中一个主要入口Path类，类是文件系统中路径程序化表示。一个Path对象包含用于构建路径的文件名和目录列表，用于检查、定位
         * 和操作文件,创建Path实例
         * 常用的方法有：
         *  1.创建Path;检索Path信息；从Path中删除冗余；转换Path;连接两条Path;在两条Path之间创建路径；比较两条Path;
         */
        //读取指定目录下的文件路径
        final Path p1 = Paths.get("/src/main/resources/");
        System.out.println("p1 = " + p1);
        Path p3 = Paths.get(URI.create("file:///Users/yongshi/Downloads/MyCode/Java/spring-security-demo/STBank/src/main/resources/test.property"));
        System.out.println("p3 = " + p3);

        //2.检索路径信息
        Path path = Paths.get("/Users/yongshi/Downloads/spring_security_in_action_source_code");;
        //返回成字符串的格式
        System.out.format("toString: %s%n", path.toString());
        //返回名称元素序列的文件名或最后一个元素
        System.out.format("getFileName: %s%n", path.getFileName());
        //返回指定索引对应的路径元素，第0哥元素是最靠近根的路径元素
        System.out.format("getName(0): %s%n", path.getName(0));
        //返回路径中的元素数
        System.out.format("getNameCount: %d%n", path.getNameCount());
        //返回由Path开始和结束索引指定的(不包括根元素)的子序列
        System.out.format("subpath(0,2): %s%n", path.subpath(0, 2));
        //返回父目录的路径
        System.out.format("getParent: %s%n", path.getParent());
        //返回路径的根
        System.out.format("getRoot: %s%n", path.getRoot());

        //3.从路经中删除冗余:normalize 方法删除任何冗余元素，其中包括任何 “.” 或 “directory/..” 出现
        Path p4 = Paths.get("/Users/yongshi/./Downloads/spring_security_in_action_source_code");;
        final Path normalize = p4.normalize();
        System.out.println("normalize = " + normalize);


        //4.路径转换
        Path p5 = Paths.get("/home/logfile");
        // Result is file:///home/logfile
        System.out.format("%s%n", p1.toUri());

        Path path2 = Paths.get("/Users/yongshi/Downloads/spring_security_in_action_source_code");
        System.out.format("%s%n", path2.toUri()); // Result is file:///C:/Users/Administrator/Desktop/局域网屏幕分享/

        //5.连接2两个路径
        // Solaris
        Path p6 = Paths.get("/home/joe/foo");
        // Result is /home/joe/foo/bar
        System.out.format("%s%n", path2.resolve("bar"));

        // Microsoft Windows
        Path p7 = Paths.get("C:\\home\\joe\\foo");
        // Result is C:\home\joe\foo\bar
        System.out.format("%s%n", p7.resolve("bar"));

        /**
         *6. 在两个路径创建相对路径:在这个路径和一个给定路径之间构造一个相对路径。编写文件 I / O 代码时的常见
         * 要求是构建从文件系统中的一个位置到另一个位置的路径的功能。您可以使用该 relativize 方法来满足此要求。
         * 该方法构造一个源自原始路径并以传入路径指定的位置结束的路径。新的路径是相对于原始路径
         */
        Path p8 = Paths.get("joe");
        Path p9 = Paths.get("sally");
        System.out.println(p8.toAbsolutePath());
        System.out.println(p9.toAbsolutePath());
        // Result is ../sally
        Path p1_to_p2 = p8.relativize(p9);
        System.out.println(p1_to_p2);
        // Result is ../joe
        Path p2_to_p1 = p9.relativize(p8);
        System.out.println(p2_to_p1);

        //p10和p11共享一个目录
        Path p10 = Paths.get("Download");
        Path p11 = Paths.get("Download/Ebook/mongodb-the-definitive-guide-3e-master");
        System.out.println(p10.toAbsolutePath());
        System.out.println(p11.toAbsolutePath());
        // Result is sally/bar：表示p11在p1的相对路径是什么
        Path p1_to_p3 = p10.relativize(p11);
        // Result is ../..：p10相对p11的相对路径是什么
        Path p3_to_p1 = p11.relativize(p10);
        System.out.println(" p1_to_p3: "+p1_to_p3);
        //可以看出来，p10 再加上相对路径，再获取绝对路径。就还原了 p11 真实路径。..\.. 如果是返回的这种冗余路径的，还可以调用 .normalize() 方法去掉；
        //如果只有一个路径包含根元素，则不能构造相对路径。如果两个路径都包含根元素，则构建相对路径的能力取决于系统
        System.out.println(p10.resolve(p1_to_p3).toAbsolutePath());
        System.out.println("p3_to_p1: "+ p3_to_p1);
        System.out.println(p11.resolve(p3_to_p1).toAbsolutePath().normalize());

        //6.比较两路径：该 Path 支持 equals，使您能够测试相等的两条路径。
        // 该 startsWith 和 endsWith 方法使您能够测试路径是否开始或与特定的字符串结尾
        Path path3 = p10;
        Path otherPath =p11;
        Path beginning = Paths.get("Download");
        Path ending = Paths.get("mongodb-the-definitive-guide-3e-master");

        if (path3.equals(otherPath)) {
            // equality logic here
        } else if (path3.startsWith(beginning)) {
            // path begins with "/home"
        } else if (path3.endsWith(ending)) {
            // path ends with "foo"
        }


    }

}
