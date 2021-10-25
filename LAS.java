import java.util.ArrayList;

/*
 * Longest Alternating Subarray Algorithm -> O(n)
 * Author: SwissCoding
 */

public class LAS {
    public static void main(String[] args) {
        // sample array
        int[] sample = {0, 84, 35, 92, 10, 2, 8, 18, 14, 9};

        // storing the result
        int result = longest_alternating_subarray(9, sample);

        // output
        System.out.println(result);
    }
	
    public static int longest_alternating_subarray(int n, int[] A) {
        // n: length of A
        // A: an array of distinct integers (consider that the array starts with
    	//    index 1 in this example)
        
    	// ArrayList to store the boolean sequence
        ArrayList<Boolean> sequence = new ArrayList<Boolean>();
        
        // variables
        int counter = 0;
        int max = 0;
        
        // creating the boolean sequence
        for(int i = 2; i < n + 1; i++) {
            sequence.add(A[i - 1] < A[i]);
        }
        
        // determining longest alternating subarray
        for(int j = 1; j < sequence.size(); j++) {
            if((!sequence.get(j - 1) && sequence.get(j)) || (sequence.get(j - 1) && !sequence.get(j))) {
                counter++;
            } else {
                counter += 2;
                if(counter > max) {
                    max = counter;
                }
                counter = 0;
            }
        }
        return max;
    }
}
