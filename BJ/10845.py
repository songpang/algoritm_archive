import sys

class Queue:
  def __init__(self):
    self.qlist = []
    self.back = 0

  def push(self, X):
    self.qlist.append(X)
    self.back += 1
  
  def pop(self):
    if self.back == 0:
      return -1
    else:
      temp = self.qlist[0]
      del self.qlist[0]
      self.back -= 1
      return temp

  def size(self):
    return self.back

  def empty(self):
    if self.back == 0:
      return 1
    else:
      return 0
    
  def front(self):
    if self.back == 0:
      return -1
    else:
      return self.qlist[0]

  def backf(self):
    if self.back == 0:
      return -1
    else:
      return self.qlist[-1]

N = int(input())
Q = Queue()

for _ in range(N):
  a = sys.stdin.readline().split()
  if len(a) == 2:
    Q.push(a[1])
  else:
    if a[0] == 'front':
      print(Q.front())
    elif a[0] == 'back':
      print(Q.backf())
    elif a[0] == 'size':
      print(Q.size())
    elif a[0] == 'empty':
      print(Q.empty())
    else:
      print(Q.pop())
