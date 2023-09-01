package InterviewQuestions;

import java.util.*;

public class KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int child = pid.get(i);
            int parent = ppid.get(i);
            graph.putIfAbsent(parent, new ArrayList<>());
            graph.get(parent).add(child);
        }

        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);

        while (!queue.isEmpty()) {
            int toKill = queue.poll();
            result.add(toKill);

            if (graph.containsKey(toKill)) {
                queue.addAll(graph.get(toKill));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        KillProcess processKiller = new KillProcess();
        List<Integer> pid = Arrays.asList(1, 3, 10, 5);
        List<Integer> ppid = Arrays.asList(3, 0, 5, 3);
        int kill = 5;
        List<Integer> result = processKiller.killProcess(pid, ppid, kill);
        System.out.println(result); // Output: [5, 10]
    }
}
