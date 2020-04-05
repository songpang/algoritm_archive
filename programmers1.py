s = [1, 2, 4, 3, 3]
ndict = {}
nsum = 0

for i in range(len(s)):
  if s[i] in ndict:
    ndict[s[i]] += 1
  else:
    ndict[s[i]] = 1

nsum = ndict[4]

print(nsum)

