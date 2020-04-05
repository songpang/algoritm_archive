def star(nstar, count):
  
  new, x = [], nstar.split('\n')

  for i in range(count):
    new.append(x[i] * 3)
  for i in range(count):
    new.append(x[i] + " " + x[i])
  for i in range(count):
    new.append(x[i] * 3)

  return '\n'.join(new)

a = int(input())
x = "*"
for i in range(8):
  if 3**i==a:
    break
  x = star(x, 3**i)
