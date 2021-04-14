# 내코드 but 효율성 부족 실패.

# def solution(stock, dates, supplies, k):
#   answer = 0

#   for i in range(1, k):
#     if stock > 1:
#       stock -= 1
#     else:
#       answer += 1
#       tmp = []
#       for j, v in enumerate(dates):
#         if v <= i:
#           tmp.append(supplies[j])

#       stock += max(tmp)-1
#       idx = supplies.index(max(tmp))
#       supplies[idx] = 0
#   return answer
def solution(stock, dates, supplies, k):
    import heapq
    
    answer = 0
    idx = 0
    pq = []
    
    while stock < k:
        for i in range(idx, len(dates)):
            if stock < dates[i]:
                break
            heapq.heappush(pq, -supplies[i])     
            idx = i + 1
        stock += (heapq.heappop(pq) * -1)
        answer += 1
    return answer
    
print(solution(4, [1,2,3,4], [10,40,20,30], 100))


