# a = int(input())
# if(a%4==0):
#   if(a%100==0 and a%400!=0):
#     print('0')
#   else:
#     print('1')
# else:
#   print('0')


## short coding
y = int(input())
print(+(y%400<1, y%4<1)[y%100>0])