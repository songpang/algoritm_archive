cro_list = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
alpha = input()
 
for t in cro_list:
    alpha = alpha.replace(t, '*')
 
print(len(alpha))