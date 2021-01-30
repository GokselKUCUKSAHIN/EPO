package DP.Utils;

import DP.Exceptions.NonPositiveSizeException;
import DP.Exceptions.SizeMismatchException;

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

  public static int[] fillInt(int p1, int value)
  {
    if (p1 > 0)
    {
      int[] array = new int[p1];
      Arrays.fill(array, value);
      return array;
    }
    return new int[0];
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
        sb.append(String.format("%6.5f  ", doubles[j]));
      }
      sb.append("\n");
    }
    return sb.toString();
  }

  public static String print3DArray(double[][][] arr)
  {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    for (double[][] arr2d : arr)
    {
      sb.append(String.format("\nDimension %d\n~~~~~~~~~~~~~\n", i++));
      sb.append(print2DArray(arr2d));
    }
    return sb.toString();
  }

  public static double[][] getGrid(double step, double[] lb, double[] ub)
  {
    // Check Step
    if(step <= 0)
    {
      throw new NonPositiveSizeException("`step` shoud be greater than 0");
    }
    // Check Bound sizes
    if(lb.length != lb.length)
    {
      throw new SizeMismatchException("`lowerBound` and `upperBound` arrays should be same size");
    }
    // Validate Bounds
    if(!checkBounds(lb, ub))
    {
      return new double[0][0];
    }
    // Create table
    int[] table = fillInt(lb.length, 0);

    // TODO IMPLEMENT HERE
    return new double[0][0];
  }

  private static boolean checkBounds(double[] lowerBound, double[] upperBound)
  {
    if(lowerBound.length == upperBound.length)
    {
      for (int i = 0; i < lowerBound.length; i++)
      {
        double lowerValue = lowerBound[i];
        double upperValue = upperBound[i];
        if(lowerBound == upperBound || Math.max(lowerValue, upperValue) == lowerValue)
        {
          return false;
        }
      }
      return true;
    }
    else
    {
      return false;
    }
  }
}