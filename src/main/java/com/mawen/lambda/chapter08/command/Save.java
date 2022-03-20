package com.mawen.lambda.chapter08.command;

/**
 * 保存操作代理给 Editor 方法
 */
public class Save implements Action{

    public Editor editor;

    public Save(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.save();
    }

}
