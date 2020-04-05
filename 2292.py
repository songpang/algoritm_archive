bee_home = int(input())
sum, i = 0, 1

n = (bee_home -1)/6

while True:
  sum += i
  if sum >= n:
    break
  i += 1

if bee_home == 1:
  print(1)
else:
  print(i+1)