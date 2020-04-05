# a, b = map(int, input().split())

# if(a>b):
#   print(">")
# elif(a<b):
#   print("<")
# else:
#   print("==")


#short coding
a,b=map(int,input().split())
print(['><'[a<b],'=='][a==b])

##룩업 테이블