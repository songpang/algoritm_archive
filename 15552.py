import sys

a = int(sys.stdin.readline())

for i in range(a):
  A, B = map(int, sys.stdin.readline().split())
  print(A + B)