public class BC66E3 {
    public static int homeCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int cost = 0;
        for (int j = homePos[0]; j != startPos[0]; j += ((homePos[0] >= startPos[0]) ? -1 : 1))
            cost += rowCosts[j];
        for (int j = homePos[1]; j != startPos[1]; j += ((homePos[1] >= startPos[1]) ? -1 : 1))
            cost += colCosts[j];
        return cost;
    }

    public static void main(String[] args) {
        System.out.println(homeCost(new int[]{1, 0}, new int[]{2, 3}, new int[]{5, 4, 3}, new int[]{8, 2, 6, 7}) == 18);
        System.out.println(homeCost(new int[]{0, 0}, new int[]{0, 0}, new int[]{5}, new int[]{5}) == 0);
    }
}
