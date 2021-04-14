def solution(arr, divisor):
  answer = sorted([i for i in arr if i % divisor == 0])
  return answer if len(answer) != 0 else [-1]

#  return answer or else [-1]로 더 단순화 할 수 있음.
#  사실 answer를 바로 return으로 돌리면 한 줄 코딩 가능.