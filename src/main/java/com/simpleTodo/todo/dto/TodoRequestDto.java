package com.simpleTodo.todo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@AllArgsConstructor
public class TodoRequestDto {

    @Min(value = 1, message = "우선순위는 최소 1 입니다.")
    @Max(value = 5, message = "우선순위는 최대 5 입니다.")
    @Schema(example = "1")
    private Integer priority;

    @Schema(example = "제목")
    private String title;

    @Schema(example = "부제목")
    private String subTitle;

    @Schema(example = "내용")
    private String content;

    @Schema(example = "true")
    private boolean checked;

}
