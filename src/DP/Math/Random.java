package DP.Math;

public class Random
{

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
    return Math.random() < 0.5 ? 0 : 1;
  }
}
