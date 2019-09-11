package com.ziponia.util;

import javax.crypto.Cipher;
import java.io.*;
import java.security.Key;
import java.sql.Timestamp;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 작성일 : 2018. 07. 08.
 * 작성자 Lee Ji Hoon <thtjwls@gmail.com>
 *
 * @project sns
 * <p>
 * 각종 유틸리티
 * <p>
 * ────────────────────────────────────────────────────────────────
 * 이력
 * ────────────────────────────────────────────────────────────────
 * 날짜           수정자           내용
 * ────────────────────────────────────────────────────────────────
 * 2018. 07. 08.  이지훈           Create
 */
public class UtilComponent implements Serializable {

    /**
     * 랜덤키를 만듭니다.
     *
     * @param length     key 길이를 정의합니다.
     * @param numberType true -> 숫자형식으로만 출력합니다. false -> 숫자 or 문자로 출력합니다.
     * @return java.lang.String random key
     */
    public static String keyGenerator(int length, boolean numberType) {
        StringBuilder result = new StringBuilder();

        if (numberType) {
            for (int i = 0; i < length; i++) {
                double randomValue = Math.random();
                int intValue = (int) (randomValue * 10);
                result.append(intValue);
            }

        } else {
            String uid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, length);
            result.append(uid);
        }

        return result.toString();
    }

    /**
     * currentTimestamp 기준 이후의 분 시점을 반환합니다.
     *
     * @param currentTimestamp 변환 할 시간
     * @param afterMinute      변환 할 시점
     * @return java.sql.Timestamp
     */
    public static Timestamp afterMinute(Timestamp currentTimestamp, int afterMinute) {
        int targetTime = 60 * afterMinute * 1000; // 초
        return new Timestamp(currentTimestamp.getTime() + targetTime);
    }

    /**
     * currentTimestamp 기준 이전의 분 시점을 반환합니다.
     *
     * @param currentTimestamp 변환 할 시간
     * @param beforeMinute     변환 할 시점
     * @return java.sql.Timestamp
     */
    public static Timestamp beforeMinute(Timestamp currentTimestamp, int beforeMinute) {
        int targetTime = 60 * beforeMinute * 1000; // 초
        return new Timestamp(currentTimestamp.getTime() - targetTime);
    }

    /**
     * 랜덤 주문번호를 생성합니다.
     *
     * @return java.lang.String
     */
    public static String orderNumberGenerator() {
        String key = keyGenerator(6, true);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime() + "_" + key;
    }

    /**
     * 바이너리 바이트 배열을 스트링으로 변환
     */
    public static String byteArrayToBinaryString(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; ++i) {
            sb.append(byteToBinaryString(b[i]));
        }
        return sb.toString();
    }

    /**
     * 바이너리 바이트를 스트링으로 변환
     */
    public static String byteToBinaryString(byte n) {
        StringBuilder sb = new StringBuilder("00000000");
        for (int bit = 0; bit < 8; bit++) {
            if (((n >> bit) & 1) > 0) {
                sb.setCharAt(7 - bit, '1');
            }
        }
        return sb.toString();
    }

    /**
     * 바이너리 스트링을 바이트배열로 변환
     */
    public static byte[] binaryStringToByteArray(String s) {
        int count = s.length() / 8;
        byte[] b = new byte[count];
        for (int i = 1; i < count; ++i) {
            String t = s.substring((i - 1) * 8, i * 8);
            b[i - 1] = binaryStringToByte(t);
        }
        return b;
    }

    /**
     * 바이너리 스트링을 바이트로 변환
     */
    public static byte binaryStringToByte(String s) {
        byte ret = 0, total = 0;
        for (int i = 0; i < 8; ++i) {
            ret = (s.charAt(7 - i) == '1') ? (byte) (1 << i) : 0;
            total = (byte) (ret | total);
        }
        return total;
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
     * 위도, 경도를 사용하여 시작점과 끝점의 거리를 구합니다. (단위 km)
     *
     * @param startLat  시작위도
     * @param startLong 시작경도
     * @param endLat    목표위도
     * @param endLong   목표경도
     * @return Double
     * @see <a href="https://github.com/jasonwinn/haversine">참조링크</a>
     */
    public static Double calculationDistanceFromGeographic(double startLat, double startLong, double endLat, double endLong) {

        // 지구 평균 반지름
        double EARTH_RADIUS = 6371;

        double dLat = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat = Math.toRadians(endLat);

        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(startLat) * Math.cos(endLat) * Math.pow(Math.sin(dLong / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }

    public static byte[] getFile(File f) {
        InputStream is = null;
        try {
            is = new FileInputStream(f);
        } catch (FileNotFoundException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        byte[] content = null;
        try {
            content = new byte[is.available()];
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            is.read(content);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return content;
    }

    public static byte[] encryptFile(Key key, byte[] content) {
        Cipher cipher;
        byte[] encrypted = null;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            encrypted = cipher.doFinal(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypted;

    }

    public static byte[] decryptFile(Key key, byte[] textCryp) {
        Cipher cipher;
        byte[] decrypted = null;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            decrypted = cipher.doFinal(textCryp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return decrypted;
    }

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
}