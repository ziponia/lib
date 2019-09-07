개인 라이브러리

#example

_pom.xml_

```xml
<project>
    
    <!-- github 레포지토리를 추가합니다. -->
    <repositories>
        <repository>
            <id>library</id>
            <url>https://raw.github.com/ziponia/library/mvn-repo/</url>
            <snapshots>
                <enabled>true</enabled>
                <updatePolicy>always</updatePolicy>
            </snapshots>
        </repository>
    </repositories>

    <!-- 사용 할 라이브러리 디펜던시를 선언합니다. -->
    <dependencies>        
        <dependency>
            <groupId>com.ziponia</groupId>
            <artifactId>util</artifactId>
            <version>{version}</version>
        </dependency>
    </dependencies>
</project>
```

- [kakao api](https://github.com/ziponia/lib/blob/master/kakao/README.md)
