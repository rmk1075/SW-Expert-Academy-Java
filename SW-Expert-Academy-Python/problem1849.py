T = int(input().strip())
sol = str()

for i in range(T):
    # print('#'+str(i+1), end='')
    sol += '#'+str(i+1) ##

    N, M = map(int, input().strip().split())
    diff = [dict() for _ in range(N)]
    while 0 < M:
        temp = input().strip().split()
        a = int(temp[1])-1
        b = int(temp[2])-1

        if temp[0] == '!':
            diff[a].update({str(b): -int(temp[3])})
            diff[b].update({str(a): int(temp[3])})

            for k in diff[a].keys():
                if b not in diff[int(k)].keys():
                    diff[int(k)][str(b)] = diff[a][str(b)] - diff[a][str(k)]
                    diff[b][str(k)] = -diff[int(k)][str(b)]

            for k in diff[b].keys():
                if a not in diff[int(k)].keys():
                    diff[int(k)][str(a)] = diff[b][str(a)] - diff[b][str(k)]
                    diff[a][str(k)] = -diff[int(k)][str(a)]

        else:
            if str(a) in diff[b].keys():
                #print(' '+str(diff[b][a]))
                sol += ' '+str(diff[b][str(a)])
            else:
                # print(' UNKNOWN', end='')
                sol += ' UNKNOWN' ##
        
        M -= 1
    # print()
    sol += '\n'

print(sol)
