package com.mason.chapter_02;

import com.mason.chapter_02.BankStatementCSVParser;
import com.mason.chapter_02.BankStatementParser;
import com.mason.chapter_02.BankTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

/**
 * @date 2022/10/30 15:41
 * @Description BankStatementCSVParser的测试类
 */
public class BankStatementCSVParserTest {

    private final BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    public void shouldParserOneCorrectLine() {
        //Given
        final String line = "30-01-2022,-50,Tesco";
        //When
        final BankTransaction result = statementParser.parserForm(line);
        final BankTransaction expected = new BankTransaction(LocalDate.of(2022, Month.JANUARY, 30), -50, "Tesco");
        final double tolerance = 0.0d;
        //Then
        Assertions.assertEquals(expected.getDate(),result.getDate());
        Assertions.assertEquals(expected.getAmount(), result.getAmount());
        Assertions.assertEquals(expected.getDescription(),result.getDescription());

    }


}
