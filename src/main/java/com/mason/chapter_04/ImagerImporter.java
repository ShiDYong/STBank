package com.mason.chapter_04;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.mason.chapter_04.Attributes.*;

/**
 * @author yongshi
 * @date 2022/11/5 21:51
 * @Description 图片的导入
 */
public class ImagerImporter implements Importer {

    @Override
    public Document importFile(File file) throws IOException {
        Map<String, String> attributes = new HashMap<>();
        //根据路径将文件存入
        attributes.put(PATH, file.getPath());
        //读取一个图像文件
        final BufferedImage image = ImageIO.read(file);
        //从BufferedImage对象中提取图像的宽度和高度
        attributes.put(WIDTH, String.valueOf(image.getWidth()));
        attributes.put(HEIGHT, String.valueOf(image.getHeight()));
        attributes.put(TYPE,"IMAGE");
        return new Document(attributes);
    }
}
