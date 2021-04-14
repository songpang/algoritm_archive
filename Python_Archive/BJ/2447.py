def f(x, n):
    r, x = [], x.split("\n")
    for i in range(n):
        r.append(x[i] * 3)
    for i in range(n):
        r.append(x[i] + " " * n + x[i])
    for i in range(n):
        r.append(x[i] * 3)
    return '\n'.join(r)

n, x = int(input()), "*"
for i in range(8):
    if 3 ** i == n:
        break
    x = f(x, 3 ** i)
print(x)
print(type(x))