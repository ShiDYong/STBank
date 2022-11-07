package com.mason.chapter_03;

/**
 * @author yongshi
 * @date 2022/11/1 22:43
 * @Description 一般接口返回的类型要避免返回类型void，因为用处且难以理解，你不知道它返回了什么
 *              返回void使得断言来测试结果非常困难
 */
public interface Exporter {

    /**
     * 用于导出的接口，方便实现各种类型的导出功能
     * @param summaryStatistics
     * @return
     */
    String export(SummaryStatistics summaryStatistics);
}
