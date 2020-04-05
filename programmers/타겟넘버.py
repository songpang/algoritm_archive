## 트리 구조 형상화 하여 간단하게 재귀로 호출

# def solution(numbers, target):
#   cnt = 0
#   len_numbers = len(numbers)

#   def operator(idx):
#     if idx < len_numbers:
#       numbers[idx] *= 1 # 삭제
#       operator(idx+1)

#       numbers[idx] *= -1
#       operator(idx+1)

#     elif sum(numbers) == target:
#       nonlocal cnt
#       cnt += 1

#   operator(0)

#   return cnt


## for문으로 해결
def solution(numbers, target):
  answer_list = [0]
  for i in numbers:
    temp_list = []
    for j in answer_list:
      temp_list.append(j+i)
      temp_list.append(j-i)
    answer_list = temp_list
  
  return answer_list.count(target)