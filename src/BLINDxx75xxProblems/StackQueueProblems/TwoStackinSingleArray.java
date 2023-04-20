package BLINDxx75xxProblems.StackQueueProblems;

import java.util.Arrays;
import java.util.List;

public class TwoStackinSingleArray {
    private int[] arr;
    private int capacity;
    private int top1, top2;

    // Constructor
    public TwoStackinSingleArray(int n)
    {
        capacity = n;
        arr = new int[n];
        top1 = -1;
        top2 = n;
    }

    // Function to insert a given element into the first stack
    public void pushFirst(int key)
    {
        // check if the array is full
        if (top1 + 1 == top2)
        {
            System.out.println("Stack Overflow");
            System.exit(-1);
        }

        top1++;
        arr[top1] = key;
    }

    // Function to insert a given element into the second stack
    public void pushSecond(int key)
    {
        // check if the array is full
        if (top1 + 1 == top2)
        {
            System.out.println("Stack Overflow");
            System.exit(-1);
        }

        top2--;
        arr[top2] = key;
    }

    // Function to pop an element from the first stack
    public int popFirst()
    {
        // if no elements are left in the array
        if (top1 < 0)
        {
            System.out.println("Stack Underflow");
            System.exit(-1);
        }

        int top = arr[top1];
        top1--;
        return top;
    }

    // Function to pop an element from the second stack
    public int popSecond()
    {
        // if no elements are left in the array
        if (top2 >= capacity)
        {
            System.out.println("Stack Underflow");
            System.exit(-1);
        }

        int top = arr[top2];
        top2++;
        return top;
    }

    public static void main(String[] args)
    {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(6, 7, 8, 9, 10);

        TwoStackinSingleArray stack = new TwoStackinSingleArray(list1.size() + list2.size());

        for (int i: list1) {
            stack.pushFirst(i);
        }

        for (int j: list2) {
            stack.pushSecond(j);
        }

        System.out.println("Popping element from the first stack: " + stack.popFirst());
        System.out.println("Popping element from the second stack: " + stack.popSecond());
    }
}




