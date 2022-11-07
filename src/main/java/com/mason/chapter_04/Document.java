package com.mason.chapter_04;

import java.util.Map;

/**
 * @author yongshi
 * @date 2022/11/5 21:34
 * @Description 文档类，每个文档都有多个可以搜索的属性
 *              ，不同的文档有不同的属性。
 */

public class Document {


    /**
     * 这里选择用Map而不是hashMap也是有特殊的意义
     */
    private final Map<String,String> attributes;

    /**
     *只有文档管理系统中的代码才能创建Document对象，因此
     * 我们保持构造方法作用域为包，并限制只有文档管理系统所在的包才可以访问，而
     * public允许项目中的任何地方的代码创建这种类型的对象
     * @param attributes
     */
     Document(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    /**
     * 根据属性名获取文档属性值的方法
     * @param attributeName
     * @return
     */
    public String getAttributes(String attributeName){
        return attributes.get(attributeName);
    }
}
