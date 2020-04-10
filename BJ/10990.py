n = int(input())

for i in range(n):
  if n == 1:
    print('*')
    break
  if i == 0:
    print(' '*(n-i-1) + '*')
    continue
  print(' '*(n-i-1) + '*' + ' '*(2*i-1) + '*')

# Best Answer
#   n = int(input())
# print(' '*(n-1)+'*')
# for i in range(1,n):
#     print(' '*(n-i-1)+'*'+' '*(2*i-1)+'*')