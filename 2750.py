n = int(input())
numlist = []

for i in range(n):
  numlist.append(int(input()))

for i in range(n):
  for j in range(1, n-i):
    if numlist[j-1] > numlist[j]:
      numlist[j-1], numlist[j] = numlist[j], numlist[j-1]

for i in range(n):
  print(numlist[i])