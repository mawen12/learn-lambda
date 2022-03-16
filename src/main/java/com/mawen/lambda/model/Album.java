package com.mawen.lambda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 专辑
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {
    /**
     * 专辑名
     */
    private String name;
    /**
     * 专辑上所有曲目的列表
     */
    private List<Track> tracks;
    /**
     * 参与创作本专辑的艺术家列表
     */
    private List<Artist> musicians;

}
