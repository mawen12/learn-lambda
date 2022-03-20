package com.mawen.lambda.chapter08.command;

/**
 * 宏构造器
 */
public class MacroBuilder {

    /**
     * 使用命令者模式构建宏
     */
    public Macro build(Editor editor) {
        Macro macro = new Macro();
        macro.record(new Open(editor));
        macro.record(new Save(editor));
        macro.record(new Close(editor));

        return macro;
    }

    /**
     * 使用 Lambda 表达式构建宏
     */
    public Macro buildByLambda(Editor editor) {
        Macro macro = new Macro();
        macro.record(() -> editor.open());
        macro.record(() -> editor.save());
        macro.record(() -> editor.close());
        return macro;
    }

    /**
     * 使用方法引用构建宏
     */
    public Macro buildByMethodRef(Editor editor) {
        Macro macro = new Macro();
        macro.record(editor::open);
        macro.record(editor::save);
        macro.record(editor::close);
        return macro;
    }
}
