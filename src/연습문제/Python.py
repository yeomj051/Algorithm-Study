# 3
# blather reblath
# maryland landam
# bizarre brazier

# blather & reblath are anagrams.
# maryland & landam are NOT anagrams.
# bizarre & brazier are anagrams.

test_case = int(input())

for i in range(test_case):
  right_word, anagrams = input().split()
  right_list = list(right_word)
  anagram_list = list(anagrams)

  y_or_n = ''

  for j in anagram_list:
    if(right_list.count(j) != anagram_list.count(j) or len(right_list) != len(anagram_list)): y_or_n = 'NOT '

  print(right_word + ' & ' + anagrams + ' are ' + y_or_n +  'anagrams.')
  
