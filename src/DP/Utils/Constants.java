package DP.Utils;

import DP.Exceptions.NonPositiveSizeException;
import DP.Exceptions.SizeMismatchException;
import com.sun.istack.internal.NotNull;

public class Constants
{

  // A constant value used to avoid division by zero, zero logarithms
  // and any possible mathematical error
  public static final double EPSILON = 1e-14;

  // When the agents are initialized, their fitness is defined as
  // the maximum double value possible
  public static final double DOUBLE_MAX = Double.MAX_VALUE;

  // When working with relativity theories, it it necessary
  // to define a constant for the speed of light
  public static final double LIGHT_SPEED = 3e5;
  //

}
