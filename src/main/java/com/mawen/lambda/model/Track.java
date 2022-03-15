package com.mawen.lambda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 专辑中的一支曲目
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Track {
    /**
     * 曲目名称
     */
    private String name;

    /**
     * 曲目长度
     */
    private Integer length;
}
