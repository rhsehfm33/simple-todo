package com.simpleTodo.common.dto;

import com.simpleTodo.common.customEnum.ErrorType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(access = AccessLevel.PRIVATE)
public class ErrorResponseDto {

    @Schema(example = "EXAMPLE_EXCEPTION")
    ErrorType errorType;

    @Schema(example = "example error message")
    String errorMessage;

    public static ErrorResponseDto create(ErrorType errorType, String errorMessage) {
        return ErrorResponseDto.builder()
                .errorType(errorType)
                .errorMessage(errorMessage)
                .build();
    }
}
