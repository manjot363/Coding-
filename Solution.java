import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert int array to String array for custom sorting
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Custom comparator to sort based on concatenated values
        Arrays.sort(strNums, new Comparator<String>() {
            public int compare(String a, String b) {
                String order1 = a + b;  // Concatenate a followed by b
                String order2 = b + a;  // Concatenate b followed by a
                return order2.compareTo(order1);  // Sort in descending order
            }
        });

        // If the largest number is "0", the result is "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Build the largest number from sorted array
        StringBuilder result = new StringBuilder();
        for (String num : strNums) {
            result.append(num);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Example arrays to test the solution
        int[] nums1 = {10, 2};               // Input: [10, 2]
        int[] nums2 = {3, 30, 34, 5, 9};     // Input: [3, 30, 34, 5, 9]

        Solution solution = new Solution();

        // Test with first example
        String largest1 = solution.largestNumber(nums1);
        System.out.println("Largest number from [10, 2]: " + largest1); // Expected output: "210"

        // Test with second example
        String largest2 = solution.largestNumber(nums2);
        System.out.println("Largest number from [3, 30, 34, 5, 9]: " + largest2); // Expected output: "9534330"
    }
}
