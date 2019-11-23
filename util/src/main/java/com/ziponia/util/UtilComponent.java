package com.ziponia.util;

import javax.crypto.Cipher;
import java.io.*;
import java.security.Key;
import java.util.UUID;

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
     * 확률을 입력하여, 해당 확률 만큼 true 를 반환합니다.
     *
     * 예를들어, UtilComponent.percentage(10) 을 100 번 돌린다고 가정하면,
     * 10% 만큼의 true 가 나올 것입니다.
     *
     * @param percent 확률 수치, ex) 50 = 50%, 30 = 30%
     */
    public static boolean percentage(double percent) {
        return Math.random() <= percent * 0.01;
    }
}