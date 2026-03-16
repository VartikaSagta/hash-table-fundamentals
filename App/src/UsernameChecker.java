public import java.util.*;

public class UsernameChecker {

    // Stores registered usernames
    private HashMap<String, Integer> usernameMap = new HashMap<>();

    // Tracks frequency of attempted usernames
    private HashMap<String, Integer> attemptFrequency = new HashMap<>();

    public UsernameChecker() {
        // Pre-existing users
        usernameMap.put("john_doe", 101);
        usernameMap.put("admin", 102);
        usernameMap.put("alice", 103);
    }

    // Check username availability
    public boolean checkAvailability(String username) {

        attemptFrequency.put(username,
                attemptFrequency.getOrDefault(username, 0) + 1);

        return !usernameMap.containsKey(username);
    }

    // Suggest alternative usernames
    public List<String> suggestAlternatives(String username) {

        List<String> suggestions = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            String suggestion = username + i;

            if (!usernameMap.containsKey(suggestion)) {
                suggestions.add(suggestion);
            }
        }

        suggestions.add(username.replace("_", "."));

        return suggestions;
    }

    // Get most attempted username
    public String getMostAttempted() {

        String mostAttempted = "";
        int max = 0;

        for (Map.Entry<String, Integer> entry : attemptFrequency.entrySet()) {

            if (entry.getValue() > max) {
                max = entry.getValue();
                mostAttempted = entry.getKey();
            }
        }

        return mostAttempted + " (" + max + " attempts)";
    }

    public static void main(String[] args) {

        UsernameChecker system = new UsernameChecker();

        System.out.println("john_doe available: "
                + system.checkAvailability("john_doe"));

        System.out.println("jane_smith available: "
                + system.checkAvailability("jane_smith"));

        System.out.println("Suggestions: "
                + system.suggestAlternatives("john_doe"));

        System.out.println("Most attempted username: "
                + system.getMostAttempted());
    }
} 
