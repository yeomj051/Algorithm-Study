# 5
# 4 1 5 2 3 => 1 2 3 4 5
# 5
# 1 3 7 9 5

originNum = int(input())
originlist = list(map(int,input().split()))
originlist.sort()

checkedNum = int(input())
checkedlist = list(map(int,input().split()))


def check(cheked, start, end):
    # print("start = ", start, " end = ", end)
    pivot = start + int((end - start) / 2)
    # print(pivot)

    if originlist[pivot] == cheked:
        return 1

    if end - pivot == 0 or pivot - start == 0 :
        return 0

    if cheked < originlist[pivot]:
        if check(cheked, start, pivot):
            return 1
        else: return 0
    else:
        if check(cheked, pivot, end):
            return 1
        else: return 0


for cheked in checkedlist:
    # print("checked " , cheked)
    print(check(cheked, 0, originNum))