def warp(distance):
  minN = powN = maxN = warpCnt = 0
  n = 1
  while True:
    powN = n*n
    minN = powN - n + 1
    maxN = powN + n
    if minN <= distance <= maxN:
      if minN <= distance <= powN:
        warpCnt = (n<<1) - 1
      else:
        warpCnt = n<<1
      break
    n+=1
  return warpCnt

for _ in range(int(input())):
  x,y = map(int, input().split())
  distance = y - x
  print(warp(distance))