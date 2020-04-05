import sys

MIS = lambda : int(sys.stdin.readline())

n = MIS()
numlist, numdict = [], {}
avg_sum = 0

for i in range(n):
  tmp = MIS()
  numlist.append(tmp)
  avg_sum += tmp

  if tmp in numdict:
    numdict[tmp] += 1
  else:
    numdict[tmp] = 1

numlist.sort()
nmax = max(numdict.values())
nmax2 = sorted([a for a,b in numdict.items() if b == nmax])

print('%.0f' %(avg_sum/n))
print(numlist[n//2])

if len(nmax2) == 1:
  print(nmax2[0])
else:
  print(nmax2[1])

print(numlist[-1] - numlist[0])


