package com.simpleTodo.member.dto;

import com.simpleTodo.common.entity.Member;
import com.simpleTodo.common.entity.Timestamped;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder(access = AccessLevel.PRIVATE)
public class MemberResponseDto extends Timestamped {

    @Schema(type = "integer", example = "2")
    private Long id;

    @Schema(example = "apple123")
    private String memberName;

    @Schema(example = "apple121")
    private String nickName;

    @Schema(example = "user@gmail.com")
    private String email;

    private LocalDate birthday;

    public static MemberResponseDto create(Member member) {
        return MemberResponseDto.builder()
                .id(member.getId())
                .memberName(member.getMemberName())
                .nickName(member.getNickName())
                .email(member.getEmail())
                .birthday(member.getBirthday())
                .build();
    }

}
