import sys

class Deque:
  def __init__(self):
    self.Dlist = []
    self.dsize = 0

  def push_front(self, X):
    self.Dlist.insert(0, X)
    self.dsize += 1

  def push_back(self, X):
    self.Dlist.append(X)
    self.dsize += 1

  def pop_front(self):
    if self.dsize > 0:
      temp = self.Dlist[0]
      self.Dlist.remove(temp)
      self.dsize -= 1
      return temp
    else:
      return -1

  def pop_back(self):
    if self.dsize > 0:
      temp = self.Dlist[self.dsize-1]
      self.dsize -= 1
      self.Dlist.pop()
      return temp
    else:
      return -1

  def size(self):
    return self.dsize

  def empty(self):
    if self.dsize > 0:
      return 0
    else:
      return 1

  def front(self):
    if self.dsize > 0:
      return self.Dlist[0]
    else:
      return -1

  def back(self):
    if self.dsize > 0:
      return self.Dlist[-1]
    else:
      return -1


N = int(input())
dq = Deque()

for _ in range(N):
  a = sys.stdin.readline().split()
  if a[0] == 'push_back':
    dq.push_back(a[1])
  elif a[0] == 'push_front':
    dq.push_front(a[1])
  elif a[0] == 'front':
    print(dq.front())
  elif a[0] == 'back':
    print(dq.back())
  elif a[0] == 'size':
    print(dq.size())
  elif a[0] == 'empty':
    print(dq.empty())
  elif a[0] == 'pop_front':
    print(dq.pop_front())
  elif a[0] == 'pop_back':
    print(dq.pop_back())
