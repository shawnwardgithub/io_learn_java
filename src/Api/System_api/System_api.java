package Api.System_api;

import java.util.Arrays;

/**
 * Created by lijiahe on 2017/10/20.
 */
public class System_api {


    /**
     * System---arraycopy
     * public static native void arraycopy(Object src,  int  srcPos,Object dest, int destPos,int length);
     *
    */
      public static void  arraycopytest(){
          int[] src ={1,2,3,4,5};
          int[] dest =new int[5];
          System.arraycopy(src,0,dest,0,5);
          System.out.println(Arrays.toString(dest));
      }
      /**
       * Returns the same hash code for the given object as
       * would be returned by the default method hashCode(),
       * whether or not the given object's class overrides hashCode().
       * * The hash code for the null reference is zero.
        */
      public  static void identityHashCode_test(){
          System.out.print(System.identityHashCode(123));
      }



    public static void main(String[] args) {
        identityHashCode_test();
    }
}
