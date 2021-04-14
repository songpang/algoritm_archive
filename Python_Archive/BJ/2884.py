a, b = map(int, input().split())
t = a * 60 + b - 45

h, m = t//60%24, t%60

print(h, m)