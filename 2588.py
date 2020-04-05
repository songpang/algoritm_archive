# a, b = int(input()), int(input())

# a3 = a * (b%10)
# a4 = a * (b//10%10)
# a5 = a * (b//100%10)

# print(a3, a4)

# a=1.12371234
# print(format(a, "1.3f"))

# a,b = int(input()),input()
# print(*[1,2,3,4], a*int(b))

a, b = int(input()), input()
Alist = [a*int(p) for p in b][::-1]
print(Alist)