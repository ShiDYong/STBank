package com.mason.chapter_04;

/**
 * @author yongshi
 * @date 2022/11/7 22:53
 * @Description 异常类
 */
public class UnknownFileTypeException extends RuntimeException {
    public UnknownFileTypeException(String message) {
        super(message);
    }
}
