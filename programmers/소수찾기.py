def solution(n):
  aratos = [True] * (n+1)
  median = int((n+1)**0.5)+1

  for i in range(2, median):
    if aratos[i] == True:
      for j in range(i+i, n+1, i):
        aratos[j] = False

  answer = [i for i in range(2, n+1) if aratos[i] == True]
  return len(answer)

## 파이써닉 하게 에라토스 테네스의 체를 set을 이용해 구현
# def solution(n):
#   num=set(range(2,n+1))

#   for i in range(2,int(n**0.5)+1):
#     if i in num:
#       num-=set(range(2*i,n+1,i))
#   return len(num)


print(solution(100))

# print(set(range(2, 10)))