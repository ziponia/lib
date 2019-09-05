개인 라이브러리

_pom.xml_

```xml
<project>
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


    <dependencies>        
        <dependency>
            <groupId>com.ziponia</groupId>
            <artifactId>util</artifactId>
            <version>{version}</version>
        </dependency>
    </dependencies>
</project>
```