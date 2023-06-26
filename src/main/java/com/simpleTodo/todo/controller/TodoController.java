package com.simpleTodo.todo.controller;

import com.simpleTodo.common.security.MemberDetailsImpl;
import com.simpleTodo.todo.dto.TodoRequestDto;
import com.simpleTodo.todo.dto.TodoResponseDto;
import com.simpleTodo.todo.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Todo API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    @Operation(summary = "todo를 생성하는 API")
    public ResponseEntity<TodoResponseDto> createTodo(
            @RequestBody @Valid TodoRequestDto todoRequestDto,
            @Parameter(hidden = true) @AuthenticationPrincipal MemberDetailsImpl memberDetails
    ) {
        return ResponseEntity.ok(todoService.createTodo(memberDetails.getUsername(), todoRequestDto));
    }

    @GetMapping("/{todoId}")
    @Operation(summary = "특정 todo를 조회하는 API")
    public ResponseEntity<TodoResponseDto> getTodo(
            @Parameter(hidden = true) @AuthenticationPrincipal MemberDetailsImpl memberDetails,
            @PathVariable Long todoId
    ) {
        return ResponseEntity.ok(todoService.getTodo(memberDetails.getUsername(), todoId));
    }

    @GetMapping
    @Operation(summary = "모든 todo를 조회하는 API")
    public ResponseEntity<List<TodoResponseDto>> getTodos(
            @Parameter(hidden = true) @AuthenticationPrincipal MemberDetailsImpl memberDetails
    ) {
        return ResponseEntity.ok(todoService.getTodos(memberDetails.getUsername()));
    }

    @PatchMapping("/{todoId}")
    @Operation(summary = "todo를 수정하는 API")
    public ResponseEntity<TodoResponseDto> updateTodo(
            @Parameter(hidden = true) @AuthenticationPrincipal MemberDetailsImpl memberDetails,
            @PathVariable Long todoId,
            @RequestBody @Valid TodoRequestDto todoRequestDto
    ) {
        return ResponseEntity.ok(todoService.updateTodo(memberDetails.getUsername(), todoId, todoRequestDto));
    }

    @DeleteMapping("/{todoId}")
    @Operation(summary = "todo를 삭제하는 API")
    public ResponseEntity<String> deleteTodo(
            @PathVariable Long todoId,
            @Parameter(hidden = true) @AuthenticationPrincipal MemberDetailsImpl memberDetails
    ) {
        return ResponseEntity.ok(todoService.deleteTodo(memberDetails.getUsername(), todoId));
    }

}
