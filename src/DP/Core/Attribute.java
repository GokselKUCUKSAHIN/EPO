package DP.Core;

import java.util.HashMap;

public class Attribute
{

  public String name;
  public double value;

  public Attribute(String name, double value)
  {
    this.name = name;
    this.value = value;
  }

  public static String getPairs(HashMap<String, Double> hyper)
  {
    // Takes HashMap and Returns like
    // { 'key1': value1, 'key2': value2, 'key3': value3, ..., 'keyN': valueN }
    // this
    if (hyper.isEmpty())
    {
      return "{ }";
    } else
    {
      StringBuilder sb = new StringBuilder("{ ");
      hyper.forEach((key, value) -> {
        sb.append(String.format("'%s': %f, ", key, value));
      });
      if (sb.length() > 0)
      {
        sb.setLength(sb.length() - 2);
      }
      return sb.append(" }").toString();
    }
  }

}
