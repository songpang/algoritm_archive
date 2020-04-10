ftimes = int(input())

for a in range(ftimes):
  times, string = input().split()
  for i in [ x*int(times) for x in string ]:
    print(i, end='')
  print()