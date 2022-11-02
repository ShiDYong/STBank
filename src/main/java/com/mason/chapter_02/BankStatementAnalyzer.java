package com.mason.chapter_02;




import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

/**
 * @author yongshi
 * @date 2022/10/30 15:27
 * @Description 通过接口实现解耦
 */
public class BankStatementAnalyzer {

    private static final String RESOURCE = "src/main/resources/";

    public void analyze(String fileName, BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(RESOURCE + fileName);
        final List<String> lines = Files.readAllLines(path);
        //调用解析文件的方法类
        final List<BankTransaction> bankTransactions = bankStatementParser.parserLineForm(lines);
        //调用处理计算逻辑方法类
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {

        System.out.println("The total for all transactions is "
                + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in January is "
                + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transactions in February is "
                + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is "
                + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }

}
