package Utils;

import java.util.Arrays;

public class JNum
{

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



/*
  public static double[] zeros(int n_variables)
  {
    if (n_variables > 0)
    {
      double[] array = new double[n_variables];
      Arrays.fill(array, 0.0);
      return array;
    }
    return new double[0];
  }

  public static double[][] zeros(int n_variables, int n_dimensions)
  {
    if (n_dimensions > 0 && n_variables > 0)
    {
      double[][] array = new double[n_variables][n_dimensions];
      Arrays.stream(array).forEach(arr -> Arrays.fill(arr, 0));
      return array;
    }
    return new double[0][0];
  }*/


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
}
