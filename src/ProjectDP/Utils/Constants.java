package ProjectDP.Utils;

public class Constants
{

  // A constant value used to avoid division by zero, zero logarithms
  // and any possible mathematical error
  public static final double EPSILON = 1e-32;


  // When the agents are initialized, their fitness is defined as
  // the maximum float value possible
  public static final double FLOAT_MAX = Float.MAX_VALUE;

  // If necessary, one can apply custom rxules to keys' dumping
  // when using the History object
  // HISTORY_KEYS =['agents','best_agent','local']

  // When working with relativity theories, it it necessary
  // to define a constant for the speed of light
  public static final double LIGHT_SPEED = 3e5;

  // A test passes if the best solution found by the agent in the target function
  // is smaller than this value
  public static final double TEST_EPSILON = 100;

  // When using the Tournament Selection,one must provide the size of rounds,
  // where individuals will compete among themselves
  public static final double TOURNAMENT_SIZE = 2;
}
