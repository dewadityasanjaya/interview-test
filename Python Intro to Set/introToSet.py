def average(array):
    distinctHeight = set(array)
    sumOfDistinctHeight = 0
    for height in distinctHeight:
        sumOfDistinctHeight += height
    return sumOfDistinctHeight/len(distinctHeight)


if __name__ == '__main__':
    n = int(input())
    arr = list(map(int, input().split()))
    result = average(arr)
    print(result)
