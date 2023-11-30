package ArrayProblems.FaceBook;


import java.util.ArrayList;
        import java.util.List;

public class BudgetCombination {
    public static List<List<Tuple>> findCombinations(List<Tuple> items, int target) {
        List<List<Tuple>> result = new ArrayList<>();
        backtrack(items, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(List<Tuple> items, int remainingBudget, int start,
                                  List<Tuple> currentCombination, List<List<Tuple>> result) {
        if (remainingBudget == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i < items.size(); i++) {
            Tuple currentItem = items.get(i);

            if (currentItem.cost <= remainingBudget) {
                currentCombination.add(currentItem);
                backtrack(items, remainingBudget - currentItem.cost, i, currentCombination, result);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<Tuple> items = List.of(
                new Tuple("A", 5),
                new Tuple("B", 2),
                new Tuple("C", 3)
        );

        int targetBudget = 10;

        List<List<Tuple>> combinations = findCombinations(items, targetBudget);

        for (List<Tuple> combination : combinations) {
            System.out.println(combination);
        }
    }
}

class Tuple {
    String item;
    int cost;

    public Tuple(String item, int cost) {
        this.item = item;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "(" + item + ", " + cost + ")";
    }
}
