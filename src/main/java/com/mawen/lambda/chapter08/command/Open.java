package com.mawen.lambda.chapter08.command;

/**
 * 打开文件操作代理给 Editor 方法
 */
public class Open implements Action{

    private Editor editor;

    public Open(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.open();
    }
}
