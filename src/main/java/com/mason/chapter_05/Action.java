package com.mason.chapter_05;

/**
 * @author yongshi
 * @date 2022/11/13 11:07
 * @Description Action接口将允许业务规则引擎与具体的动作解耦
 *              由于Action接口只声明了一个抽象方法，我们可以将其注释为一个函数式接口
 */
@FunctionalInterface
public interface Action {

    /**
     * 执行方法
     * @param facts
     */
    void execute(Facts facts);
}
