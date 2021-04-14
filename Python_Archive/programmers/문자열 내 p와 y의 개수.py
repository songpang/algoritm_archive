def solution(s):
    answerP = [x for x in s.upper() if x == 'P']
    answerY = [x for x in s.upper() if x == 'Y']

    return True if len(answerP) == len(answerY) else False

print(solution('pPoooyY'))