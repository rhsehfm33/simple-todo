package com.simpleTodo.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class LoginRequestDto {

    @NotEmpty
    @Schema(example = "memberName")
    private String memberName;

    @NotEmpty
    @Schema(example = "password")
    private String password;

}
