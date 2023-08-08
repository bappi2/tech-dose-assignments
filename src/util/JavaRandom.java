package util;

import java.util.LinkedList;
import java.util.List;

public class JavaRandom {


    // Constructor
    void ListOfList(int v)

    {
        List<Integer> adj[];
        // or List<Integer> [] adj;

        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }
}
