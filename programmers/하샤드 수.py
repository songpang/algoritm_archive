def solution(inPut):
  a = str(inPut)
  hashaSum = 0
  for i in range(len(a)):
    hashaSum += int(a[i])
  
  if int(a) % hashaSum == 0:
    return True
  return False

## 한줄 코딩 ##
# def solution(n):
#   return n % sum([int(i) for i in str(n)]) == 0

print(solution(10), solution(12), solution(11), solution(13))