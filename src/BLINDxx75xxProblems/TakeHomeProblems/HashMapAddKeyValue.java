package BLINDxx75xxProblems.TakeHomeProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    You've created a new programming language, and now you've decided to add hashmap support to it.
    Actually you are quite disappointed that in common programming languages it's impossible
    to add a number to all hashmap keys, or all its values. So you've decided to take matters
    into your own hands and implement your own hashmap in your new language that has
    the following operations:

insert x y - insert an object with key x and value y.
get x - return the value of an object with key x.
addToKey x - add x to all keys in map.
addToValue y - add y to all values in map.
To test out your new hashmap, you have a list of queries in the form of two arrays:
queryTypes contains the names of the methods to be called (eg: insert, get, etc),
and queries contains the arguments for those methods (the x and y values).

Your task is to implement this hashmap, apply the given queries, and to find the
sum of all the results for get operations.

Example

For queryType = ["insert", "insert", "addToValue", "addToKey", "get"]
and query = [[1, 2], [2, 3], [2], [1], [3]], the output should be solution(queryType, query) = 5.

The hashmap looks like this after each query:

1 query: {1: 2}
2 query: {1: 2, 2: 3}
3 query: {1: 4, 2: 5}
4 query: {2: 4, 3: 5}
5 query: answer is 5
The result of the last get query for 3 is 5 in the resulting hashmap.

For queryType = ["insert", "addToValue", "get", "insert", "addToKey", "addToValue", "get"]
and query =      [[1, 2],    [2],        [1],    [2, 3],        [1],        [-1],    [3]],
the output should be solution(queryType, query) = 6.

The hashmap looks like this after each query:

1 query: {1: 2}
2 query: {1: 4}
3 query: answer is 4
4 query: {1: 4, 2: 3}
5 query: {2: 4, 3: 3}
6 query: {2: 3, 3: 2}
7 query: answer is 2
The sum of the results for all the get queries is equal to 4 + 2 = 6.

Input/Output

[execution time limit] 3 seconds (java)

[memory limit] 1 GB

[input] array.string queryType

Array of query types. It is guaranteed that each queryType[i] is either
"addToKey", "addToValue", "get", or "insert".

Guaranteed constraints:
1 ≤ queryType.length ≤ 105.

[input] array.array.integer query

Array of queries, where each query is represented either by two numbers
for insert query or by one number for other queries. It is guaranteed that
during all queries all keys and values are in the range [-109, 109].

Guaranteed constraints:
query.length = queryType.length,
1 ≤ query[i].length ≤ 2.

[output] integer64

The sum of the results for all get queries.
     */
public class HashMapAddKeyValue {

    int [] arr;


    void insert(int key, int value) {
        arr[key] = value;
    }
    int get(int key) {
        return arr[key];
    }

    void addToValue(int addValue) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != Integer.MIN_VALUE) {
                arr[i] += addValue;
            }
        }
    }

    void addToKey(int addKey) {
        if (addKey > 0) {
            for (int i = arr.length -1 - addKey; i >= 0 ; i--) {
                arr[i + addKey] = arr[i];
                arr[i] = Integer.MIN_VALUE;
            }
        }
        else {
            for (int i = addKey; i < arr.length; i++) {
                arr[i + addKey] = arr[i];
                arr[i] = Integer.MIN_VALUE;
            }
        }

    }
    HashMapAddKeyValue() {
        // keys and values are in the range [-109, 109]
        arr = new int [109 + 109 + 1];
        Arrays.fill(arr, Integer.MIN_VALUE);
    }
    long getSum(String[] queryType, int[][]query){
        int result = 0;
        for (int i = 0; i < queryType.length; i++ ) {
            switch(queryType[i]) {
                case "insert":
                    insert(query[i][0], query[i][1]);
                    break;
                case "get":
                    result += get(query[i][0]);
                    break;
                case "addToValue" :
                    addToValue(query[i][0]);
                    break;
                case "addToKey" :
                    addToKey(query[i][0]);
                    break;
                    default:
                    // code block
            }
        }
        return result;
    }

    public long hashMapQueries2(String[] queryType, int[][] query) {
        long keyAdd = 0;
        long valueAdd = 0;
        Map<Long, Long> hashMap = new HashMap<>();
        long sum = 0;

        for (int i = 0; i < queryType.length; i++) {
            switch (queryType[i]) {
                case "insert":
                    long key = query[i][0] - keyAdd;
                    long value = query[i][1] - valueAdd;
                    hashMap.put(key, value);
                    break;
                case "addToKey":
                    keyAdd += query[i][0];
                    break;
                case "addToValue":
                    valueAdd += query[i][0];
                    break;
                case "get":
                    long adjustedKey = query[i][0] - keyAdd;
                    if (hashMap.containsKey(adjustedKey)) {
                        sum += hashMap.get(adjustedKey) + valueAdd;
                    }
                    break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] queryType = new String [] {"insert", "insert", "addToValue", "addToKey", "get"};
        int[][] query = new int[][] {{1, 2},    {2, 3}, {2}, {1}, {3}};

        String[] queryType2 = new String[] {"insert", "addToValue", "get", "insert", "get", "addToKey", "addToValue", "get"};
        int[][] query2 = new int[][] { {1, 2}, {2}, {1}, {2, 3}, {2}, {1}, {-1}, {3}};
        HashMapAddKeyValue hmkv = new HashMapAddKeyValue();

        System.out.println("My implementation: " +hmkv.getSum(queryType2, query2));
        System.out.println("Shriram implementation: " + hmkv.hashMapQueries2(queryType2, query2));
    }
}
