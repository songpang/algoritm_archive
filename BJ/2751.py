def merge(data, left, right):
  


def mergesort(data, left, right):
  if left < right:
    mid = (left + right)/2
    mergesort(data, left, mid)
    mergesort(data, mid+1, right)

    merge(data, left, right)




N = int(input())
numlist = []

for i in range(N):
  numlist.append(int(input()))

