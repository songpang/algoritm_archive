stack = []
top = 0

def push(X):
  global top
  top += 1
  stack.append(X)

def pop():
  global top
  if top > 0:
    a = stack[-1]
    del stack[top-1]
    top -= 1
    return a
  else:
    return -1

def empty():
  global top
  if top == 0:
    return 1
  else:
    return 0

def stacktop():
  global top
  if top > 0:
    return stack[top-1]
  else:
    return -1

N = int(input())

for _ in range(N):
  a = input().split()
  if len(a) == 2:
    push(a[1])
  else:
    if a[0] == 'top':
      print(stacktop())
    elif a[0] == 'size':
      print(top)
    elif a[0] == 'pop':
      print(pop())
    else:
      print(empty())