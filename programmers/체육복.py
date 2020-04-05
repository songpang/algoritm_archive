def solution(n, lost, reserve):
  answer = n

  _lost = [x for x in lost if x not in reserve]
  _reserve = [x for x in reserve if x not in lost]

  for i in range(len(_lost)):
    if _lost[i]-1 in _reserve:
      _reserve.remove(_lost[i]-1)
    elif _lost[i]+1 in _reserve:
      _reserve.remove(_lost[i]+1)
    else:
      answer -= 1
        
  return answer

print(solution(10, [3, 9, 10], [3, 8, 9]))
'''
## 잃어버렸는데 갖고 있을 경우
## 잃어버렸는데 없는 경우
### 잃어버렸는데 옆친구 있을 경우

물어본다. -> 없다 -> answer삭제
물어본다 -> 있다. -> reserve삭제
### 잃어버렸는데 옆친구 없을 경우
2 1 5
1 2 3 4 5

'''