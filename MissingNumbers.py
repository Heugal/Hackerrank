# Solution for: https://www.hackerrank.com/challenges/missing-numbers


lim1 = int(raw_input())
ar1 = [int(i) for i in raw_input().strip().split()]
lim2 = int(raw_input())
ar2 = [int(i) for i in raw_input().strip().split()]
# sort the arrays and get the frequency of the numbers in the arrays
# which can be used to compare
ar1.sort()
ar2.sort()
freq1 = {}
freq2 = {}
for i in range(0, len(ar1)):
    if ar1[i] in freq1:
        freq1[ar1[i]] += 1
    else:
        freq1[ar1[i]] = 1
for i in range(0, len(ar2)):
    if ar2[i] in freq2:
        freq2[ar2[i]] += 1
    else:
        freq2[ar2[i]] = 1
j = 0
# compare the frequency dictionaries based on the length of 
# the longest dict
if len(freq1) >= len(freq2):
    # match the frequency amounts for both dicts
    for key in freq1:
        if key in freq2:
            if freq1[key] != freq2[key]:
                print key,
else:
    for key in freq2:
        if key in freq1:
            if freq2[key] != freq1[key]:
                print key,