package com.limon.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({ "id", "word_en", "word_tr", "category","type" })
public class TranslateDTO {

    private Long id;
    private String word_en;
    private String word_tr;
    private String category;
    private String type;

}
