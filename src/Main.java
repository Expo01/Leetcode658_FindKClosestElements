import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}



class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int integer : arr) {
            if (k > 0) {
                minHeap.offer(integer);
                k--;
            } else if (Math.abs(minHeap.peek() - x) > Math.abs(integer - x)) {
                minHeap.poll();
                minHeap.offer(integer);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }
}

// listed as heap problem, but 2 pointer approach way better for speed and space
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int integer : arr) {
            if (k > 0) {
                minHeap.offer(integer);
                k--;
            } else if (Math.abs(minHeap.peek() - x) > Math.abs(integer - x)) {
                minHeap.poll();
                minHeap.offer(integer);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }
}

// my second attempt. not quite. time for answer...
//class Solution {
//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//
//        HashMap<Integer,Integer> map = new HashMap<>(); // all ints have val of abs distance from x
//        for(int i: arr){
//            map.put(i,Math.abs(i-x));
//        }
//
//        PriorityQueue<Integer> topK = new PriorityQueue<>((dist1, dist2) -> map.get(dist2)- map.get(dist1));
//        // PQ of abs distances in descending distance. must reverse later
//
//        for (int i : map.keySet()) {
//            topK.offer(i); // add all words
//            if (topK.size() > k) // knock off furthest distance from x
//                topK.poll();
//        }
//
//        List<Integer> res = new ArrayList<>();
//        while (!topK.isEmpty())
//            res.add(topK.poll());  // add all remaining strings
//        Collections.reverse(res); // reverse so most frequent at head
//        return res;
//    }
//}


//
//class Solution {
//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        int L = 0, R = arr.length;
//        int central_index = binarySearch(arr,L,R,x); // find axis. must acount for unequal halves... such as x at end or at beginning
//        // start with decrementing for first half where if arr[central_index-1] != 0 then add to return array. then for R half incrementing
//        // noticing a problem here through. for example....
//        // [1,2,3,100,101,102,103]. the array doesn't have to be sequenttial, just sorted. so if x = 100, and k = 2, this method would return
//        // [3,101] instead of [101,102]. priority queue is needed unless we want to get freaky and say while list.lenght != k then compare items
//        // L and R of axis and add the item close to x by absolte value but then would still need to sort the array and return as list.
//        // Lets try PQ instead...
//
//    }
//
//    private int binarySearch(int[] collection, int L, int R, int target){
//        int mid = 0;
//
//        while(L<=R){
//            mid = L + (R-L)/2;
//            if(collection[mid] == target){
//                return mid; // mid will be index of x so we can find k/2 to L and R
//            } else if (collection[mid] < target){
//                L = mid + 1;
//            } else {
//                R = mid -1;
//            }
//        }
//        return -1; // target never found
//    }
//
//}