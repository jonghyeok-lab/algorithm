import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PG_배달 {

//    private static Map<Integer, Integer> result = new HashMap<>();

    public int solution(int N, int[][] road, int K) {
        List<Node>[] nodes = new ArrayList[N + 1];
        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0; i < road.length; i++) {
            int node1 = road[i][0];
            int node2 = road[i][1];
            int distance = road[i][2];

            nodes[node1].add(new Node(node2, distance));
            nodes[node2].add(new Node(node1, distance));
        }

        int[] minDist = new int[N + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(n -> n.distance));
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if(minDist[current.myNode] < current.distance) continue;

            for (Node neighbor : nodes[current.myNode]) {
                int newDistance = neighbor.distance + current.distance;
                if (newDistance < minDist[neighbor.myNode]) {
                    minDist[neighbor.myNode] = newDistance;
                    pq.offer(new Node(neighbor.myNode, newDistance));
                }
            }
        }
        int answer = 0;
        for (int i : minDist) {
            if(i <= K) answer++;
        }

        return answer;
    }

//    private void dfs(int dst, List<Node> nodeList, int totalDistance, List<Node>[] nodes, int K) {
//        for(Node node : nodeList) {  // 연결되있는거 찾기
//            if(node.myNode == 1) continue; // 1이면 안찾아도 됨.
//            if(node.visited) continue;  // 방문했으면 안찾아도됨
//            if(result.get(node.myNode) != null) {
//                if(totalDistance + node.distance > K) continue;
//            }   // 방문하려는 곳이 이미 있으면 안찾아도 됨.
//
//            // System.out.println(node.myNode); // 방문
//
//            if(node.myNode == dst || result.get(node.myNode) == null) { // 방문한 곳이 도착지점이라면
//                if(totalDistance + node.distance <= K) { // 거리 재기
//                    // System.out.println(node.myNode + " 추가");
//                    result.put(node.myNode, 0); // 맞으면 반환.
//                } else {
//                    continue;
//                }
//            }
//            node.visited = true;
//            dfs(dst, nodes[node.myNode], totalDistance + node.distance, nodes, K);
//            node.visited = false;
//        }
//    }

    class Node {
        int myNode;
        int distance;
        boolean visited;

        Node(int myNode, int distance) {
            this.myNode = myNode;
            this.distance = distance;
            this.visited = false;
        }
    }
}
