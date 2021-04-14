# 문자 -> 숫자로 변경
# 문자 맨 앞에 -, + 가 올 수 있음


def solution(s):
  answer = 0
  endN = len(s)-1

  if (s[0] == '-'):
    for i in range(1, endN+1):
      answer += 10**(endN-i) * (ord(s[i])-48)
    answer *= -1 
  elif (s[0] == '+'):
    for i in range(1, endN+1):
      answer += 10**(endN-i) * (ord(s[i])-48)
  else:
    for i in range(0, endN+1):
      answer += 10**(endN-i) * (ord(s[i])-48)

  return answer

print(solution('1423'))
