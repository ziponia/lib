package com.ziponia.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyUtilComponent {

    /**
     * 패스워드 정규식
     * 최소 8 자 이상, 숫자, 특수문자 1개이상씩 포함
     *
     * @param password 체크 할 비밀번호 평문
     * @return boolean
     */
    public static boolean passwordThen8AndSpecialCharacters(String password) {
        Pattern p = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$");
        Matcher m = p.matcher(password);
        return m.matches();
    }

    /**
     * 휴대폰번호 유효성 체크
     *
     * @param str 휴대폰번호
     * @return boolean
     */
    public static boolean checkCellphone(String str) {
        //010, 011, 016, 017, 018, 019
        return str.matches("(01[016789])-(\\d{3,4})-(\\d{4})");
    }

    /**
     * 운전 면허번호 유효성 체크
     * 지역명이 포함된 운전면허번호 조회시 경북-95-255933-61 방식으로 넘깁니다.
     * 숫자만 포함된 운전면허번호 조회시에도 19-95-255933-61 방식으로 통일합니다.
     *
     * @param licenseNo 유효성을 체크할 면허번호를 입력합니다.
     * @return boolean
     */
    public static boolean checkLicenseValidity(String licenseNo) {

        String regex = ".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*"; //한글이 포함되어 있는 운전면허번호 구분

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(licenseNo);

        if (matcher.matches()) {
            String regex1 = "^([가-힣]{2}(\\s|-)?|[가-힣]{2}-?)(\\s|-)?\\d{2}(\\s|-)?\\d{6}(\\s|-)?\\d{2}$"; //지역명 포함 운전면허번호
            pattern = Pattern.compile(regex1);
        } else {
            String regex2 = "^((1[1-9])|(2[0-6])|(26)|(28))(\\s|-)?\\d{2}(\\s|-)?\\d{6}(\\s|-)?\\d{2}$"; //숫자만 포함 운전면허번호
            pattern = Pattern.compile(regex2);
        }

        matcher = pattern.matcher(licenseNo);
        return matcher.matches();
    }
}
