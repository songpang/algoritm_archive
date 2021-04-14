n = int(input())

print(' '*(n-1) + '*')
for i in range(1, n):
  print(' '*(n-i-1), end = '')
  print('* '*i +'*')


# Best Answer
# a=int(input())
# for i in range(a):
#     print(" "*(a-i-1)+"* "*(i+1))