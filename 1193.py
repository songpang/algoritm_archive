a = int(input())
sum, i = 0, 1

while True:
  sum += i
  if sum >= a:
    count = sum - a
    break
  i += 1

if i%2 == 0:
  print('%d/%d' %((i-count), count+1))
else:
  print('%d/%d' %(count+1, (i-count)))