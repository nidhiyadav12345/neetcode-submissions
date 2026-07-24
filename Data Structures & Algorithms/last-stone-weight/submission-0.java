

class Solution {

    PriorityQueue<Integer> pq;

    public int lastStoneWeight(int[] stones) {

        pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }

        while (pq.size() > 1) {

            int x = pq.poll();
            int y = pq.poll();

            if (x != y) {
                pq.offer(x - y);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}