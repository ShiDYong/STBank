package com.mason.chapter_03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yongshi
 * @date 2022/11/1 22:54
 * @Description 引入领域类Notification以收集错误信息,方便定义一个校验器
 *              它能够在一次传递中收集多个错误信息
 */
public class Notification {
    private List<String> errors = new ArrayList<>();

    public void addError(String message) {
        errors.add(message);

    }

    public boolean hasError() {
        return !errors.isEmpty();
    }

    public String errorMessage() {
        return errors.toString();
    }

    public List<String> getErrors() {
        return this.errors;
    }
}
