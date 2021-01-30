package DP.Utils;

import java.util.Arrays;

public class JNum
{

  public static final double TRUE = Double.POSITIVE_INFINITY;
  public static final double FALSE = Double.NEGATIVE_INFINITY;


  // ZEROS
  public static double[] zeros(int n_variables)
  {
    return fill(n_variables, 0);
  }

  public static double[][] zeros(int n_variables, int n_dimensions)
  {
    return fill(n_variables, n_dimensions, 0);
  }

  public static double[][][] zeros(int n_variables, int n_dimensions, int n_size)
  {
    return fill(n_variables, n_dimensions, n_size, 0);
  }

  //ONES
  public static double[] ones(int n_variables)
  {
    return fill(n_variables, 1);
  }

  public static double[][] ones(int n_variables, int n_dimensions)
  {
    return fill(n_variables, n_dimensions, 1);
  }

  public static double[][][] ones(int n_variables, int n_dimensions, int n_size)
  {
    return fill(n_variables, n_dimensions, n_size, 1);
  }

  // 1 Dimension
  public static double[] fill(int p1, double value)
  {
    if (p1 > 0)
    {
      double[] array = new double[p1];
      Arrays.fill(array, value);
      return array;
    }
    return new double[0];
  }

  // 2 Dimension
  public static double[][] fill(int p1, int p2, double value)
  {
    if (p1 > 0 && p2 > 0)
    {
      double[][] array = new double[p1][p2];
      Arrays.stream(array).forEach(arr -> Arrays.fill(arr, value));
      return array;
    }
    return new double[0][0];
  }

  // 3 Dimension
  public static double[][][] fill(int p1, int p2, int p3, double value)
  {
    if (p1 > 0 && p2 > 0 && p3 > 0)
    {
      double[][][] array = new double[p1][p2][p3];
      for (double[][] row : array)
      {
        for (double[] rowColumn : row)
        {
          Arrays.fill(rowColumn, value);
        }
      }
      return array;
    }
    return new double[0][0][0];
  }

  public static String printArray(double[] arr)
  {
    return Arrays.toString(arr);
  }

  public static String print2DArray(double[][] arr)
  {
    StringBuilder sb = new StringBuilder();
    for (double[] doubles : arr)
    {
      for (int j = 0; j < arr[0].length; j++)
      {
        sb.append(String.format("%6.1f  ", doubles[j]));
      }
      sb.append("\n");
    }
    return sb.toString();
  }
}
