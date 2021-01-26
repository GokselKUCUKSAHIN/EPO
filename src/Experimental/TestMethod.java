package Experimental;

import DP.Core.Agent;
import DP.Core.StorableMethod;

public class TestMethod extends StorableMethod
{

  @Override
  public Object call(Object...parameters)
  {
    if(parameters.length == 2)
    {
      return decode(parameters[0]) + decode(parameters[1]);
    }
    else if(parameters.length == 3)
    {
      return ((Agent)parameters[0]).getN_Dimensions();
    }
    else if(parameters.length == 1)
    {
      return "hello world";
    }
    return null;
  }

  public int decode(Object param1)
  {
    return (int)param1;
  }
}
