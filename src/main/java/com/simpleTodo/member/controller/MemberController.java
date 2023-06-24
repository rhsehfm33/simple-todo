package com.simpleTodo.member.controller;

import com.simpleTodo.common.dto.ErrorResponseDto;
import com.simpleTodo.member.dto.LoginRequestDto;
import com.simpleTodo.member.dto.MemberResponseDto;
import com.simpleTodo.member.dto.SignupRequestDto;
import com.simpleTodo.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Tag(name = "회원 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    @Operation(summary = "회원 가입", description = "회원 가입하는 API")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody @Valid SignupRequestDto signupRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.signup(signupRequestDto));
    }

    @PostMapping("/login")
    @Operation(summary = "로그인")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "로그인 성공", useReturnTypeSchema = true),
            @ApiResponse(
                    responseCode = "400",
                    description = "해당 memberName(ID)가 존재하지 않습니다.",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponseDto.class))
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "패스워드가 틀렸습니다.",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponseDto.class))
            )
    })
    public ResponseEntity<MemberResponseDto> login(
            @RequestBody LoginRequestDto loginRequestDto,
            @Parameter(hidden = true) HttpServletResponse response
    ) {
        return ResponseEntity.ok(memberService.login(loginRequestDto, response));
    }

    @GetMapping("/member-name/duplicate")
    @Operation(summary = "아이디 중복체크", description = "아이디 중복이면 true, 중복이 아니면 false")
    public ResponseEntity<Boolean> checkMemberName(@RequestParam String memberName) {
        return ResponseEntity.ok(memberService.checkMemberNameDuplication(memberName));
    }

}
