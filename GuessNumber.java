/* PROBLEM - STATMENT
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 */

//Solution

public class GuessNumberSol {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int result = guess(mid);

            if (result == 0) {
                return mid;
            } else if (result == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
