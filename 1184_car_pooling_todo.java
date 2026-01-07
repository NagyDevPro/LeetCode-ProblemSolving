import java.util.*;

public class Main {

    class Pair<K, V> {
        public final K first;
        public final V second;

        Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {

        Arrays.sort(trips, (arr1, arr2) -> {
            int byStart = Integer.compare(arr1[1], arr2[1]);
            if (byStart != 0) return byStart;
            return Integer.compare(arr1[2], arr2[2]);
        });

        Map<Integer,Integer> furPoint = new HashMap<>();
        int[] tripsCapacity = new int[trips.length+1];

        //initiate first trip
        tripsCapacity[0]=trips[0][0];
        furPoint.getOrDefault(trips[0][2],0);

        for(int i=1;i<trips.length;i++){
            tripsCapacity[i]+=(trips[i][0]+tripsCapacity[i-1]);

            // calculate the farther point for each trip
            if(!furPoint.containsKey(trips[i][2])) {
                furPoint.getOrDefault(trips[i][2], i);
            }
        }

        capacity-=trips[0][0];
        for(int i=1;i < trips.length;i++){
            if(trips[i][1]>=trips[i-1][2]){ // drop off all passengers
                if(furPoint.get(trips[i-1][2]) == 0) {
                    capacity += (tripsCapacity[i]);
                }else{
                    capacity+= (tripsCapacity[i]-tripsCapacity[furPoint.get(trips[i-1][2])-1]);
                }
            }

            capacity-=trips[i][0];

            if(capacity< 0){
                return false;
            }
        }



        return true;
    }
    public static void main(String[] args) {
        // why i got null pointer exception with this test case?
        System.out.println(new Main().carPooling(new int[][] { {2,1,5},{3,5,7} }, 3));

    }
}