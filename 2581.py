def prime(n):
  a = [False, False] + [True]*(n-1)
  primes = []

  for i in range(2, n+1):
    if a[i]:
      primes.append(i)
      for j in range(2*i, n+1, i):
        a[j] = False
  
  return primes

nmin, nmax = map(int, input().split())

primelist = prime(nmax)
a = []

for i in primelist:
  if i >= nmin:
    a.append(i)
    print(i)