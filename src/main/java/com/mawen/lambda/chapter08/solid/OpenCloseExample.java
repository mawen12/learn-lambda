package com.mawen.lambda.chapter08.solid;

/**
 * 开闭原则
 */
public class OpenCloseExample {




    /**
     * 将代理收集到的各项指标放入该类
     */
    public interface MetricDataGraph {
        public void updateUserTime(int value);

        public void updateSystemTime(int value);

        public void updateToTime(int value);
    }

    /**
     * 第二个版本，从面向过程转变为面向对象，在变更时，就无须变更该类了
     */
    public interface MetricDataGraphV2{

        public void addTimeSeries(TimeSeries values);

    }

    public interface TimeSeries {

    }

}
