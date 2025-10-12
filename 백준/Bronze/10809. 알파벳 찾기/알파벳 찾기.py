arr =input()

place= [-1]*26  # 밑바탕이 되어줄 모두 -1을 가진 리스트 만들기

for i in range(len(arr)):
    idx = ord(arr[i])-ord('a')  # 어차피 i를 가지고 변경해서 idx를 만드는것.
    if place[idx] == -1:    # 리스트의 자리마다 값들에 대하여.
        place[idx] = i
# print(place)
# 
print(" ".join(map(str, place)))