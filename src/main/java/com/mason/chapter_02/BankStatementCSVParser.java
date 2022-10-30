package com.mason.chapter_02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yongshi
 * @date 2022/10/30 15:12
 * @Description 解析接口的实现类
 */
public class BankStatementCSVParser implements BankStatementParser{

    private static final DateTimeFormatter DATE_PATTERN= DateTimeFormatter.ofPattern("dd-MM-yyyy");


    @Override
    public BankTransaction parserForm(String line) {
        final String[] columns = line.split(",");
        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        return new BankTransaction(date,amount,columns[2]);
    }

    @Override
    public List<BankTransaction> parserLineForm(List<String> lines) {
//        List<BankTransaction> bankTransactions = new ArrayList<>();
//        for (String line : lines) {
//            bankTransactions.add(parserForm(line));
//        }
//        return bankTransactions ;
//
//
        //使用stream流处理
        return lines.stream().map(this::parserForm).collect(Collectors.toList());


    }
}
