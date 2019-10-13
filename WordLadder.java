/* PROBLEM - STATMENT
Version-1
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

Version-2 (similar to 1 with minimal changes)
A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".

Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.

For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.

Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.

Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.

Note:

Starting point is assumed to be valid, so it might not be included in the bank.
If multiple mutations are needed, all mutations during in the sequence must be valid.
You may assume start and end string is not the same.
 */

public class WordLadderSol {
    public int WordLadderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        int distance = 1;
        queue.offer(beginWord);
        wordList.remove(beginWord);
        wordList.add(endWord);

        while (!queue.isEmpty()) {
            int wordCount = queue.size();

            for (int i = 0; i < wordCount; i++) {
                String curr = queue.poll();
                char[] chars = curr.toCharArray();
                for (int j = 0; j < curr.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (chars[j] == c) {
                            continue;
                        }
                        char temp = chars[j];
                        chars[j] = c;
                        String next = new String(chars);
                        if (next.equals(endWord)) {
                            return distance + 1;
                        }
                        if (wordList.contains(next)) {
                            queue.offer(next);
                            wordList.remove(next);
                        }
                        chars[j] = temp;
                    }
                }
            }
            distance++;
        }
        return 0;
    }
}
