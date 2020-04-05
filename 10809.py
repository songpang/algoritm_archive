# word, count = input(), 0
# cn = list('abcdefghijklmnopqrstuvwxyz')
# kn = []

# for i in range(len(cn)):
#   kn.append(str(-1))

# for c in word:
#   if kn[cn.index(c)] != '-1':
#     count += 1
#     continue
#   kn[cn.index(c)] = str(count)
#   count += 1

# print(' '.join(kn))

## another answer
a=input();b="abcdefghijklmnopqrstuvwxyz"
for x in b:
    print(a.find(x), end=' ')