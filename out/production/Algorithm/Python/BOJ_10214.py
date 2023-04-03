# 1
# 1 0
# 0 0
# 0 0
# 0 0
# 0 0
# 0 0
# 0 0
# 0 0
# 0 0
# Yonsei", 고려대가 이겼을 경우 "Korea

test_case = int(input())
for j in range(test_case): 
    Y_total, K_total = 0,0
    for i in range(9):
        Y, K = map(int, input().split())
<<<<<<< Updated upstream
        print(Y,K)
=======
>>>>>>> Stashed changes
        Y_total += Y
        K_total += K

    if(Y_total > K_total): print("Yonsei")
    elif(Y_total < K_total): print("Korea")
    else: print("Draw")

