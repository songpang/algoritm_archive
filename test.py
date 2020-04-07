
# #   pass
# # 3번 문제
# def solution(S):
#   given_s = list(S)
#   sizeS = ord(given_s[0])
  
#   for i in range(len(S)):
#     if sizeS > ord(given_s[i]):
#       given_s.pop(i-1)
#       break
#     if (i == len(given_s)-1):
#       given_s.pop()
#       break
#     sizeS = ord(given_s[i])

#   return ''.join(given_s)


# print(solution('aaaa'))


## 1번 문제
# def solution(S, K):
#   three_letter = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
#   later_k = three_letter.index(S) + K
#   return three_letter[later_k%7]

# print(solution('Sat', 2))

## 2번 문제
## 인티저 M이랑 어레이 A인데 N개의 양의정수.
## 

def solution(M, A):
    N = len(A)
    count = [0] * (M + 1)
    maxOccurence = 1
    index = -1
    for i in range(N):
        if count[A[i]] > 0:
            tmp = count[A[i]]
            if tmp >= maxOccurence:
                maxOccurence = tmp
                index = i
            count[A[i]] = tmp + 1
        else:
            count[A[i]] = 1

    return A[index]

print(solution(5, [1,2,1,5,2,1,2,5,5,1]))

## M보다 작은 값 중에 제일 자주 나온 값.
## count = [0][0][0][0] M = 3
## i = 0 count [A[0]] = 0 count[A[0]] =  1
## i = 1 count [A[1]] = 0 count[A[1]] = 1 
## i = 2 count [A[2]] = 1 
## tmp = 1
## count[A[2]] =

## A = [1,2,1,3,1,3,1]
## 