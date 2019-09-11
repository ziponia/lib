# 써드파티 Rest Client Repository

[![](https://jitci.com/gh/ziponia/lib/svg)](https://jitci.com/gh/ziponia/lib)

개발하면서, 자주 쓸만한 Rest Client 를 정리 해 논 디펜던시 입니다.

# Getting Start

이 Repository 사용하려면, 먼저 jitpack 레포지토리를 추가하세요.

_maven_

```xml
<project>
    <repositories>
        <repository>
            <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
</project>
```

_Gradle_

```groovy
allprojects {
    repositories {       
        maven { url 'https://jitpack.io' }
    }
}
```

# 모듈 추가

이 라이브러리는 최상위 lib 프로젝트의 각각의 독립성있는 submodule 로 이루어져 있습니다.

사용하고자 하는 Repository 를 추가하세요.

예를들어, google 에서 제공하는 library 를 사용한다면, 아래와같이 추가하세요.

_maven_

```xml
<dependency>
    <groupId>com.github.ziponia.lib</groupId>
    <artifactId>google</artifactId>
    <version>master-SNAPSHOT</version>
</dependency>
```

_Gradle_

```groovy
implementation 'com.github.ziponia.lib:google:master-SNAPSHOT'
```

> 이 라이브러리는 아직 개발중입니다. master-SNAPSHOT 을 버전으로 지정함으로써, 가장 최신의 커밋내용을 불러 올 수 있습니다.

특정 커밋버전을 이용하려면 commit 의 Hash Shortcut 을 이용하세요.

_예)_
```xml
<dependency>
    <groupId>com.github.ziponia.lib</groupId>
    <artifactId>{library name}</artifactId>
    <version>67e1f0d256</version>
</dependency>
```

더 많은 분기는 [이곳](https://jitpack.io/#ziponia/lib) 에서 확인 하세요.

## 현재 지원되는 모듈 리스트 참조 Docs

- [kakao api 모듈](https://github.com/ziponia/lib/blob/master/kakao/README.md)
    - [웹 검색](https://developers.kakao.com/docs/restapi/search#웹문서-검색)
    - [주소 검색](https://developers.kakao.com/docs/restapi/local#주소-검색)
    - [좌표-행정구역정보-변환](https://developers.kakao.com/docs/restapi/local#좌표-행정구역정보-변환)
    - [번역](https://developers.kakao.com/docs/restapi/translation#문장번역)   
- [11번가 상품 모듈](https://github.com/ziponia/lib/blob/master/11st/README.md)
    - [상품검색](http://openapi.11st.co.kr/openapi/OpenApiGuide.tmall?expCnt=1)
    - [상품정보 조회](http://openapi.11st.co.kr/openapi/OpenApiGuide.tmall?commonGuideNo=3)
- [Google api 모듈](https://github.com/ziponia/lib/tree/master/google/README.md)
    - [maps](https://developers.google.com/places/web-service/intro)
        - [주변 장소 찾기](https://developers.google.com/places/web-service/search#PlaceSearchRequests)
    - [youtube](https://developers.google.com/youtube/v3/docs/?hl=ko)
        - [동영상 검색](https://developers.google.com/youtube/v3/docs/search/list?hl=ko)
- [아임포트 결제 모듈](https://github.com/ziponia/lib/tree/master/iamport/README.md)
    - [간편결제](https://api.iamport.kr/#!/subscribe/onetime)
    - [구매자 빌링키 관리](https://api.iamport.kr/#!/subscribe.customer)
- [Naver api 모듈](https://github.com/ziponia/lib/blob/master/naver/README.md)
    - 검색
        - [뉴스검색](https://developers.naver.com/docs/search/news/)
