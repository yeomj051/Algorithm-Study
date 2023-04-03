# 4
# 3 5 2 7
# 5 7 7 -1

num_size = int(input())
num_list = map(int,input().split())
print(type(num_list))

for i in range(num_size):
    pop_num = num_list.pop()
