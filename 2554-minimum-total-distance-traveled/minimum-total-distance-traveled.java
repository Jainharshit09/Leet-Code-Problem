class Solution {
    private long calculateMinDistance(
            int robotIdx,
            int factoryIdx,
            List<Integer> robot,
            List<Integer> factoryPositions, long[][] memo) {
        // All robots assigned
        if (robotIdx == robot.size())
            return 0;
        // No factories left to assign
        if (factoryIdx == factoryPositions.size())
            return (long) 1e12;
        if (memo[robotIdx][factoryIdx] != -1)
            return memo[robotIdx][factoryIdx];
        // Option 1: Assign current robot to current factory
        long assign = Math.abs(robot.get(robotIdx) - factoryPositions.get(factoryIdx)) +
                calculateMinDistance(
                        robotIdx + 1,
                        factoryIdx + 1,
                        robot,
                        factoryPositions, memo);
        long skip = calculateMinDistance(
                robotIdx,
                factoryIdx + 1,
                robot,
                factoryPositions, memo);
        return memo[robotIdx][factoryIdx] = Math.min(assign, skip);
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
         Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
         List<Integer> factoryPositions = new ArrayList<>();
        for (int[] f : factory) {
            for (int i = 0; i < f[1]; i++) {
                factoryPositions.add(f[0]);
            }
        }
         int robotCount = robot.size();
        int factoryCount = factoryPositions.size();
         long[][] memo = new long[robotCount][factoryCount];
        for (long[] row : memo) Arrays.fill(row, -1);
        return calculateMinDistance(0, 0, robot, factoryPositions,memo);
    }
}