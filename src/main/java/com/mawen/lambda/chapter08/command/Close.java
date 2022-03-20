package com.mawen.lambda.chapter08.command;

public class Close implements Action{

    private Editor editor;

    public Close(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.close();
    }
}
