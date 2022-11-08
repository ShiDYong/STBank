package com.mason.chapter_04;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static com.mason.chapter_04.Attributes.*;

/**
 * @author yongshi
 * @date 2022/11/7 22:33
 * @Description 信件的导入类
 */
public class LetterImporter implements Importer {
    private static final String NAME_PREFIX = "Dear";

    @Override
    public Document importFile(File file) throws IOException {
        final TextFile textFile = new TextFile(file);
        textFile.addLineSuffix(NAME_PREFIX, PATIENT);
        final int lineNumber = textFile.addLines(2, String::isEmpty, ADDRESS);
        textFile.addLines(lineNumber + 1, (line) -> line.startsWith("regards,"), BODY);
        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(TYPE, "LETTER");
        return new Document(attributes);
    }
}