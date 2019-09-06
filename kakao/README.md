# KAKAO API

원본 문서 https://developers.kakao.com/

```xml
<dependencies>        
    <dependency>
        <groupId>com.ziponia</groupId>
        <artifactId>kakao</artifactId>
        <version>{version}</version>
    </dependency>
</dependencies>
```

# example
```java
public class TestApplication {

    public static void main(String[] args) throws IOException {

        // 자신이 카카오에서 발급받은 Rest Key 를 입력 해주세요.
        KakaoService kakaoClient = new KakaoServiceImpl("{You are kakao rest key}");

        // 웹 문서 검색
        WebSearchRequest request = new WebSearchRequest();
        request.setQuery("아이언맨");
        request.setPage(1);
        request.setSize(10);
        request.setSort(WebSearchRequest.Sort.ACCURACY);
        WebSearchResponse res = kakaoClient.webSearch(request);
        System.out.println(res.toString());
    }
}
```