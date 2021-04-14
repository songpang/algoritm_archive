def solution(dartResult):
  dartResult = dartResult.replace('10', 'a')
  score = []
  n = 0

  for i in dartResult:
    if i == 'a':
      n = 10
    if i.isnumeric():
      n = int(i)
    elif i == 'S':
      score.append(n ** 1)
    elif i == 'D':
      score.append(n ** 2)
    elif i == 'T':
      score.append(n ** 3) 
    elif i == '*':
      if len(score) > 1:
        score[-2] *= 2
      score[-1] *= 2
    elif i == '#':
      score[-1] *= -1
  
  return sum(score)
      

print(solution("1S2D*3T"))