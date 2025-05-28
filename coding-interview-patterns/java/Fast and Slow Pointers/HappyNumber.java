public class HappyNumber {
    public boolean happyNumber(int n) {
        int slow, fast;
        slow = fast = n;
        while (true) {
            slow = getNextNum(slow);
            fast = getNextNum(getNextNum(fast));
            if (fast == 1) return true;
            // If the fast and slow pointers meet, a cycle is detected. 
            // Hence, 'n' is not a happy number.
            else if (fast == slow) return false;
        }
    }

    private int getNextNum(int x) {
        int nextNum = 0;
        while (x > 0) {
            // Extract the last digit of 'x'.
            int digit = x % 10;
            // Truncate (remove) the last digit from 'x' using floor 
            // division.
            x /= 10;
            // Add the square of the extracted digit to the sum.
            nextNum += Math.pow(digit, 2);
        }
        return nextNum;
    }
}
