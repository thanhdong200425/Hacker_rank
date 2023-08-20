package Climbing_a_Leader_Board;

import java.util.*;

class Solution {

    private static Map<Integer, Integer> removeDuplicate(List<Integer> ranked) {
        Map<Integer, Integer> scoreToRank = new HashMap<Integer, Integer>();
        int currentRank = 1;
        for (int i = 0; i < ranked.size(); i++) {
            int score = ranked.get(i);
            if (!scoreToRank.containsKey(score)) {
                scoreToRank.put(score, currentRank);
                currentRank++;
            }
        }
        return scoreToRank;
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> players) {
        if (ranked.isEmpty() || players.isEmpty()) {
            return null;
        }

        List<Integer> result = new ArrayList<Integer>();
        Map<Integer, Integer> scoreToRank = removeDuplicate(ranked);

        int index = ranked.size() - 1;
        for (int i = 0; i < players.size(); i++) {
            int playerScore = players.get(i);
            while (index >= 0 && playerScore >= ranked.get(index)) {
                index--;
            }

            int playerRank = (index < 0) ? 1 : (scoreToRank.get(ranked.get(index)) + 1);
            result.add(playerRank);
        }

        return result;
    }

}