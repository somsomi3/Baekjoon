arr = input()

# 크로아티아 알파벳 목록
xxx = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']

# 크로아티아 알파벳을 한 글자로 치환
for x in xxx:
    arr = arr.replace(x, '*')  # '*'는 임시 문자로 사용

# 남은 문자열 길이가 곧 크로아티아 알파벳의 개수
cnt = len(arr)
print(cnt)
