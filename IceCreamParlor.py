# Solution for: https://www.hackerrank.com/challenges/icecream-parlor
lim = int(raw_input())
for i in range(0, lim):
    M = int(raw_input())
    N = int(raw_input())
    ar = [int(i) for i in raw_input().strip().split()]
    for j in range(0, N-1):
        for x in range(j+1, N):
            if ar[j] + ar[x] == M:
                print j+1, x+1