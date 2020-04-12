def solution(strings, n):
  answer = [i[n::] for i in strings]
  preasnwer = [i[:n] for i in strings]
  result =[0] * len(strings)

  for i in range(len(answer)):
    result[i] = hash(answer[i])
  
  answer.sort()
  
  for i in range(len(answer)):
    for j in range(len(result)):
      if result[j] == hash(answer[i]):
        answer[i] = preasnwer[j]+answer[i]
        result[j] = 0
        break

  return answer

# print(solution(['sun', 'bed', 'car'], 1))
# print(solution(['abce', 'abcd', 'cdx'], 2))
print(solution(['abzcd','cdzab','abzfg','abzaa','abzbb','bbzaa'], 2))