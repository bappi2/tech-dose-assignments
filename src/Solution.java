import java.util.*;

public class Solution {
    int [] getServerIndex(int n, int[] arrive, int[] burstTime) {
        if (arrive == null || arrive.length == 0 || burstTime == null || burstTime.length == 0 || arrive.length != burstTime.length) {
            return new int[0];
        }

        int[] result = new int[arrive.length];
        List<Pair> listOfArrive = new ArrayList<>();
        for (int i = 0; i < arrive.length; i++) {
            listOfArrive.add (new Pair(arrive[i], burstTime[i]));
        }
        Collections.sort(listOfArrive, (a, b) -> a.arrive - b.arrive);
        PriorityQueue<EndTimeServer> pq = new PriorityQueue<>((a, b) -> a.endTime - b.endTime );
        PriorityQueue<Integer> availableServer = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            availableServer.offer(i + 1);
        }

        for (int i = 0; i < listOfArrive.size(); i++) {
            Pair curr = listOfArrive.get(i);

            if (!pq.isEmpty() && pq.peek().endTime <= curr.arrive ) {
                EndTimeServer server = pq.poll();
                availableServer.offer(server.server);
            }
            int currServer = availableServer.isEmpty() ? -1 : availableServer.poll();
            pq.offer(new EndTimeServer(curr.arrive +curr.burstTime, currServer));
            result[i] = currServer;
        }

        return  result;
    }

    class Pair {
        int arrive;
        int burstTime;
        public Pair(int arrive, int burstTime) {
            this.arrive = arrive;
            this.burstTime = burstTime;
        }
    }

    class EndTimeServer {
        int endTime;
        int server;
        public EndTimeServer(int endTime, int server) {
            this.endTime = endTime;
            this.server = server;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int [] arrive       = {2, 4, 1, 8, 9};
        int [] burstTime    = {7, 9, 9, 9, 2};

        Solution sol = new Solution();

        int [] result = sol.getServerIndex(n, arrive, burstTime);

        for (int i = 0; i < arrive.length; i++) {
            System.out.println(result[i]);
        }
    }
}
