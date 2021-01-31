

/*
MIT License

Copyright (c) 2021 Göksel Küçükşahin

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
/*
package DP.Utils;

import DP.Exceptions.NonPositiveSizeException;
import DP.Exceptions.SizeMismatchException;
import com.sun.istack.internal.NotNull;

import java.util.Arrays;

public class XNum
{

  public static final double TRUE = Double.POSITIVE_INFINITY;
  public static final double FALSE = Double.NEGATIVE_INFINITY;


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
        sb.append(String.format("%6.8f  ", doubles[j]));
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

  private static boolean checkBounds(double[] lowerBound, double[] upperBound)
  {
    if (lowerBound.length == upperBound.length)
    {
      for (int i = 0; i < lowerBound.length; i++)
      {
        double lowerValue = lowerBound[i];
        double upperValue = upperBound[i];
        if (lowerBound == upperBound || Math.max(lowerValue, upperValue) == lowerValue)
        {
          return false;
        }
      }
      return true;
    } else
    {
      return false;
    }
  }

  public static double[][] converToRowMatrix(@NotNull double[] array)
  {
    if (array.length > 0)
    {
      double[][] result = new double[1][array.length];
      for (int i = 0; i < array.length; i++)
      {
        result[0][i] = array[i];
      }
      return result;
    } else
    {
      throw new NonPositiveSizeException("`array` should have minimum 1 item");
    }
  }

  public static double[][] mult(@NotNull double[][] firstArray, @NotNull double[][] secondArray)
  {
    Shape shAr1 = new Shape(firstArray);
    Shape shAr2 = new Shape(secondArray);
    int mode = Shape.getMode(shAr1, shAr2);
    if (mode == -1)
    {
      // Size doesn't match throw exception
      throw new SizeMismatchException("`firstArray` and 'secondArray' should be same size");
    } else
    {
      // Null safe object
      double[][] result = new double[0][0];
      switch (mode)
      {
        case 0:
        {
          // AxB == AxB
          result = new double[shAr1.row][shAr1.col];
          for (int i = 0; i < shAr1.row; i++)
          {
            for (int j = 0; j < shAr1.col; j++)
            {
              result[i][j] = firstArray[i][j] * secondArray[i][j];
            }
          }
          break;
        }
        case 1:
        {
          // 1xB and ZxB
          result = new double[shAr2.row][shAr2.col];
          for (int i = 0; i < shAr2.row; i++)
          {
            for (int j = 0; j < shAr1.col; j++)
            {
              result[i][j] = firstArray[0][j] * secondArray[i][j];
            }
          }
          break;
        }
        case 2:
        {
          // Ax1 and AxZ
          result = new double[shAr2.row][shAr2.col];
          for (int i = 0; i < shAr2.row; i++)
          {
            for (int j = 0; j < shAr1.row; j++)
            {
              result[i][j] = firstArray[i][0] * secondArray[i][j];
            }
          }
          break;
        }
        case 3:
        case 4:
        case 5:
        {
          // if mode 3 swap arrays and turn into mode 1
          // if mode 4 swap arrays and turn into mode 2
          return mult(secondArray, firstArray);
        }
        case 6:
        {
          result = new double[shAr1.row][shAr2.col];
          for (int i = 0; i < shAr1.row; i++)
          {
            for (int j = 0; j < shAr2.col; j++)
            {
              result[i][j] = firstArray[i][0] * secondArray[0][j];
            }
          }
          break;
        }
        default:
          break;
      }
      return result;
    }
  }

  public static double[][] mult(@NotNull double[][] array, double number)
  {
    if (array.length > 0 && array[0].length > 0)
    {
      double[][] filledArray = fill(array.length, array[0].length, number);
      return mult(array, filledArray);
    } else
    {
      throw new NonPositiveSizeException("`array` size should > 0");
    }
  }

  public static double[][] mult(double number, double[][] array)
  {
    return mult(array, number);
  }

  public static double[][] mult(double[][] firstArray, double[] secondArray)
  {
    return mult(firstArray, converToRowMatrix(secondArray));
  }

  public static double[][] mult(double[] firstArray, double[][] secondArray)
  {
    return mult(secondArray, firstArray);
  }

  public static double[] mult(double[] firstArray, double[] secondArray)
  {
    if (checkArraySize(firstArray, secondArray))
    {
      int lenFirst = firstArray.length;
      double[] result = new double[lenFirst];
      for (int i = 0; i < lenFirst; i++)
      {
        result[i] = firstArray[i] * secondArray[i];
      }
      return result;
    }
    return new double[0];
  }

  public static double[] mult(@NotNull double[] array, double number)
  {
    if (array != null)
    {
      if (array.length > 0)
      {
        double[] filledArray = fill(array.length, number);
        return mult(array, filledArray);
      } else
      {
        throw new NonPositiveSizeException("`array` size should > 0");
      }
    } else
    {
      throw new NullPointerException("`array` is null");
    }
  }

  public static double[] mult(double number, @NotNull double[] array)
  {
    return mult(array, number);
  }

  // CHECK

  public static boolean checkArraySize(double[] firstArray, double[] secondArray)
  {
    if (firstArray != null && secondArray != null)
    {
      int lenFirst = firstArray.length;
      int lenSecond = secondArray.length;
      if (lenFirst == lenSecond)
      {
        return true;
      } else
      {
        throw new SizeMismatchException("`firstArray` and `secondArray` should be same length");
      }
    }
    throw new NullPointerException("`firstArray` or `secondArray` is null");
  }

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

  // 1 Dimension int
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

  // ABSOLUTE

  public static double[] fabs(double[] arr)
  {
    if (arr != null)
    {
      if (arr.length < 1)
      {
        return new double[0];
      } else
      {
        double[] absArr = new double[arr.length];
        for (int i = 0; i < absArr.length; i++)
        {
          absArr[i] = Math.abs(arr[i]);
        }
        return absArr;
      }
    }
    throw new NullPointerException("`Array` is null");
  }

  public static double[][] fabs(double[][] arr)
  {
    if (arr != null)
    {
      int row = arr.length;
      int column = arr[0].length;
      if (column < 1 || row > 100)
      {
        return new double[0][0];
      } else
      {
        double[][] absArr = new double[row][column];
        for (int i = 0; i < row; i++)
        {
          for (int j = 0; j < column; j++)
          {
            absArr[i][j] = Math.abs(arr[i][j]);
          }
        }
        return absArr;
      }
    }
    throw new NullPointerException("`Array` is null");
  }

  public static double[][][] fabs(double[][][] arr)
  {
    if (arr != null)
    {
      int row = arr.length;
      int column = arr[0].length;
      int dimension = arr[0][0].length;
      if (dimension < 1)
      {
        return new double[0][0][0];
      } else
      {
        double[][][] absArr = new double[row][column][dimension];
        for (int i = 0; i < row; i++)
        {
          for (int j = 0; j < column; j++)
          {
            for (int k = 0; k < dimension; k++)
            {
              absArr[i][j][k] = Math.abs(arr[i][j][k]);
            }
          }
        }
        return absArr;
      }
    }
    throw new NullPointerException("`Array` is null");
  }

  // isEquals

  public static boolean isEquals(double[] arrFirst, double[] arrSecond)
  {
    if (arrFirst != null && arrSecond != null && arrFirst.length == arrSecond.length)
    {
      for (int i = 0; i < arrFirst.length; i++)
      {
        if (!compareDouble(arrFirst[i], arrSecond[i]))
        {
          return false;
        }
      }
      return true;
    } else
    {
      return false;
    }
  }

  public static boolean isEquals(double[][] arrFirst, double[][] arrSecond)
  {
    try
    {
      Shape shar1 = new Shape(arrFirst);
      Shape shar2 = new Shape(arrSecond);
      if (Shape.getMode(shar1, shar2) == 0)
      {
        for (int i = 0; i < shar1.row; i++)
        {
          if (!isEquals(arrFirst[i], arrSecond[i]))
          {
            return false;
          }
        }
        return true;
      }
    }
    catch (Exception ex)
    {
      return false;
    }
    return false;
  }

  public static boolean compareDouble(double d1, double d2)
  {
    double diff = Math.abs(d1 - d2);
    if (!Double.isNaN(diff))
    {
      return diff < Constants.EPSILON;
    } else
    {
      return Double.compare(d1, d2) == 0;
    }
  }
}
*/