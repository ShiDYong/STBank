package com.mason.chapter_03;

/**
 * @author yongshi
 * @date 2022/11/1 22:47
 * @Description 用于导出html格式报告的接口实现
 */
public class HtmlExporter implements Exporter{
    @Override
    public String export(SummaryStatistics summaryStatistics) {
        String result = "<!doctype html>";
        result += "<html lang='en'>";
        result += "<head><title>Bank Transaction Report</title></head>";
        result += "<body>";
        result += "<ul>";
        result += "<li><strong>The sum is</strong>: " + summaryStatistics.getSum() + "</li>";
        result += "<li><strong>The average is</strong>: " + summaryStatistics.getAverage() + "</li>";
        result += "<li><strong>The max is</strong>: " + summaryStatistics.getMax() + "</li>";
        result += "<li><strong>The min is</strong>: " + summaryStatistics.getMin() + "</li>";
        result += "</ul>";
        result += "</body>";
        result += "</html>";
        return result;
    }
}
