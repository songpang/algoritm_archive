##

# 1. In a given String return the most frequent vowel coming
# def solution(givenString):
#   vowel = {'a':0, 'e':0, 
#            'i':0, 'o':0, 
#            'u':0}
  
#   for i in givenString:
#     if i in vowel:
#       vowel[i] += 1
  
#   print(vowel)
#   return max(vowel.keys(), key = lambda x : vowel[x])

# print(solution('aaeeoouuiinvncbxbasd'))

# 2. In a given character Array change the most frequent with the given alphabet.
# def solution(givenString):
#   frequentList = {}

#   for i in givenString:
#     if i in frequentList.keys():
#       frequentList[i] += 1
#     else:
#       frequentList[i] = 0
  
#   return max(frequentList.keys(), key=lambda x : frequentList[x])

# print(solution('ababababab'))

# 3. Two sorted linked lists are given to add them in a sorted manner and reverse them., some more question were also there
# def solution(given1, given2):
#   lenSting = len(given1)
#   i, j = 0, 0
#   newList = []

#   while lenSting != 0:
#     if given1[i] < given2[j]:
#       newList.append(given1[i])
#       i += 1
#       lenSting -= 1
#       print(newList)
#     else:
#       newList.append(given2[j])
#       j += 1

#   if j != len(given2):
#     newList += given2[j::]

#   return len(newList)

# print(solution([1,2,4,6,8,9,11,141,193], [2,3,4,5,6,111,134,222]))