package com.mason.chapter_02;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yongshi
 * @date 2022/10/29 23:01
 * @Description 将解析逻辑提取到一个单独的类中
 */
public class BankStatementCSVParserOld {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    /**
     * 单个解析CSV文件的方法
     * @param line 传入CSV文件的每行内容
     * @return 返回一个BankTransaction对象
     */
    public BankTransaction parserFromCSV(final String line){
        final String[] columns = line.split(",");
        //分别把CSV文件的每行数据单独提取出来
        final LocalDate date = LocalDate.parse(columns[0],DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];
        return new BankTransaction(date,amount,description);

    }

    /**
     * 批量解析CSV文件的方法
     * @param lines 传入多行文件内容
     * @return 返回多个银行交易领域类
     */
    public List<BankTransaction> parseLinesFromCSV(final List<String> lines){
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for (String line : lines) {
            //直接调用单个解析CSV文件的方法
            bankTransactions.add(parserFromCSV(line));

        }
        return bankTransactions;
    }









}
