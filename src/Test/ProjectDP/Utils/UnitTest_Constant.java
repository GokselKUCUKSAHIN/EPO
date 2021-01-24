package Test.ProjectDP.Utils;

import ProjectDP.Utils.Constants;

public class UnitTest_Constant
{
  public UnitTest_Constant()
  {
    assert Constants.EPSILON == 1e-32;
    assert Constants.FLOAT_MAX == Double.MAX_VALUE;
    assert Constants.LIGHT_SPEED == 3e5;
    assert Constants.TEST_EPSILON == 100;
    assert Constants.TOURNAMENT_SIZE == 2;
  }
}
