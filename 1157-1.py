buff = input().upper()
cn = []

for c in 'ABCDEFGHIJKLMNOPQRSTUWVXYZ':
  cn.append(buff.count(c))

m = max(cn)
if cn.count(m) > 1:
  print('?')
else: 
  print(chr(cn.index(m) + ord('A')))
  