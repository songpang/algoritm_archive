word = input()
count = len(word)*3
alpha = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'

for c in word:
  for i in range(len(alpha)):
    if alpha[i] == c:
      if i in [18, 21, 24, 25]:
        i = i//3 - 1
        count += i
        break
      else:
        count += i//3
        break

print(count)
