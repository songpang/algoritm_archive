def solution(A, K):
  if A == []:
    return []
  if len(A) == K:
    return A

  divVal = len(A) - K % len(A)
  return A[divVal:] + A[:divVal]

print(solution([], 3))

'''
For example, given

    A = [3, 8, 9, 7, 6]
    K = 3
the function should return [9, 7, 6, 3, 8]. Three rotations were made:

    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
'''