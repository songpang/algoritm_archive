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
        
```java
        StringBuilder sb = new StringBuilder();
        
        while(!remove.isEmpty()) {
            sb.insert(remove.pop().intValue(), 'X');
            //스택에서 반환하는 값이 Integer 니까 intValue 로 뽑아내야함.
        }
```


- 배열을 길이 순으로 정렬하는 경우
  1)  Arrays.sort 를 사용하되 파라미터로 들어가는 Comparator 를 재정의<br>
    그 중 compare 함수를 재정의 해야 하는데 <br/>
      아래와 같이 재정의 하면 길이 순으로 정렬 할 수 있음
  2) return 값 (간단하게 생각하고 재정의 하면 된다.)
    - 양수 s1 > s2.
    - 같으면 s1 = s2
    - 작으면 s1 < s2
```java
        Arrays.sort(s2Arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
```

- LCS(Longest Common Subsequence)
  1)  두 A,B의 최대 공통 부분집합을 찾는 알고리즘.
  - HackerRank CommonChild
```java

    static int commonChild(String S, String T) {
        int LArr[][] = new int[S.length() + 1][T.length() + 1];

        for (int i = 0; i <= S.length(); i++) {
            for (int j = 0; j <= T.length(); j++) {
                if (i == 0 || j == 0)
                    LArr[i][j] = 0;
                else if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    LArr[i][j] = LArr[i - 1][j - 1] + 1;
                } else {
                    LArr[i][j] = Math.max(LArr[i - 1][j], LArr[i][j - 1]);
                }
            }
        }
        return LArr[S.length()][T.length()];
    }
```