# Solution for: https://www.hackerrank.com/challenges/countingsort3
lim = int(raw_input())
cdict = {}
for i in range(0,100):
    cdict[i] = 0
for i in range(0, lim):
    ar = [x for x in raw_input().strip().split()]
    for x in ar:
        if x.isdigit():
            cdict[int(x)] +=1
sum = 0
for key,value in cdict.iteritems():
    if value != 0:
        sum += value
        print sum,
    else:
        print lim,