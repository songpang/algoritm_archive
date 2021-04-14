
## 단순하게 정렬을 2번하면 해결되는 문제.
## 한 줄로 코딩 가능.
# def solution(strings, n):
#     return sorted(sorted(strings), key= lambda x : x[n])

def solution(strings, n):
  firDic = {}
  answer = []

  for i in strings:
    if i[n] not in firDic:
      firDic[i[n]] = [i]
    else:
      firDic[i[n]].append(i)

  for j in range(ord('a'), ord('z')+1):
    if chr(j) in firDic.keys():
      answer += sorted(firDic[chr(j)])

  return answer

print(solution(['abzcd','cdzab','abzfg','abzaa','abzbb','bbzaa'], 2))

# 처음 생각했다가 틀린 코드

# def solution(strings, n):
#   answer = [i[n::] for i in strings]
#   preasnwer = [i[:n] for i in strings]
#   result =[0] * len(strings)

#   for i in range(len(answer)):
#     result[i] = hash(answer[i])
  
#   answer.sort()
  
#   for i in range(len(answer)):
#     for j in range(len(result)):
#       if result[j] == hash(answer[i]):
#         answer[i] = preasnwer[j]+answer[i]
#         result[j] = 0
#         break

#   return answer

# print(solution(['sun', 'bed', 'car'], 1))
# print(solution(['abce', 'abcd', 'cdx'], 2))
# print(solution(['abzcd','cdzab','abzfg','abzaa','abzbb','bbzaa'], 2))