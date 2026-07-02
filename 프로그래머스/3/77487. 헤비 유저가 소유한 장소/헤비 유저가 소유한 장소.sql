#"최종적으로 출력해야 하는 데이터"와 "조건을 구하기 위해 계산해야 하는 데이터"가 다르면 서브쿼리를 생각해보자.

SELECT ID, NAME, HOST_ID 
# 모든 걸 다구해야하는데
FROM PLACES
WHERE HOST_ID IN (
# HOST_ID에만 조건이 걸릴때에 서브쿼리 사용
    SELECT HOST_ID
    FROM PLACES
    GROUP BY HOST_ID
    HAVING COUNT(*) >= 2
)
ORDER BY ID;