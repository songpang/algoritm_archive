def solution(a, b):
  DAY = ['FRI','SAT', 'SUN','MON','TUE','WED','THU']
  MON = [31, 29, 31, 30, 31, 30 ,31 ,31 ,30, 31, 30, 31]
  
  tmp = (sum([MON[i] for i in range(a-1)]) + b)%7 -1
  return DAY[tmp]

print(solution(5, 19))