package com.mawen.lambda.model;

import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * 创作音乐的个人或团队
 */
@Data
public class Artist {
    /**
     * 艺术家的名字
     */
    private String name;

    /**
     * 乐队成员
     */
    private List<String> members;

    /**
     * 乐队来自哪里
     */
    private String origin;

    /**
     * 乐队是否来自哪里
     * @param origin 位置
     * @return true 相同位置
     */
    public boolean isFrom(String origin) {
        return Objects.equals(this.origin, origin);
    }

    /**
     * 获取国籍
     * @return
     */
    public String getNationality() {
        return origin;
    }
}
