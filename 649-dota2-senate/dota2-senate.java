class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> queue = new LinkedList<>();
        int rCount = 0, dCount = 0; // count of active senators
        int rBan = 0, dBan = 0;     // pending bans against each party

        // Initial processing
        for (char c : senate.toCharArray()) {
            queue.offer(c);
            if (c == 'R') rCount++;
            else dCount++;
        }

        // Keep going until one party is eliminated
        while (rCount > 0 && dCount > 0) {
            char curr = queue.poll();

            if (curr == 'R') {
                if (rBan > 0) {
                    rBan--; // this R is banned
                    rCount--;
                } else {
                    dBan++; // R bans a D
                    queue.offer('R'); // R survives, goes to end of queue
                }
            } else {
                if (dBan > 0) {
                    dBan--; // this D is banned
                    dCount--;
                } else {
                    rBan++; // D bans an R
                    queue.offer('D'); // D survives
                }
            }
        }

        return rCount > 0 ? "Radiant" : "Dire";
    }
}
