word, result = list(input().upper()), 0

for i in range(len(word)):
  select = word.count(word[i])
  if result < select:
    result, c = select, word[i]
    word.remove(c)
    if len(word) == 0:
      break
  elif result == select:
    c = '?'
    

print(c)