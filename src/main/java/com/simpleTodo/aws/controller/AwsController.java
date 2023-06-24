package com.simpleTodo.aws.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "AWS 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/aws")
@Hidden
public class AwsController {

    @GetMapping("/health-check")
    @Operation(
            summary = "해당 인스턴스트를 health-check하는 API",
            description = "인스턴스의 상태를 확인하기 위해 AWS 로드밸런서가 호출하는 API"
    )
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("up");
    }

}
