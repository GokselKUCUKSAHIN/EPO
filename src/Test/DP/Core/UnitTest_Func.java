package Test.DP.Core;

import DP.Core.Func;
import DP.Utils.JNum;

import java.util.function.Function;

public class UnitTest_Func
{

  private static void test_func_name()
  {
    Func newFunc = new Func();
    if (!newFunc.getName().equals("class DP.Core.Func")) throw new AssertionError();
  }

  private static void test_func_name_setter()
  {
    Func newFunc = new Func();
    newFunc.setName("myFunction123");
    if (!newFunc.getName().equals("myFunction123")) throw new AssertionError();
  }

  private static void test_func_constraints()
  {
    Func newFunc = new Func();
    if (newFunc.getConstraints().size() != 0) throw new AssertionError();
  }

  private static void test_func_constraints_setter()
  {
    Function<double[], Double> c_1 = (double[] arr) -> arr[0] * arr[0];
    try
    {
      if ((c_1.apply(new double[]{2}) != 5)) throw new AssertionError();
    }
    catch (AssertionError ae)
    {
      if ((c_1.apply(new double[]{2}) != 4)) throw new AssertionError();
    }

    Func newFunc = new Func();
    try
    {
      newFunc.pushConstraints(null);
    }
    catch (NullPointerException ex)
    {
      newFunc.pushConstraints(c_1);
    }
    if (newFunc.getConstraints().size() != 1) throw new AssertionError();
  }

  private static void test_func_penalty()
  {
    Func newFunc = new Func();
    if (newFunc.getPenalty() != 0.0) throw new AssertionError();
  }

  private static void test_func_penalty_setter()
  {
    Func newFunc = new Func();
    try
    {
      newFunc.setPenalty(-1);
    }
    catch (IllegalArgumentException iaex)
    {
      newFunc.setPenalty(1);
    }
    if (newFunc.getPenalty() != 1) throw new AssertionError();
  }

  private static void test_func_pointer()
  {
    Func newFunc = new Func();
    if (!newFunc.getPointerName().equals("constrain_pointer")) throw new AssertionError();
  }

  private static void test_func_pointer_setter()
  {
    Func newFunc = new Func();
    try
    {
      newFunc.setPointer(null);
    }
    catch (NullPointerException ex)
    {
      newFunc.setPointer(Func.CHECK);
    }
    if (!newFunc.getPointer().getClass().getName().equals("DP.Core.Func$$Lambda$1/189568618"))
      throw new AssertionError();
  }


  private static void test_func_built()
  {
    Func newFunc = new Func();
    if (!newFunc.isBuilt()) throw new AssertionError();
  }

  private static void test_func_built_setter()
  {
    Func newFunc = new Func();
    newFunc.setBuilt(false);
  }

  public static double square(double[] args)
  {
    double sum = 0;
    for (double num : args)
    {
      sum += num * num;
    }
    return sum;
  }

  private static void test_func_create_pointer()
  {
    Function<double[], Double> square = UnitTest_Func::square;
    if (square.apply(new double[]{2, 1}) != 5) throw new AssertionError();

    if (square.apply(new double[]{1, 2, 3}) != 14) throw new AssertionError();

    Function<double[], Double> square2 = (double[] arr) -> arr[0] * arr[0] + arr[1] * arr[1];
    if (square2.apply(new double[]{2, 2}) != 8) throw new AssertionError();

    Function<double[], Double> c_1 = (double[] arr) -> arr[0] + arr[1] <= 0 ? JNum.TRUE : JNum.FALSE;
    if (c_1.apply(JNum.zeros(2)) != JNum.TRUE) throw new AssertionError();

    Func newFunc = new Func(square, c_1, 100);

    if (newFunc.apply(JNum.ones(2)) != 202) throw new AssertionError();

    if (newFunc.apply(JNum.zeros(2)) != 0) throw new AssertionError();
  }

  public static void doTest()
  {
    test_func_name();
    test_func_name_setter();
    test_func_constraints();
    test_func_constraints_setter();
    test_func_penalty();
    test_func_penalty_setter();
    test_func_pointer();
    test_func_pointer_setter();
    test_func_built();
    test_func_built_setter();
    test_func_create_pointer();
  }
}