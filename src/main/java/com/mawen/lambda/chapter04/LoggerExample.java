package com.mawen.lambda.chapter04;

import org.apache.commons.lang.StringUtils;

import java.util.function.Supplier;

/**
 * 日志打印
 */
public class LoggerExample {

    private String level;

    public LoggerExample(String level) {
        this.level = level;
    }

    public static void main(String[] args) {
        v1();
        v2();
    }

    /**
     * 使用if语句显式判断，省去计算消息是否应该记录的性能消耗
     */
    private static void v1() {
        LoggerExample logger = new LoggerExample("debug");
        if (logger.isDebugEnabled()) {
            logger.debug("Look at this: v1");
        }
    }

    /**
     * 使用Lambda表达式简化日志代码 - Supplier
     */
    private static void v2() {
        LoggerExample logger = new LoggerExample("debug");
        logger.debug(() -> "Look as this: v2");
    }

    private boolean isDebugEnabled() {
        return StringUtils.equals(level, "debug");
    }

    private void debug(String message) {
        System.out.println(message);
    }

    /**
     * 支持了高阶函数的方法
     * @param supplier
     */
    private void debug(Supplier<String> supplier) {
        if (isDebugEnabled()) {
            debug(supplier.get());
        }
    }
}
