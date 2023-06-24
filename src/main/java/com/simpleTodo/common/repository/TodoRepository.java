package com.simpleTodo.common.repository;

import com.simpleTodo.common.entity.Member;
import com.simpleTodo.common.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllByMember(Member member);

    Optional<Todo> findByIdAndMember(Long todoId, Member member);

}
