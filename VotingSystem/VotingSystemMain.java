package Day2.VotingSystem;



import java.util.*;

 class VotingSystem {
    private final Map<String, Integer> voteCountMap; // Stores votes (Candidate Votes)
    private final TreeMap<String, Integer> sortedVoteMap; // Stores votes in sorted order (by candidate name)
    private final LinkedHashMap<String, Integer> voteOrderMap; // Maintains voting order

    public VotingSystem() {
        voteCountMap = new HashMap<>();
        sortedVoteMap = new TreeMap<>();
        voteOrderMap = new LinkedHashMap<>();
    }

    // Cast a vote for a candidate
    public void castVote(String candidate) {
        voteCountMap.put(candidate, voteCountMap.getOrDefault(candidate, 0) + 1);
        sortedVoteMap.put(candidate, voteCountMap.get(candidate));
        voteOrderMap.put(candidate, voteCountMap.get(candidate));
    }

    // Display votes in the order they were received
    public void displayVotesInOrder() {
        System.out.println("\nVotes in the Order Received:");
        voteOrderMap.forEach((candidate, votes) ->
                System.out.println(candidate + " -> " + votes + " votes"));
    }

    // Display results sorted by candidate name (TreeMap)
    public void displaySortedResults() {
        System.out.println("\nResults Sorted by Candidate Name:");
        sortedVoteMap.forEach((candidate, votes) ->
                System.out.println(candidate + " -> " + votes + " votes"));
    }

    // Display final results sorted by highest votes first
    public void displayResultsByVoteCount() {
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(voteCountMap.entrySet());
        sortedEntries.sort((a, b) -> b.getValue().compareTo(a.getValue())); // Descending order

        System.out.println("\nFinal Results Sorted by Vote Count:");
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }
}

public class VotingSystemMain {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Casting votes
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");

        // Display votes in order received
        votingSystem.displayVotesInOrder();

        // Display results sorted by candidate name
        votingSystem.displaySortedResults();

        // Display final results sorted by vote count
        votingSystem.displayResultsByVoteCount();
    }
}