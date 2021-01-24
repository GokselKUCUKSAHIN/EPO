package Utils;

import java.util.Arrays;

public class JNum
{

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
    if(n_dimensions > 0 && n_variables > 0)
    {
      double[][] array = new double[n_variables][n_dimensions];
      Arrays.stream(array).forEach(arr -> Arrays.fill(arr, 0));
      return array;
    }
    return new double[0][0];
  }
}
