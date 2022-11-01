package com.mason.chapter_03;

import java.util.List;

/**
 * @author yongshi
 * @date 2022/11/1 23:15
 * @Description TODO
 */
public interface BankStatementParser {
    BankTransaction parseFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}
