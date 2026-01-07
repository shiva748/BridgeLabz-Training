import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VotingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> voteCount = new HashMap<>();
        LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();

        System.out.print("Enter number of votes: ");
        int totalVotes = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < totalVotes; i++) {
            System.out.print("Enter candidate name: ");
            String candidate = sc.nextLine();

            recordVote(candidate, voteCount, voteOrder);
        }

        System.out.println("\nVotes in Order (LinkedHashMap):");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        TreeMap<String, Integer> sortedResults = new TreeMap<>(voteCount);

        System.out.println("\nFinal Results (Sorted by Candidate):");
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        sc.close();
    }

    private static void recordVote(
            String candidate,
            HashMap<String, Integer> voteCount,
            LinkedHashMap<String, Integer> voteOrder) {

        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
    }
}
