package com.simpleTodo.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
public class SignupRequestDto {

    @NotEmpty
    @Schema(example = "memberName")
    private String memberName;

    @NotEmpty
    @Schema(example = "nickName")
    private String nickName;

    @NotEmpty
    @Schema(example = "password")
    private String password;

    @NotEmpty
    @Schema(example = "memberName@gmail.com")
    private String email;

    @NotNull
    @Schema(example = "2023-06-27")
    private LocalDate birthday;

}
