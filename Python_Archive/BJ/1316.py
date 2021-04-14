result = int(input())

for _ in range(result):
    word = input()
    for i in range(1, len(word)):
        if word.find(word[i-1]) > word.find(word[i]):
            result -= 1
            break

print(result)


##another answer
# def check(voca):
#     for i in range(len(voca)):
#         a = ['F','F']                                 #i 순서의 스펠링과 i+1 순서의 스펠링을 구분하기위한 리스트
#         for j in range(i+1, len(voca)):
#             if voca[i] == voca[j] and a[0] == 'T':    #voca의 i번째항과 나머지 모든항을 비교하여 연달아 나오는가, 아닌가를 구분
#                 a[1] = 'T'                            
#             if voca[i] != voca[j]:
#                 a[0] = 'T'
#             if a[0] == 'T' and a[1] == 'T':           #같은 스펠링이 존재하지만 연달아 나오지 않았을때
#                 return 0
#     return 1

# n = int(input())
# count = 0

# for i in range(n):
#     voca = input()
#     count += check(voca)

# print(count)
