package com.simpleTodo.todo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.simpleTodo.common.entity.Member;
import com.simpleTodo.common.entity.Todo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class TodoResponseDto {

    @Schema(example="12")
    private Long todoId;

    @Schema(example = "user123")
    private String authorName;

    @Schema(example = "제목")
    private String title;

    @Schema(example = "부제목")
    private String subTitle;

    @Schema(example = "내용")
    private String content;

    @Schema(example = "true")
    private boolean checked;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    public static TodoResponseDto create(Member member, Todo todo) {
        return TodoResponseDto.builder()
                .todoId(todo.getId())
                .authorName(member.getMemberName())
                .title(todo.getTitle())
                .subTitle(todo.getSubTitle())
                .content(todo.getSubTitle())
                .checked(todo.isChecked())
                .createdAt(todo.getCreatedAt())
                .modifiedAt(todo.getModifiedAt())
                .build();
    }

}
