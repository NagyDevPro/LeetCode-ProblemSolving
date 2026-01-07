class Solution {
    class Pair<K, V> {
        public final K first;
        public final V second;

        Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        
        PriorityQueue<Pair<Integer,Integer>> tripCapacity = new PriorityQueue<>(Comparator.comparingInt(p -> p.second));
        int farDropOff=0;// Java
        Arrays.sort(trips, (arr1, arr2) -> {
            int byStart = Integer.compare(arr1[1], arr2[1]);
            if (byStart != 0) return byStart;
            return Integer.compare(arr1[2], arr2[2]);
        });
        for (int i=0;i<trips.length;i++){

            // take more passengers or not in the next trip
            if(!tripCapacity.isEmpty() &&trips[i][1] >= tripCapacity.peek().second){
                //drop off all passengers
                while(!tripCapacity.isEmpty() && tripCapacity.peek().second <= trips[i][1]){
                    capacity+=tripCapacity.peek().first;
                    tripCapacity.poll();
                }
            }

            // initially take up the passengers
            capacity -= trips[i][0];

            if(capacity < 0){
                return false;
            }
            tripCapacity.add(new Pair<>(trips[i][0],trips[i][2]));
        }

        if(capacity<0){
            return false;
        }

        return true;
    }
    
    }