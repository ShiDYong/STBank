package com.mason.chapter_04;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.NavigableMap;

import static com.mason.chapter_04.Attributes.*;

/**
 * @author yongshi
 * @date 2022/11/7 22:39
 * @Description 导入检查报告类文档
 */
public class ReporterImporter implements Importer {
    private static final String NAME_PREFIX = "Patient: ";

    @Override
    public Document importFile(File file) throws IOException {
        final TextFile textFile = new TextFile(file);
        textFile.addLineSuffix(NAME_PREFIX, PATIENT);
        textFile.addLines(2, line -> false, BODY);
        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(TYPE, "REPORTER");
        return new Document(attributes);
    }
}
