import java.io.*;           // 입력 출력을 위한 라이브러리
import java.util.*;         // 자료구조(List, Queue 등)를 위한 라이브러리

public class Main {
    static ArrayList<Integer>[] graph;  // 인접 리스트로 그래프 표현
    static boolean[] visited;           // 방문 여부 체크 배열
    static StringBuilder sb = new StringBuilder(); // 출력 결과를 모아두는 버퍼

    // DFS 함수 (재귀)
    static void dfs(int v) {
        visited[v] = true;             // 현재 노드를 방문 처리
        sb.append(v).append(" ");      // 결과에 현재 노드 추가

        // 현재 정점과 연결된 정점들을 순회
        for (int next : graph[v]) {
            if (!visited[next]) {      // 방문하지 않은 정점이면
                dfs(next);             // 재귀 호출
            }
        }
    }

    // BFS 함수 (큐 사용)
    static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>(); // 큐 선언
        visited[v] = true;                         // 시작 정점 방문 처리
        queue.add(v);                              // 큐에 시작 정점 넣기

        while (!queue.isEmpty()) {                 // 큐가 빌 때까지 반복
            int now = queue.poll();                // 현재 정점 꺼내기
            sb.append(now).append(" ");            // 출력 결과에 추가

            for (int next : graph[now]) {          // 인접한 정점들 탐색
                if (!visited[next]) {              // 아직 방문하지 않았다면
                    visited[next] = true;          // 방문 처리
                    queue.add(next);               // 큐에 추가
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 한 줄을 공백 기준으로 나누기 위한 StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int V = Integer.parseInt(st.nextToken()); // 시작 정점

        // 인접 리스트 초기화 (1부터 N까지 사용)
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력 받아 양방향 연결
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 정점 a
            int b = Integer.parseInt(st.nextToken()); // 정점 b

            graph[a].add(b); // a → b 연결
            graph[b].add(a); // b → a 연결 (무방향 그래프)
        }

        // 각 정점에 연결된 리스트를 정렬 (작은 번호부터 방문하기 위함)
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1]; // 방문 배열 초기화
        dfs(V);                       // DFS 수행
        sb.append("\n");              // 줄 바꿈

        visited = new boolean[N + 1]; // BFS를 위해 방문 배열 초기화
        bfs(V);                       // BFS 수행

        System.out.println(sb);       // 결과 출력
    }
}
