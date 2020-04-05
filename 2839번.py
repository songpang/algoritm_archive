a = int(input())
box = 0

while True:
  if a%5 == 0:
    box += (a//5)
    print(box)
    break
  box += 1
  a -= 3
  if a < 0:
    print(-1)
    break