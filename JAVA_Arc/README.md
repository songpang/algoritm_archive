- split() 관련 효율성 체크 이슈

``` java
        String[] splits = s.split(""); // Sting을 이용한 split으로 진행 시 효율성 테스트 탈락.
        char[] splitss = s.toCharArray(); // char을 toCharArray로 진행 시 효율성 테스트 통과. (속도 차이 명확)
        int count = 0;
        for (char split : splitss) {
            if (split == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
```

- 접두사 찾는 방법

```java
       phone_book[i+1].length() >= phone_book[i].length() && phone_book[i+1].startsWith(phone_book[i])
       // 위와같이 조건식을 걸었으나
       //phone_book[i+1].startsWith(phone_book[i]) 로 줄일 수 있음.
       
       startWith() 활용 기억해놓기.
```
        