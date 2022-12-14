public class E11 {

    public static int maxArea(int[] height) {
        int maxVol = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) maxVol = Math.max((j - i) * Math.min(height[i], height[j]), maxVol);
        }
        return maxVol;
    }

    public static int maxArea2(int[] height) {
        int maxVol = 0, maxHeightLeft = height[0];
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] < maxHeightLeft) continue;
            maxHeightLeft = height[i];
            int maxHeightRight = height[height.length - 1];
            for (int j = height.length - 1; j > i; j--) {
                if (height[j] < maxHeightRight) continue;
                maxHeightRight = height[j];
                maxVol = Math.max((j - i) * Math.min(maxHeightLeft, maxHeightRight), maxVol);
            }
        }
        return maxVol;
    }

    public static int maxArea3(int[] height) {
        int maxVol = 0, left = 0, right = height.length - 1;
        while (left < right) {
            maxVol = Math.max((right - left) * Math.min(height[left], height[right]), maxVol);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxVol;
    }

    public static int maxArea4(int[] height) {
        int maxVol = 0, left = 0, right = height.length - 1, leftHeight = height[0], rightHeight = height[height.length - 1];
        boolean shrinkLeft = true;
        while (left < right) {
            if (shrinkLeft && (height[left] < leftHeight)) {
                left++;
                continue;
            } else if (!shrinkLeft && (height[right] < rightHeight)) {
                right--;
                continue;
            } else {
                leftHeight = height[left];
                rightHeight = height[right];
            }
            maxVol = Math.max((right - left) * Math.min(leftHeight, rightHeight), maxVol);
            if (leftHeight > rightHeight) {
                right--;
                shrinkLeft = false;
            } else {
                left++;
                shrinkLeft = true;
            }
        }
        return maxVol;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}) == 49);
        System.out.println(maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}) == 49);
        System.out.println(maxArea2(new int[]{1, 1}) == 1);
        System.out.println(maxArea3(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}) == 49);
        System.out.println(maxArea3(new int[]{1, 1}) == 1);
        System.out.println(maxArea4(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}) == 49);
        System.out.println(maxArea4(new int[]{1, 1}) == 1);
    }
}
