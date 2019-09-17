# Utility Component

## Getting Start

```xml
<dependency>
    <groupId>com.github.ziponia.lib</groupId>
    <artifactId>util</artifactId>
    <version>{library version}</version>
</dependency>
```

_Gradle_

```groovy
implementation 'com.github.ziponia.lib:util:{library version}'
```

## Browser

class `DateUtilComponent`

날짜 관련 컴포넌트

| method         | param               | return         | description                                  |
| :------------- | :------------------ | :------------- | :------------------------------------------- |
| toAfterMinute  | java.util.Date, int | java.util.Date | 기준 이후의 분 시점을 반환합니다.            |
| toBeforeMinute | java.util.Date, int | java.util.Date | 기준 이전의 분 시점을 반환합니다.            |
| lastDate       | java.util.Date      | int            | Date 객체 기준으로 마지막 날짜를 반환합니다. |
| lastDate       | int, int            | int            | 년, 월 기준으로 마지막 날을 반환합니다.      |

class `VerifyUtilComponent`

검증 관련 컴포넌트

| method                            | param  | return  | description                                   |
| :-------------------------------- | :----- | :------ | :-------------------------------------------- |
| passwordThen8AndSpecialCharacters | String | boolean | 최소 8 자 이상, 숫자, 특수문자 1개이상씩 포함 |
| checkCellphone                    | String | boolean | 휴대폰번호 유효성 체크                        |
| checkLicenseValidity              | String | boolean | 운전 면허번호 유효성 체크                     |

class `UtilComponent`

기본 유틸리티 컴포넌트

| method                            | param                          | return | description                                                      |
| :-------------------------------- | :----------------------------- | :----- | :--------------------------------------------------------------- |
| keyGenerator                      | int, boolean                   | String | 랜덤키를 만듭니다, 두번째 인자가 true 면, 숫자로만 만듭니다.     |
| byteArrayToBinaryString           | byte[]                         | String | 바이너리 바이트 배열을 스트링으로 변환                           |
| byteToBinaryString                | byte                           | String | 바이너리 바이트를 스트링으로 변환                                |
| binaryStringToByteArray           | String                         | byte[] | 바이너리 스트링을 바이트배열로 변환                              |
| binaryStringToByte                | String                         | byte   | 바이너리 스트링을 바이트로 변환                                  |
| calculationDistanceFromGeographic | double, double, double, double | double | 위도, 경도를 사용하여 시작점과 끝점의 거리를 구합니다. (단위 km) |
