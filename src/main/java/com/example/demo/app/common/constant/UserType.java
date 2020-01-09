package com.example.demo.app.common.constant;

/**
 * description
 *
 * @author : jkkim
 */
public enum UserType implements CodeEnum {

    ADMIN("ADMIN", "관리자"),
    USER("USER", "조사원");

    private String code;
    private String codeNm;

    UserType(String code, String codeNm) {
        this.code = code;
        this.codeNm = codeNm;
    }


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getCodeNm() {
        return codeNm;
    }
}
