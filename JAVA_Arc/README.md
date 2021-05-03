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
