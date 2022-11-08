package com.mason.chapter_04;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.mason.chapter_04.Attributes.PATH;

/**
 * @author yongshi
 * @date 2022/11/7 21:52
 * @Description 使用领域类对文本文件进行建模，因为我们真正想操作的是文本文件的内容
 * ，这只是从文本文件的基础概念建模的类，它具有从文本文件中提取数据的
 * 相关方法。
 */
class TextFile {
    private final Map<String, String> attributes;
    private final List<String> lines;

    public TextFile(File file) throws IOException {
        attributes = new HashMap<>();
        attributes.put(PATH, file.getPath());
        lines = Files.lines(file.toPath()).collect(Collectors.toList());
    }

    Map<String, String> getAttributes() {
        return attributes;
    }
    //使用内部类
    int addLines(
            final int start,
            final Predicate<String> isEnd,
            final String attributeName) {
        final StringBuilder accumulator = new StringBuilder();
        int lineNumber;
        for (lineNumber = start; lineNumber < lines.size(); lineNumber++) {
            final String line = lines.get(lineNumber);
            if (isEnd.test(line)) {
                break;
            }

            accumulator.append(line);
            accumulator.append("\n");

        }
        attributes.put(attributeName, accumulator.toString().trim());
        return lineNumber;
    }

    void addLineSuffix(String prefix, String attributeName) {
        for (String line : lines) {
            if (line.startsWith(prefix)) {
                attributes.put(attributeName, line.substring(prefix.length()));
                break;
            }
        }

    }
}
