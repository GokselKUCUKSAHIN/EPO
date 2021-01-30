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
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

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
    if (step <= 0)
    {
      throw new NonPositiveSizeException("`step` shoud be greater than 0");
    }
    // Check Bound sizes
    if (lb.length != lb.length)
    {
      throw new SizeMismatchException("`lowerBound` and `upperBound` arrays should be same size");
    }
    // Validate Bounds
    if (!checkBounds(lb, ub))
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

  // EXP

  public static double[][] exp(double[][] array)
  {
    if (array != null && array.length > 0)
    {
      int row = array.length;
      int col = array[0].length;
      double[][] result = new double[row][col];
      for (int i = 0; i < row; i++)
      {
        for (int j = 0; j < col; j++)
        {
          result[i][j] = Math.exp(array[i][j]);
        }
      }
      return result;
    }
    return new double[0][0];
  }

  // DIVIDE

  public static double[] div(double[] array, double number)
  {
    if (number == 0)
    {
      throw new ArithmeticException("Divided by Zero");
    } else
    {
      return mult(array, 1 / number);
    }
  }

  public static double[][] div(double[][] array, double number)
  {
    if (number == 0)
    {
      throw new ArithmeticException("Divided by Zero");
    } else
    {
      return mult(array, 1 / number);
    }
  }

  public static double[] div(double[] firstArray, double[] secondArray)
  {
    if (checkArraySize(firstArray, secondArray))
    {
      int lenFirst = firstArray.length;
      double[] result = new double[lenFirst];
      for (int i = 0; i < lenFirst; i++)
      {
        result[i] = firstArray[i] / secondArray[i];
      }
      return result;
    }
    return new double[0];
  }

  public static double[][] div(double[][] firstArray, double[][] secondArray)
  {
    if (checkArraySize(firstArray, secondArray))
    {
      int rowFirst = firstArray.length;
      int colFirst = firstArray[0].length;
      double[][] result = new double[rowFirst][colFirst];
      for (int i = 0; i < rowFirst; i++)
      {
        for (int j = 0; j < colFirst; j++)
        {
          result[i][j] = firstArray[i][j] / secondArray[i][j];
        }
      }
      return result;
    }
    return new double[0][0];
  }

  // MULTIPLY

  public static double[] mult(double[] array, double number)
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

  public static double[][] mult(double[][] array, double number)
  {
    if (array != null)
    {
      if (array.length > 0 && array[0].length > 0)
      {
        double[][] filledArray = fill(array.length, array[0].length, number);
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

  public static double[][] mult(double[][] array, double[] numberArr)
  {
    if (array != null && numberArr != null)
    {
      int arrRow = array.length;
      int arrCol = array[0].length;
      int numLen = numberArr.length;
      if (numLen == arrCol)
      {
        double[][] result = new double[arrRow][arrCol];
        for (int i = 0; i < arrRow; i++)
        {
          for (int j = 0; j < arrCol; j++)
          {
            result[i][j] = array[i][j] * numberArr[j];
          }
        }
        return result;
      } else
      {
        throw new SizeMismatchException("`array` and `numberArr` not compatible");
      }
    } else
    {
      throw new NullPointerException("`array` or `numerArr` is null");
    }
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

  public static double[][] mult(double[][] firstArray, double[][] secondArray)
  {
    if (checkArraySize(firstArray, secondArray))
    {
      int rowFirst = firstArray.length;
      int colFirst = firstArray[0].length;
      double[][] result = new double[rowFirst][colFirst];
      for (int i = 0; i < rowFirst; i++)
      {
        for (int j = 0; j < colFirst; j++)
        {
          result[i][j] = firstArray[i][j] * secondArray[i][j];
        }
      }
      return result;
    }
    return new double[0][0];
  }

  // SUM

  public static double[] sum(double[] array, double number)
  {
    if (array != null)
    {
      if (array.length > 0)
      {
        double[] filledArray = fill(array.length, number);
        return sum(array, filledArray);
      } else
      {
        throw new NonPositiveSizeException("`array` size should > 0");
      }
    } else
    {
      throw new NullPointerException("`array` is null");
    }
  }

  public static double[][] sum(double[][] array, double number)
  {
    if (array != null)
    {
      if (array.length > 0 && array[0].length > 0)
      {
        double[][] filledArray = fill(array.length, array[0].length, number);
        return sum(array, filledArray);
      } else
      {
        throw new NonPositiveSizeException("`array` size should > 0");
      }
    } else
    {
      throw new NullPointerException("`array` is null");
    }
  }

  public static double[] sum(double[] firstArray, double[] secondArray)
  {
    if (checkArraySize(firstArray, secondArray))
    {
      int lenFirst = firstArray.length;
      double[] result = new double[lenFirst];
      for (int i = 0; i < lenFirst; i++)
      {
        result[i] = firstArray[i] + secondArray[i];
      }
      return result;
    }
    return new double[0];
  }

  public static double[][] sum(double[][] firstArray, double[][] secondArray)
  {
    if (checkArraySize(firstArray, secondArray))
    {
      int rowFirst = firstArray.length;
      int colFirst = firstArray[0].length;
      double[][] result = new double[rowFirst][colFirst];
      for (int i = 0; i < rowFirst; i++)
      {
        for (int j = 0; j < colFirst; j++)
        {
          result[i][j] = firstArray[i][j] + secondArray[i][j];
        }
      }
      return result;
    }
    return new double[0][0];
  }

  // SUBTRACT

  public static double[] sub(double[] array, double number)
  {
    return sum(array, -1 * number);
  }

  public static double[][] sub(double[][] array, double number)
  {
    return sum(array, -1 * number);
  }

  public static double[] sub(double[] firstArray, double[] secondArray)
  {
    if (checkArraySize(firstArray, secondArray))
    {
      int lenFirst = firstArray.length;
      double[] result = new double[lenFirst];
      for (int i = 0; i < lenFirst; i++)
      {
        result[i] = firstArray[i] - secondArray[i];
      }
      return result;
    }
    return new double[0];
  }

  public static double[][] sub(double[][] firstArray, double[][] secondArray)
  {
    if (checkArraySize(firstArray, secondArray))
    {
      int rowFirst = firstArray.length;
      int colFirst = firstArray[0].length;
      double[][] result = new double[rowFirst][colFirst];
      for (int i = 0; i < rowFirst; i++)
      {
        for (int j = 0; j < colFirst; j++)
        {
          result[i][j] = firstArray[i][j] - secondArray[i][j];
        }
      }
      return result;
    }
    return new double[0][0];
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
      if (row < 1 || column < 1)
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
      if (row < 1 || column < 1 || dimension < 1)
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

  // CHECK ARRAY SIZE

  public static boolean checkArraySize(double[] firstArray, double[] secondArray)
  {
    if (firstArray != null && secondArray != null)
    {
      int lenFirst = firstArray.length;
      int lenSecond = secondArray.length;
      if (lenFirst > 1 && lenSecond > 1 && lenFirst == lenSecond)
      {
        return true;
      } else
      {
        throw new SizeMismatchException("`firstArray` and `secondArray` should be same lenght");
      }
    }
    throw new NullPointerException("`firstArray` or `secondArray` is null");
  }

  public static boolean checkArraySize(double[][] firstArray, double[][] secondArray)
  {
    if (firstArray != null && secondArray != null)
    {
      int rowFirst = firstArray.length;
      int colFirst = firstArray[0].length;
      int rowSecond = secondArray.length;
      int colSecond = secondArray[0].length;
      if (rowFirst > 1 && colFirst > 1 && rowSecond > 1 && colSecond > 1 && rowFirst == rowFirst && colFirst == colSecond)
      {
        return true;
      } else
      {
        throw new SizeMismatchException("`firstArray` and 'secondArray' should be same size");
      }
    }
    throw new NullPointerException("`firstArray` or `secondArray` is null");
  }
}