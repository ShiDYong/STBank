package com.mason.chapter_02;

import java.util.List;

/**
 * @author yongshi
 * @date 2022/10/30 15:02
 * @Description 如何使用一个银行账单解析器的接口
 *              耦合：是关于代码类如何依赖其他类的，也就是你需要依赖多少某些特定的类（也就是具体实现）
 *              ，这点非常重要，因为依赖的类越多，在引入变更时灵活性就越低。实际上，由于变更而影响的类，
 *              可能会影响依赖于其它所有的类。通过通过接口和实现相互分离方法实现低耦合。
 */
public interface BankStatementParser {

    /**
     * 单个文件解析的接口
     * @param line
     * @return
     */
    BankTransaction parserForm(String line);


    /**
     * 批量解析文件的接口
     * @param lines
     * @return
     */
    List<BankTransaction>  parserLineForm(List<String> lines);
}
