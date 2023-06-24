package com.simpleTodo.common.customEnum;

public enum ErrorMessage {
    
    // Member entity 오류
    MEMBER_ACCESS_DENIED("해당 사용자는 권한이 없습니다."),
    MEMBER_NOT_FOUND("해당 사용자가 존재하지 않습니다."),
    MEMBER_NAME_DUPLICATION("memberName이 중복됐습니다."),
    WRONG_MEMBER_NAME("memberName이 일치하지 않습니다."),
    WRONG_ADMIN_PASSWORD("관리자 패스워드가 틀려 등록이 불가능합니다."),
    WRONG_PASSWORD("패스워드가 틀렸습니다."),
    WRONG_JWT_TOKEN("JWT Token이 잘못되었습니다."),
    AUTHENTICATION_FAILED("JWT가 올바르지 않습니다"),

    // 객체todo entity 오류
    TODO_NOT_FOUND("해당 todo가 존재하지 않습니다."),
    TODO_ACCESS_DENIED("사용자는 해당 todo에 대한 권한이 없습니다.");

    String message;

    ErrorMessage(String description) {
        this.message = description;
    }

    public String getMessage() {
        return this.message;
    }
}
