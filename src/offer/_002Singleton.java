package offer;

public class _002Singleton {
   private static class MyObjectHelper{
       private static _002Singleton instance = new _002Singleton();
   }
   private _002Singleton(){};

   public static _002Singleton getInstance(){
       return MyObjectHelper.instance;
   }
}
