package Experimental;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class FunctionsTest
{

  public static void main(String[] args)
  {
    ArrayList<Function<Double, Double>> functions = new ArrayList<>();
    functions.add(FunctionsTest::sqr);


    System.out.println(functions.get(0).apply(5.0));

  }

  public static void FunctionalInterfaceOp1()
  {
    Function<Integer, String> func = (Integer e) -> e + "";
    Function<String, Integer> getLen = (String s) -> s.length();

    String s = func.apply(666);
    int len = getLen.apply(s);
    System.out.println(len);
  }

  public static void FunctionalInterfaceOp2()
  {
    Function<Double[], Double> multArray = (Double[] s) -> {
      double sum = 1;
      for (Double item : s)
      {
        sum *= item;
      }
      return sum;
    };
    double d1 = 3.14d;
    double d2 = 2.718d;
    double d3 = 123.432;
    double d4 = 0.123;
    System.out.println(multArray.apply(new Double[]{d1, d2, d3, d4}));
  }

  public static void lambdaExpressionTest()
  {
    double[] myArray = new double[]{1, 2, 3, 4, 5};
    Function<Double[], Boolean> checkArray = (Double[] arr) -> (arr[0] + arr[1]) < 10;
    System.out.println(checkArray.apply(Arrays.stream(myArray).boxed().toArray(Double[]::new)));
  }

  public static void doubleColonOp()
  {
    double[] myArray = new double[]{1, 2, 3, 4, 5};
    Function<double[], Boolean> chkArr = FunctionsTest::checkArraySimple;
    System.out.println(chkArr.apply(myArray));
  }

  public static boolean checkArraySimple(double[] arr)
  {
    return arr.length >= 2 && arr[0] + arr[1] < 10;
  }

  public static double sqr(double in)
  {
    return in * in;
  }
}
