def solution(arr):
  # answer = ['0']
  answer = []

  for i in arr:
    # if answer[-1:] != i:
    #   answer.append(i)
    if answer[-1:] != [i]:
      answer.append(i)

  # answer.pop('0')
  return answer

solution([1,1,3,3,0,1,1])

## answer[-1:0] 하면 빈 배열에도 오류가 없으며 
## 리턴값은 [마지막 원소값] -> []안에 있음.
## answer[-1] 이랑은 다름.