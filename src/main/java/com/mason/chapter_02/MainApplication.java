package com.mason.chapter_02;

import java.io.IOException;

/**
 * @author yongshi
 * @date 2022/10/30 15:33
 * @Description 运行的主运用程序
 */
public class MainApplication {
    public static void main(String[] args) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
        bankStatementAnalyzer.analyze("bank-data-simple.csv",bankStatementCSVParser);
    }
}
