# Solution for: https://www.hackerrank.com/challenges/countingsort1
lim = int(raw_input())
ar = [int(i) for i in raw_input().strip().split()]
cdict = {}
for i in range(0,100):
    cdict[i] = 0
for i in range(0,lim):
    key = ar[i]
    cdict[key] += 1
for key,value in cdict.iteritems():
    print value,