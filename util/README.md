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

| method                            | param                          | return  | description                                                      |
| :-------------------------------- | :----------------------------- | :------ | :--------------------------------------------------------------- |
| keyGenerator                      | int, boolean                   | String  | 랜덤키를 만듭니다, 두번째 인자가 true 면, 숫자로만 만듭니다.     |
| byteArrayToBinaryString           | byte[]                         | String  | 바이너리 바이트 배열을 스트링으로 변환                           |
| byteToBinaryString                | byte                           | String  | 바이너리 바이트를 스트링으로 변환                                |
| binaryStringToByteArray           | String                         | byte[]  | 바이너리 스트링을 바이트배열로 변환                              |
| binaryStringToByte                | String                         | byte    | 바이너리 스트링을 바이트로 변환                                  |
| calculationDistanceFromGeographic | double, double, double, double | double  | 위도, 경도를 사용하여 시작점과 끝점의 거리를 구합니다. (단위 km) |
| percentage                        | double                         | boolean | 퍼센트를 입력받아, 확률적으로 true 를 반환합니다.                |

class `PercentageList` extends ArrayList

확률을 계산하는 배열 객체를 생성합니다.

_example_

```java

import com.ziponia.util.PercentageList;

class Main {

    public static void main(String[] args) {
        PercentageList<String> persons = new PercentageList<String>();

        String a1 = "이지훈";
        String a2 = "이정엽";
        String a3 = "김우곤";
        String a4 = "오성범";

        persons.add(a1, 20);
        persons.add(a2, 10);
        persons.add(a3, 5);
        persons.add(a4, 50);

        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        for (int i = 0; i < 10000; i++) {
            String person = persons.get();
            if (person.equals("이지훈")) {
                a++;
            } else if (person.equals("이정엽")) {
                b++;
            } else if (person.equals("김우곤")) {
                c++;
            } else if (person.equals("오성범")) {
                d++;
            }
        }

        System.out.println("이지훈: " + a);
        System.out.println("이정엽: " + b);
        System.out.println("김우곤: " + c);
        System.out.println("오성범: " + d);

        /*
          ===================================
          Difference .get() and .draw()
          ===================================
         */

        while (!persons.isEmpty()) {
            String person = persons.draw();
            if (person.equals("이지훈")) {
                a++;
            } else if (person.equals("이정엽")) {
                b++;
            } else if (person.equals("김우곤")) {
                c++;
            } else if (person.equals("오성범")) {
                d++;
            }
        }

        System.out.println("이지훈: " + a);
        System.out.println("이정엽: " + b);
        System.out.println("김우곤: " + c);
        System.out.println("오성범: " + d);
    }
}
```

PercentageList 의 .get() 과 .draw() 는 다음의 차이첨이 있습니다.

_.get()_

현재 객채의 배열을 섞고 항상 0 번째 인덱스를 가져옵니다. 기존 배열 길이는 변하지 않습니다.

_.draw()_

Queue 의 LikedList 의 .poll() 의 기능을 합니다.

예를들어, ["1", "2", "3"] 의 길이가 3인 배열이 현재 객체 안에 정의 되어있다면, 다음과 같은 형태가 됩니다.

```
// .draw()
// ["2", "3"]
// .draw()
// ["3"]
```

_왜 .get() 과 .draw() 를 따로 구현하나요?_

_.draw() 의 사용 예)_

예를들어, 안쪽이 보이지 않는 한 상자에 10개의 돌이있고, 3개의 흰돌, 7개의 검은돌있다고 가정 해봅시다.

그리고 손을넣어, 돌을 주웠을 때, 확률적으로 어떤 돌이 나오는지 예측하는 프로그램을 만든다고 한다면, 다음과 같이 쓸 수 있을 것 같습니다.

```java
class Main {
    public static void main(String[] args) {
        PercentageList<String> box = new PercentageList<String>();

        // 상자에 돌을 넣습니다.
        box.add("흰돌", 3);
        box.add("검은돌", 7);

        // 상자에서 돌을 뽑습니다.
        box.draw(); // 검은돌 (남음: 검은돌 - 6, 흰돌 - 3)
        box.draw(); // 흰돌 (남음: 검은돌 - 6, 흰돌 - 2)
        box.draw(); // 흰돌 (남음: 검은돌 - 6, 흰돌 - 1)
    }
}
```

_.get() 의 사용 예)_

A 라는 게임에서는 monster 를 퇴치 한다면 떨어지는 아이템 품목이 다음과 같이 있다고 가정해봅시다.

- 목걸이 (드롭율 30%)
- 검 (드롭율 60%)
- 벨트 (드롭율 10%)

이 monster 를 퇴치 했을 때, 드롭 되는 아이템을 가져 오려면 다음과 같이 쓸 수 있을 것 같습니다.

```java
class Main {
    public static void main(String[] args) {
        PercentageList<String> monster_items = new PercentageList<String>();
        monster_items.add("목걸이", 30);
        monster_items.add("검", 60);
        monster_items.add("벨트", 10);

        // 몬스터를 퇴치 합니다.
        monster_items.get(); // 검
        monster_items.get(); // 목걸이
        monster_items.get(); // 검
        monster_items.get(); // 벨트
    }
}
```
