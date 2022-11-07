package com.mason.chapter_04;

import java.io.File;
import java.io.IOException;

/**
 * @author yongshi
 * @date 2022/11/5 21:33
 * @Description 为了支持不同的文档类型，定义Importer接口
 */
public interface Importer {

    /**
     * 传入一个文件类
     * @param file
     * @return
     */
    public Document importFile(File file) throws IOException;
}
