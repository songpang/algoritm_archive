a, b, c = map(int, input().split())

result = a if a > b else b
if result < c:
  print(result)
else:
  if result == a:
    result = b if b > c else c
    print(result)
  else: 
    result = a if a > c else c
    print(result)


####Good Answer ####
#A= map(int,input().split(' '))
# B=sorted(A)
# print(B[1])
