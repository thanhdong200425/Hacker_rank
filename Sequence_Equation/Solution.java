package Sequence_Equation;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Solution {
    public static List<Integer> permutationEquation(List<Integer> a) {
        List<Integer> results = new ArrayList<>();
        int n = a.size();
        int[] indexMapping = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            indexMapping[a.get(i - 1)] = i;
        }

        for (int x = 1; x <= n; x++) {
            int p = indexMapping[indexMapping[x]];
            results.add(p);
        }

        return results;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(Arrays.asList(5, 2, 1, 3, 4));
        Solution.permutationEquation(a);
        for (int num : a) {
            System.out.println(num);
        }

    }
}
