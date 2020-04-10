word, result = input().upper(), 0
ndict = {}

for i in word:
  if i not in ndict.keys():
    ndict[i] = 1
  else: ndict[i] += 1

for key, value in ndict.items():
  if value > result:
    result, select = value, key
  elif value == result:
    select = "?"
  
print(select)