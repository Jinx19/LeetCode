1. 暴力
   ```java
   class KthLargest {
       private PriorityQueue<Integer> queue;
       private int k;
       //时间复杂度 
       //nums.length*log(n)
       public KthLargest(int k, int[] nums) {
           this.k = k;
           this.queue = new PriorityQueue<>(new Comparator<Integer>() {
               @Override
               public int compare(Integer o1, Integer o2) {
                   return o2 - o1;
               }
           });
           for(int i = 0 ; i < nums.length; i++){
               queue.offer(nums[i]);
           }
       }
    
       //klog(n)
       public int add(int val) {
           queue.offer(val);
           ArrayList<Integer> arrayList = new ArrayList<>();
           for(int i = 0; i < k; i++){
               arrayList.add(queue.poll());
           }

           for(int i = 0 ; i < k; i++){
               queue.offer(arrayList.get(i));
           }

           return arrayList.get(k - 1);
       }
   }

   /**
    * Your KthLargest object will be instantiated and called as such:
    * KthLargest obj = new KthLargest(k, nums);
    * int param_1 = obj.add(val);
    */
 
   ```
2. k容量的priorityQueue
   ```java
   class KthLargest {
       private PriorityQueue queue;
       private int k;
    
       public KthLargest(int k, int[] nums) {
           this.k = k;
           queue = new PriorityQueue<>(k);
           for(int i = 0 ; i < nums.length; i++){
               add(nums[i]);
           }
       }
    
       //log(n)
       public int add(int val) {
           if(queue.size() < k){
               queue.offer(val);
           }else if(val > (Integer)queue.peek()){
               queue.poll();
               queue.offer(val);
           }

           return (Integer)queue.peek();
       }
   }

   /**
    * Your KthLargest object will be instantiated and called as such:
    * KthLargest obj = new KthLargest(k, nums);
    * int param_1 = obj.add(val);
    */
   ```



