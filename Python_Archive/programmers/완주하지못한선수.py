## 효율성 부족으로 탈락
# def solution(participant, completion):
#   answer = ''
#   for i in range(len(completion)):
#     if completion[i] in participant:
#       participant.remove(completion[i])
#   answer = participant[0]
#   return answer

# def solution(participant, completion):
#   answer = ''
#   participant.sort()
#   completion.sort()

#   for part, com in zip(participant, completion):
#     if part != com:
#       return part
#   return participant[-1]


##해시 테이블
def solution(participant, completion):
  temp = 0
  hashar = []
  archive = dict()

  for part in participant:
    archive[hash(part)] = part
    temp += hash(part)
  for com in completion:
    temp -= hash(com)

  answer = archive[temp]

  return answer