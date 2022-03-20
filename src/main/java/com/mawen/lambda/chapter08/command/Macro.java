package com.mawen.lambda.chapter08.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 包含操作序列的宏，可按顺序执行操作
 */
public class Macro {

    private final List<Action> actions;

    public Macro() {
        this.actions = new ArrayList<>();
    }

    /**
     * 命令实例加入 Macro 对象的列表
     * @param action
     */
    public void record(Action action) {
        actions.add(action);
    }

    /**
     * 运行宏
     */
    public void run() {
        actions.forEach(Action::perform);
    }
}
