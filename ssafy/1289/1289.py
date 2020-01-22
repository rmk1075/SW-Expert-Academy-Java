T = int(input())

for t in range(T):
    status = list(map(int, input()))
    init = [0 for _ in range(len(status))]

    count = 0
    for i in range(len(status)):
        if init[i] != status[i]:
            count += 1
            for j in range(i, len(init)):
                init[j] = status[i]
                    
    print('#' + str(t+1) + ' ' + str(count))