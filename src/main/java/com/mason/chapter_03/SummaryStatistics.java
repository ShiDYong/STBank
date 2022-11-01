package com.mason.chapter_03;

/**
 * @author yongshi
 * @date 2022/11/1 22:38
 * @Description 表示用户想用导出的汇总信息。领域对象只是与你的领域相关的类的一个实例，
 *              通过引入领域对象，就引入类一种解藕的形式，实际上如果有需要导出额外信息的新需求
 *              ，你可以将其作为新类的一部分包含进来，而不必引入级联更改
 */
public class SummaryStatistics {
    private double sum;
    private double max;
    private double min;
    private double average;

    public SummaryStatistics(double sum, double max, double min, double average) {
        this.sum = sum;
        this.max = max;
        this.min = min;
        this.average = average;
    }

    public double getSum() {
        return sum;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public double getAverage() {
        return average;
    }
}
