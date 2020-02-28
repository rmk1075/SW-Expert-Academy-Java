maxVal = -100000000
minVal = 100000000


def find(index, sum):
    if index == len(nums):
        global maxVal, minVal
        maxVal = max(maxVal, sum)
        minVal = min(minVal, sum)
        return

    for i in range(len(op)):
        if op[i] != 0:
            op[i] -= 1

            if i == 0:
                find(index+1, sum + nums[index])
            elif i == 1:
                find(index+1, sum - nums[index])
            elif i == 2:
                find(index+1, sum * nums[index])
            elif i == 3:
                find(index+1, int(sum / nums[index]))

            op[i] += 1

T = int(input())
for t in range(T):
    N = int(input())

    # 0: '+', 1: '-', 2: '*', 3: '/'
    op = list(map(int, input().strip().split(' ')))
    nums = list(map(int, input().strip().split(' ')))

    maxVal = -100000000
    minVal = 100000000

    find(1, nums[0])
    print("#" + str(t+1) + " " + str(abs(maxVal - minVal)))
