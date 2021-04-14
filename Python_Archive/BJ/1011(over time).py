ncase = int(input())

for i in range(ncase):
  count, i, nsum = 0, 0, 0
  x, y = map(int, input().split())
  distance = y - x
  while True:
    if (distance - count) > count:
      i += 1
      nsum += 1
      count += i
    elif (distance - count) == count:
      nsum *= 2
      break
    else:
      if (count - i) == (distance - count):
        nsum = nsum*2 - 1
        break
      elif (count - i) < (distance - count):
        nsum = nsum*2
        break
      else:
        count -= 1
        i -= 1
        
  print(nsum)