package Test.DP.Utils;

import DP.Utils.JNum;

public class UmitTest_JNum
{
   public static void test_print_3d_array()
   {
     double [][][] my3d = JNum.ones(3,4,5);
     System.out.println(JNum.print3DArray(my3d));
   }
}