##
# 1. In a given String return the most frequent vowel coming
# 2. In a given character Array change the most frequent with the given alphabet.
# 3. Two sorted linked lists are given to add them in a sorted manner and reverse them., some more question were also there

def solution(givenString):
  vowel = {'a':0, 'e':0, 
           'i':0, 'o':0, 
           'u':0}
  
  for i in givenString:
    if i in vowel:
      vowel[i] += 1
  
  print(vowel)
  return max(vowel.keys(), key = lambda x : vowel[x])

print(solution('aaeeoouuiinvncbxbasd'))