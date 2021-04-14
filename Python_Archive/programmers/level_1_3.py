# 입력 수 짝수라면 2 나누고
# 홀수라면 3 곱하고 1 더하기
# 결과가 1이 될 때 까지 반복
# 500번 이상이면 -1 반환

answer = 0

def solution(number):
  global answer
  if number == 1:
    return answer
  if answer > 500:
    return -1
  answer += 1
  
  if (number%2 == 0):
    return solution(number / 2)
  else:
    return solution(number * 3 +1)

print(solution(626331))