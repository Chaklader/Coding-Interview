#include <climits> 

int reverse32BitInteger(int n) {
    int reversedN = 0;
    // Keep looping until we've added all digits of 'n' to 'reversedN' 
    // in reverse order.
    while (n != 0) {
        // Extract the last digit of 'n'.
        int digit = n % 10;
        // Remove the last digit from 'n'.
        n /= 10;
        // Check for integer overflow or underflow.
        if (reversedN > INT_MAX / 10 || reversedN < INT_MIN / 10) {
            return 0;
        }
        // Add the current digit to 'reversedN'.
        reversedN = reversedN * 10 + digit;
    }
    return reversedN;
}