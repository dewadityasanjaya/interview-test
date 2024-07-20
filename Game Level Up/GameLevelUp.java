import java.util.*;

public class GameLevelUp {
    
    public static int countPlayersWhoCanLevelUp(int n, int k, List<Integer> scores) {
        // Convert List<Integer> to Integer array for sorting
        Integer[] sortedScores = scores.toArray(new Integer[0]);
        Arrays.sort(sortedScores, (a, b) -> b - a);
        
        Map<Integer, Integer> scoreToRank = new HashMap<>();
        int rank = 1;

        // Assign ranks to the scores
        for (int i = 0; i < n; i++) {
            if (!scoreToRank.containsKey(sortedScores[i])) {
                scoreToRank.put(sortedScores[i], rank);
            }
            rank++;
        }

        int count = 0;
        for (int score : scores) {
            if (score > 0 && scoreToRank.get(score) <= k) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        List<Integer> scores = Arrays.asList(100, 50, 50, 25);

        System.out.println(countPlayersWhoCanLevelUp(n, k, scores));  // Output: 3
    }
}
