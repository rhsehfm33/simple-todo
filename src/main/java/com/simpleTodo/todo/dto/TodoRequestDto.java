package com.simpleTodo.todo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoRequestDto {

    @Schema(example = "제목")
    private String title;

    @Schema(example = "부제목")
    private String subTitle;

    @Schema(example = "내용")
    private String content;

    @JsonProperty("isChecked")
    @Schema(example = "true")
    private boolean isChecked;

}
