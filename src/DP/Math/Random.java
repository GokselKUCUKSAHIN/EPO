package DP.Math;

public class Random
{

  private static final java.util.Random RANDOM = new java.util.Random();

  public static double[] generateUniformRandomNumbers(int nDimensions)
  {
    return generateUniformRandomNumbers(0, 1, nDimensions);
  }

  public static double[][] generateUniformRandomNumbers(int row, int col)
  {
    return generateUniformRandomNumbers(0, 1, row, col);
  }

  public static double[][] generateUniformRandomNumbers(double lb, double ub, int row, int col)
  {
    if (row > 0 && col > 0)
    {
      double[][] ret = new double[row][col];
      for (int i = 0; i < row; i++)
      {
        for (int j = 0; j < col; j++)
        {
          ret[i][j] = getUnifiedRandomNumber(lb, ub);
        }
      }
      return ret;
    } else
    {
      return new double[][]{{RANDOM.nextDouble()}, {RANDOM.nextDouble()}};
    }
  }

  public static double[] generateUniformRandomNumbers(double lb, double ub, int nDimensions)
  {
    double[] ret = new double[]{RANDOM.nextDouble()};
    if (nDimensions > 1)
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