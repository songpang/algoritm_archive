def solution(s, n):
  answer = []
  for i in s:
    if i.isupper():
      answer.append(chr((ord(i) + n - 65) % 26+ 65))
    elif i == ' ':
      answer.append(' ')
    else:
      answer.append(chr((ord(i) + n - 97) % 26+ 97))

  return ''.join(answer)

print(solution('A B', 1))