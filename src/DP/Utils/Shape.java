package DP.Utils;


import com.sun.istack.internal.NotNull;

public class Shape
{

  public int row = 0;
  public int col = 0;
  public int dim = 0;

  public Shape()
  {
    // Halim Yaman...
    row = 0;
    col = 0;
    dim = 0;
  }

  public Shape(@NotNull double[] arr)
  {
    setShape(arr);
  }

  public Shape(@NotNull double[][] arr)
  {
    setShape(arr);
  }

  public Shape(double[][][] arr)
  {
    setShape(arr);
  }

  public void setShape(@NotNull double[] arr)
  {
    col = arr.length;
    row = 1;
    dim = 0;
  }

  public void setShape(@NotNull double[][] arr)
  {
    row = arr.length;
    col = arr[0].length;
    dim = 0;
  }

  public void setShape(double[][][] arr)
  {
    row = arr.length;
    col = arr[0].length;
    dim = arr[0][0].length;
  }

  public int[] getShape()
  {
    return new int[]{row, col, dim};
  }

  public boolean isModeOne(Shape other)
  {
    return (this.row == 1 && this.col == other.col);
  }

  public boolean isModeTwo(Shape other)
  {
    return (this.col == 1 && this.row == other.row);
  }

  public boolean isModeThree(Shape other)
  {
    return (this.col == other.col && other.row == 1);
  }

  public boolean isModeFour(Shape other)
  {
    return (this.row == other.row && other.col == 1);
  }

  public static int getMode(@NotNull Shape shar1, @NotNull Shape shar2)
  {
    // TODO can done with Enums

    if (shar1.equals(shar2))
    {
      // mode 0;
      // AxB == AxB
      return 0;
    } else if (shar1.isModeOne(shar2))
    {
      // mode 1
      // 1xB and ZxB
      return 1;
    } else if (shar1.isModeTwo(shar2))
    {
      // mode 2
      // Ax1 and AxY
      return 2;
    } else if (shar1.isModeThree(shar2))
    {
      // mode 3
      // ZxB and 1xB
      return 3;
    } else if (shar1.isModeFour(shar2))
    {
      // mode 4
      // AxZ and Ax1
      return 4;
    } else
    {
      return -1;
    }
  }

  @Override
  public boolean equals(Object other)
  {
    Shape shape;
    try
    {
      shape = (Shape) other;
    }
    catch (Exception ex)
    {
      return false;
    }
    return (shape.row == this.row && shape.col == this.col && shape.dim == this.dim);
  }
}