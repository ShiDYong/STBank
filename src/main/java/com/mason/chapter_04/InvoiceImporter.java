package com.mason.chapter_04;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static com.mason.chapter_04.Attributes.*;

/**
 * @author yongshi
 * @date 2022/11/7 22:15
 * @Description 导入发票的实现类-->发票实例：
 *          Dear Joe Tom
 *          Here is your invoice for the dental treatment that you received.
 *          Amount:$100
 *          regards,
 *              Dr AvaJ
 *              Awesome Dentist
 *
 */
public class InvoiceImporter implements Importer{
    private static final String NAME_PREFIX = "Dear";
    private static final String AMOUNT_PREFIX = "Amount";

    @Override
    public Document importFile(File file) throws IOException {
        final TextFile textFile = new TextFile(file);
        textFile.addLineSuffix(NAME_PREFIX,PATIENT);
        textFile.addLineSuffix(AMOUNT_PREFIX,AMOUNT);
        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(TYPE,"INVOICE");
        return new Document(attributes);
    }
}
