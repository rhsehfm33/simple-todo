package com.simpleTodo.todo.service;

import com.simpleTodo.common.customEnum.ErrorMessage;
import com.simpleTodo.common.entity.Member;
import com.simpleTodo.common.entity.Todo;
import com.simpleTodo.common.repository.MemberRepository;
import com.simpleTodo.common.repository.TodoRepository;
import com.simpleTodo.todo.dto.TodoRequestDto;
import com.simpleTodo.todo.dto.TodoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final MemberRepository memberRepository;

    private final TodoRepository todoRepository;

    @Transactional
    public TodoResponseDto createTodo(String memberName, TodoRequestDto todoRequestDto) {
        Member member = memberRepository.findByMemberName(memberName).orElseThrow(
                () -> new EntityNotFoundException(ErrorMessage.MEMBER_ACCESS_DENIED.getMessage())
        );

        Todo newTodo = Todo.create(member, todoRequestDto);

        return TodoResponseDto.create(member, newTodo);
    }

    @Transactional
    public List<TodoResponseDto> getTodos(String memberName) {
        Member member = memberRepository.findByMemberName(memberName).orElseThrow(
                () -> new EntityNotFoundException(ErrorMessage.MEMBER_ACCESS_DENIED.getMessage())
        );

        List<TodoResponseDto> todoResponseDtos = todoRepository.findAllByMemberOrderByPriorityDesc(member).stream()
                .map(todo -> TodoResponseDto.create(member, todo))
                .collect(Collectors.toList());

        return todoResponseDtos;
    }

    @Transactional
    public TodoResponseDto updateTodo(String memberName, Long todoId, TodoRequestDto todoRequestDto) {
        Member member = memberRepository.findByMemberName(memberName).orElseThrow(
                () -> new EntityNotFoundException(ErrorMessage.MEMBER_ACCESS_DENIED.getMessage())
        );

        Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new EntityNotFoundException(ErrorMessage.TODO_NOT_FOUND.getMessage())
        );

        if (todo.getMember().equals(member) == false) {
            throw new IllegalArgumentException(ErrorMessage.TODO_ACCESS_DENIED.getMessage());
        }

        todo.update(todoRequestDto);

        return TodoResponseDto.create(member, todo);
    }

    @Transactional
    public String deleteTodo(String memberName, Long todoId) {
        Member member = memberRepository.findByMemberName(memberName).orElseThrow(
                () -> new EntityNotFoundException(ErrorMessage.MEMBER_ACCESS_DENIED.getMessage())
        );

        Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new EntityNotFoundException(ErrorMessage.TODO_NOT_FOUND.getMessage())
        );

        if (todo.getMember().equals(member) == false) {
            throw new IllegalArgumentException(ErrorMessage.TODO_ACCESS_DENIED.getMessage());
        }

        todoRepository.delete(todo);

        return "success";
    }

}
