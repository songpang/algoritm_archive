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
#         a = ['F','F']                                 #i ������ ���縵�� i+1 ������ ���縵�� �����ϱ����� ����Ʈ
#         for j in range(i+1, len(voca)):
#             if voca[i] == voca[j] and a[0] == 'T':    #voca�� i��°�װ� ������ ������� ���Ͽ� ���޾� �����°�, �ƴѰ��� ����
#                 a[1] = 'T'                            
#             if voca[i] != voca[j]:
#                 a[0] = 'T'
#             if a[0] == 'T' and a[1] == 'T':           #���� ���縵�� ���������� ���޾� ������ �ʾ�����
#                 return 0
#     return 1

# n = int(input())
# count = 0

# for i in range(n):
#     voca = input()
#     count += check(voca)

# print(count)
