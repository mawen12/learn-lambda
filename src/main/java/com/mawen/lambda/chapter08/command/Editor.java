package com.mawen.lambda.chapter08.command;

/**
 * 文本编辑器接口
 */
public interface Editor {

    /**
     * 保存命令
     */
    public void save();

    /**
     * 打开命令
     */
    public void open();

    /**
     * 关闭命令
     */
    public void close();

}
