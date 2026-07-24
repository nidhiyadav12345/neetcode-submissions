class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Count frequency of each task
        int[] freq = new int[26];

        for (int i = 0; i < tasks.length; i++) {
            char ch = tasks[i];
            freq[ch - 'A']++;
        }

        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(freq[i]);
            }
        }

        int time = 0;

        while (!pq.isEmpty()) {

            List<Integer> temp = new ArrayList<>();

            // Process one cycle of length n + 1
            for (int i = 1; i <= n + 1; i++) {

                if (!pq.isEmpty()) {
                    int frequency = pq.poll();
                    frequency--;
                    temp.add(frequency);
                }
            }

            // Put remaining frequencies back into heap
            for (int f : temp) {
                if (f > 0) {
                    pq.offer(f);
                }
            }

            // Count time
            if (pq.isEmpty()) {
                time += temp.size();
            } else {
                time += n + 1;
            }
        }

        return time;
    }
}