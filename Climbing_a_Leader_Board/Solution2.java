package Climbing_a_Leader_Board;

import java.util.*;

public class Solution2 {
    private static List<Integer> combineArray(List<Integer> a, List<Integer> b) {
        a.addAll(b);
        return a;
    }

    private static List<Integer> removeDuplicate(List<Integer> a) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : a) {
            if (!set.contains(i)) {
                set.add(i);
            }
        }
        a.removeAll(a);
        a.addAll(set);
        return a;
    }

    private static Map<Integer, Integer> createMap(List<Integer> a) {
        Map<Integer, Integer> map = new HashMap<>();
        Collections.sort(a, Collections.reverseOrder());
        int currentRank = 1, length = a.size();
        for (int i = 0; i < length; i++) {
            int score = a.get(i);
            if (!map.containsKey(score)) {
                map.put(score, currentRank++);
            }
        }
        return map;
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> players) {
        return null;
    }

    public static void main(String[] args) {
        List<Integer> ranked = new ArrayList<>(Arrays.asList(100, 90, 80, 80, 40));
        List<Integer> players = new ArrayList<>(Arrays.asList(70, 80, 120));

        List<Integer> combineArray = Solution2.combineArray(ranked, players);
        combineArray = Solution2.removeDuplicate(combineArray);
        Map<Integer, Integer> map = Solution2.createMap(combineArray);

        List<Integer> result = new ArrayList<>();
        int i = 0;

        for (int j = players.size() - 1; j >= 0; j--) {
            Integer playerScore = players.get(j) - i + 1;
            if (map.containsKey(playerScore)) {
                result.add(map.get(playerScore));
            }
            i++;
        }

        for (int z : result) {
            System.out.println(z);
        }
    }
}
