public class WordLadder {
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
