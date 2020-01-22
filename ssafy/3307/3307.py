T = int(input())

for t in range(T):
    N = int(input())
    nums = list(map(int, input().split()))

    counts = [0 for _ in range(N+1)]
    counts[0] = 1

    for i in range(1, N):
        for j in range(i, -1, -1):
            if nums[j] < nums[i]:
                counts[i] = max(counts[i], counts[j])
        counts[i] += 1
        # print(counts)

        # if nums[i-1] < nums[i]:
        #     counts[i] = max(counts[i-1], counts[i-2]) + 1  

    # print(counts)
    print('#' + str(t+1) + ' ' + str(max(counts)))