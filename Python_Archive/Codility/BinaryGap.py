def solution(n):
  exN = bin(n)[2::]
  maxZero = exN.count('0')
  maxGap = 0

  print(exN, maxZero)

  for i in range(maxZero):
    p = exN[1::].find('1')
    if p>maxGap:
      maxGap = p
    if p == maxZero:
      return maxGap
    else:
      exN = exN[p+1::]
  
  return maxGap

print('answer', solution(32))
