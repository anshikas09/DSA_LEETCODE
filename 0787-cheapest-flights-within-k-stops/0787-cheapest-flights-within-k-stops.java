import java.util.*;

class Solution {

    static class Pair {
        int node;
        int price;
        int stops;

        Pair(int node, int price, int stops) {
            this.node = node;
            this.price = price;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        // Create graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {

            int u = flight[0];
            int v = flight[1];
            int price = flight[2];

            adj.get(u).add(new Pair(v, price, 0));
        }

        // dist[node] = cheapest price to reach node
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(src, 0, 0));

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            int node = curr.node;
            int price = curr.price;
            int stops = curr.stops;

            // Don't take more than k stops
            if (stops > k) {
                continue;
            }

            for (Pair next : adj.get(node)) {

                int nextNode = next.node;
                int nextPrice = next.price;

                int newPrice = price + nextPrice;

                if (newPrice < dist[nextNode] && stops <= k) {

                    dist[nextNode] = newPrice;

                    q.offer(
                        new Pair(
                            nextNode,
                            newPrice,
                            stops + 1
                        )
                    );
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}