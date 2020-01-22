import itertools

T = int(input())

for t in range(T):
    N, L = map(int, input().split())
    ingredients = list()
    for _ in range(N):
        ingredients.append(list(map(int, input().split())))

    visited = set()
    maxVal = 0

    for r in range(1, len(ingredients)+1):
        for c in itertools.combinations(ingredients, r):
            point = 0
            cal = 0
            for i in range(len(c)):
                point += c[i][0]
                cal += c[i][1]

            if cal <= L:
                maxVal = max(maxVal, point)
        

    # def search(points, cal, index):
    #     global maxVal
    #     maxVal = max(maxVal, points)

    #     global visited        
    #     for i in range(N):
    #         if i not in visited and cal+ingredients[index][1] <= cal:
    #             visited.add(index)
    #             search(points+ingredients[index][0], cal+ingredients[index][1], index)
    #             visited.remove(index)
    
    # for i in range(N):
    #     if i not in visited:
    #         search(0, 0, i)


    print('#' + str(t+1) + ' ' + str(maxVal))