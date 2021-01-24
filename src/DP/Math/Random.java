package DP.Math;

public class Random
{
  private static final java.util.Random RANDOM = new java.util.Random();
  public static double[] generateBinaryRandomNumber(int size)
  {
    if (size > 1)
    {
      double[] arr = new double[size];
      for (int i = 0; i < size; i++)
      {
        arr[i] = getRandomBinaryNumber();
      }
      return arr;
    } else
    {
      return new double[]{getRandomBinaryNumber()};
    }
  }

  public static double getRandomBinaryNumber()
  {
    return RANDOM.nextBoolean() ? 0 : 1;
  }
}
