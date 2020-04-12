# def solution(n):
#   return sum([x for x in range(1, n+1) if n % x == 0])

# 반으로 나누면 더 좋은 속도
def solution(n):
  return n + sum([x for x in range(1, n//2+1) if n % x == 0])

print(solution(8))