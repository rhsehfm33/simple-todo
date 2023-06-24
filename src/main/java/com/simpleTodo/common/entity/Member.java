package com.simpleTodo.common.entity;

import com.simpleTodo.member.customEnum.MemberRoleEnum;
import com.simpleTodo.member.dto.SignupRequestDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "members")
@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Member extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_name", nullable = false, unique = true)
    private String memberName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private MemberRoleEnum role;

    @Column(name = "nick_name", nullable = false)
    private String nickName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    public static Member create(SignupRequestDto signupRequestDto, String encodedPassword, MemberRoleEnum memberRoleEnum) {
        return Member.builder()
                .memberName(signupRequestDto.getMemberName())
                .password(encodedPassword)
                .role(memberRoleEnum)
                .nickName(signupRequestDto.getNickName())
                .email(signupRequestDto.getEmail())
                .birthday(signupRequestDto.getBirthday())
                .build();
    }

}
