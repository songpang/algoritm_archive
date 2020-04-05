def solution(n):
  nBin = bin(n)[2:].count('1')
  for i in range(n+1, 1000001):
    if bin(i)[2:].count('1') == nBin:
      return i

# solution(78)
print(solution(15))  