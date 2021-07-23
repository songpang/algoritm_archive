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

- 반복되는 같은 문자열 찾을 때 

```java
       String temp = String.format("%10s", "").replace(" ", "G");
       // 이런식으로 공백을 생성해놓고 G로 replace하면 10개의 연속된 G값 쉽게 얻을 수 있음.
        System.out.println(temp);
```

- StringBuilder insert 관련 Issue
    1)  아래에서 insert 사용 시 remove.pop()을 인자로 사용하면 Error 발생.<br>
        인자는 int형인데 Integer로 return 되었기 때문. 이를 .intValue()를 사용해서 해결.
        
```
        StringBuilder sb = new StringBuilder();
        
        while(!remove.isEmpty()) {
            sb.insert(remove.pop().intValue(), 'X');
            //스택에서 반환하는 값이 Integer 니까 intValue 로 뽑아내야함.
        }
```
        