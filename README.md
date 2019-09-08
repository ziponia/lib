개인 라이브러리

#example

_pom.xml_

```xml
<project>
    
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>com.github.ziponia.lib</groupId>
            <artifactId>{library name}</artifactId>
            <version>master-SNAPSHOT</version>
        </dependency>
    </dependencies>
</project>
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



- [kakao api](https://github.com/ziponia/lib/blob/master/kakao/README.md)
- [11번가](https://github.com/ziponia/lib/blob/master/11st/README.md)
- [Google](https://github.com/ziponia/lib/tree/master/google/README.md)
