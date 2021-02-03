package DP.Optimizers;

import DP.Math.Random;
import DP.Utils.JNum;

public class EPO_MAT
{

  public static double fun(double[][] feat, String label)
  {
    return 0;
  }
  public static void emperorPenguinOptimizer(double[][] feat, String label, int N, int T, int M, double thres, double f, double l)
  {
    int dim = feat[0].length; // Column Count;
    double[][] X = Random.generateUniformRandomNumbers(N, dim);
    double[] fit = JNum.zeros(N);
    double fitG = Double.POSITIVE_INFINITY;

    double curve = Double.POSITIVE_INFINITY;

    for (int t = 0; t < T; t++)
    {
      for (int i = 0; i < N; i++)
      {
        fit[i] = 0;
      }
    }
  }
}
