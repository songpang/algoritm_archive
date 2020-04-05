def solution(answers):
  luckyMethod = [[1,2,3,4,5],
                 [2,1,2,3,2,4,2,5],
                 [3,3,1,1,2,2,4,4,5,5]]
  asCount = [0, 0, 0]

  for i, v in enumerate(luckyMethod):
    for p, q in enumerate(answers):
      if answers[p] == v[p%len(v)]:
        asCount[i] += 1

  return [i+1 for i, v in enumerate(asCount) if asCount[i] == max(asCount)]   

print(solution([1,3,2,4,2]))
