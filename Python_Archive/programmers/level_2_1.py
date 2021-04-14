# def solution(n):
#   one_count = bin(n).count('1')
#   for i in range(n+1, 1000001):
#     if bin(i).count('1') == one_count:
#       return i 


## 2진수 변환 솔루션
# def makebin(number):
#   binlist = ''
#   while number >= 1:
#     bincount = number%2
#     binlist = str(bincount) + binlist
#     number //= 2
#   return binlist
