#include <stdio.h>

int solution(int n) {
    int answer = 0;

    for(int i = 2; i <= n; i++) {
        int prime = 1;

        for(int x = 2; x * x <= i; x++) {
            if(i % x == 0) {
                prime = 0;
                break;
            }
        }

        if(prime) {
            answer++;
        }
    }

    return answer;
}