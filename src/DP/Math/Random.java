package DP.Math;

public class Random
{

  private static final java.util.Random RANDOM = new java.util.Random();

  public static double[] generateUniformRandomNumbers(int nDimensions)
  {
    return generateUniformRandomNumbers(0, 1, nDimensions);
  }

  public static double[] generateUniformRandomNumbers(double lb, double ub, int nDimensions)
  {
    double[] ret = new double[]{RANDOM.nextDouble()};
    if (nDimensions > 0)
    {
      ret = new double[nDimensions];
      for (int i = 0; i < nDimensions; i++)
      {
        ret[i] = getUnifiedRandomNumber(lb, ub);
      }
    }
    return ret;
  }

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

  public static double getUnifiedRandomNumber()
  {
    return getUnifiedRandomNumber(0, 1);
  }

  public static double getUnifiedRandomNumber(double min, double max)
  {
    return RANDOM.nextDouble() * (max - min) + min;
  }
}