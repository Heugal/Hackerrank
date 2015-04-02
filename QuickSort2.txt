#!/bin/python
# Solution for: https://www.hackerrank.com/challenges/quicksort2
def quickSort(ar): 
    if ar:
        combine = []
        if (len(ar) > 1):
            less = []
            greater = []
            p = ar[0]
            for i in range(1, len(ar)):
                if ar[i] > p:
                    greater.append(ar[i])
                else:
                    less.append(ar[i])
            less = quickSort(less)
            greater = quickSort(greater)
            if less:
                for x in less:
                    combine.append(x)
            combine.append(p)
            if greater:
                for x in greater:
                    combine.append(x)
            for x in combine:
                print x,
            print ""
        else:
            combine.append(ar[0])
        return combine

m = input()
ar = [int(i) for i in raw_input().strip().split()]
quickSort(ar)
