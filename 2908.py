def rprint(a):
  for i in range(2, -1, -1):
    print(a[i], end='')

a, b = input().split()

for i in range(-1, -4, -1):
  if int(a[i]) == int(b[i]):
    continue
  elif int(a[i]) > int(b[i]):
    rprint(a)
    break
  else:
    rprint(b)
    break
    