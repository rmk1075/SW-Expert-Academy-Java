def search(maxinos, index, cores, N):
    if len(cores)-1 < index:
        return 0
    
    if cores[index][0] == 0 or cores[index][0] == N-1 or cores[index][1] == 0 or cores[index][1] == N-1:
        return search(maxinos, index+1, cores, N)

    result = N
    maxinos_ = maxinos
    x = cores[index][0]
    y = cores[index][1]

    print(x, y)

    #top
    top = 0
    temp = [maxinos[i][y] for i in range(0,x)]
    if (1 or 2) not in temp:
        for i in  range(0, x):
            maxinos_[i][y] = 2
        top += x + search(maxinos_, index+1, cores, N)

    if 0 < top:
        result = top
        maxinos_ = maxinos

    #bottom
    bottom = 0
    temp = [maxinos[i][y] for i in range(x+1,N)]
    if (1 or 2) not in temp:
        for i in range(x+1, N):
            maxinos_[i][y] = 2
        bottom += (N-x-1) + search(maxinos_, index+1, cores, N)

    if 0 < bottom and bottom < result:
        result = bottom
        maxinos_ = maxinos


    #left
    left = 0
    temp = [maxinos[x][i] for i in range(0,y)]
    if (1 or 2) not in temp:
        for i in range(0, y):
            maxinos_[x][i] = 2
        left += y + search(maxinos_, index+1, cores, N)

    if 0 < left and left < result:
        result = left
        maxinos_ = maxinos

    #right
    right = 0
    temp = [maxinos[x][i] for i in range(y+1,N)]
    if (1 or 2) not in temp:
        for i in range(y+1, N):
            maxinos_[x][i] = 2
        right += (N-y-1) + search(maxinos_, index+1, cores, N)

    if 0 < right and right < result:
        result = right
        maxinos_ = maxinos

    print(result)

    return result

T = int(input())
for t in range(T):
    result = 0
    N = int(input())
    cores = list()
    maxinos = [[0 for _ in range(N)] for _ in range(N)]
    for i in range(N):
        temp = input().split()
        for j in range(N):
            maxinos[i][j] = int(temp[j])
            if maxinos[i][j] == 1:
                cores.append((i, j))

    print(cores)

    if len(cores) == 0:
        print('#'+str(t+1)+' 0')
        continue

    result = search(maxinos, 0, cores, N)

    print('#'+str(t+1), str(result))
