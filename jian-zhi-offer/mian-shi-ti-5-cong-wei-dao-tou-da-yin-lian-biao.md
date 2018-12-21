题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。

* 使用stack

  ```java
  public void print(ListNode p){
          if(p == null){
              return;
          }

          Stack<Integer> stack = new Stack<>();
          while (p != null){
              stack.push(p.value);
              p = p.next;
          }
          while (!stack.isEmpty()){
              System.out.println(stack.pop());
          }
          return;
      }
  ```

* 递归

  ```java
   public void printRecursion(ListNode p){
          if(p == null){
              return;
          }
          printRecursion(p.next);
          System.out.println(p.value);
      }
  ```



