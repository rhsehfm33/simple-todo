package com.simpleTodo.common.entity;

import com.simpleTodo.todo.dto.TodoRequestDto;
import lombok.*;

import javax.persistence.*;

@Entity(name = "simpletodos")
@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Todo extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "sub_title", nullable = false)
    private String subTitle;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "is_checked", nullable = false)
    private boolean checked;

    public static Todo create(Member member, TodoRequestDto todoRequestDto) {
        return Todo.builder()
                .member(member)
                .title(todoRequestDto.getTitle())
                .subTitle(todoRequestDto.getSubTitle())
                .content(todoRequestDto.getContent())
                .checked(todoRequestDto.isChecked())
                .build();
    }

    public void update(TodoRequestDto todoRequestDto) {
        this.title = todoRequestDto.getTitle();
        this.subTitle = todoRequestDto.getSubTitle();
        this.content = todoRequestDto.getContent();
        this.checked = todoRequestDto.isChecked();
    }

}
