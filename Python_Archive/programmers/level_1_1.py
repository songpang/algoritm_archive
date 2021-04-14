# 랜덤 문자열 나오면
# 순서대로 정렬, 대문자는 뒤로.
# 

exstr = 'asdvwrwerSDAqwe'

exstr = list(exstr)

for i in range(0, len(exstr)-1):
  for j in range(i+1, len(exstr)):
    if(exstr[i] > exstr[j]):
      tmp = exstr[i]
      exstr[i] = exstr[j]
      exstr[j] = tmp

for i in range(len(exstr)):
  if(ord(exstr[0]) < 97):
    tmp = exstr[i]
    exstr.pop(0)
    exstr += tmp
  else:
    break


exstr = ''.join(exstr)

print(exstr)