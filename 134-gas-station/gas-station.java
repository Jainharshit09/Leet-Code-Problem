class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        int gasInTank = 0, startIndex = 0;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) return -1;
        for (int i = 0; i < n; i++) {
            gasInTank += gas[i] - cost[i];
            if (gasInTank < 0) {
                startIndex = i + 1;
                gasInTank = 0;
            }
        }
        return startIndex;
    }
}