package DP.Core;

import java.util.HashMap;

public class Function
{

  private String name = "";
  private double penalty;
  private boolean built;
  private StorableMethod pointer;
  private HashMap<String, ? extends StorableMethod> constraints;

  public Function()
  {
    this(null, null, 0);
  }

  public Function(StorableMethod pointer, HashMap<String, ? extends StorableMethod> constraints, double penalty)
  {

    if (name.equals(""))
    {
      setName(this.getClass().toString());
    }
    if (constraints == null)
    {
      this.constraints = new HashMap<>();
    } else
    {
      this.constraints = constraints;
    }
    setBuilt(true);
    setPointer(pointer);
  }

  public StorableMethod getPointer()
  {
    return pointer;
  }

  public void setPointer(StorableMethod pointer)
  {
    this.pointer = pointer;
  }

  public HashMap<String, ? extends StorableMethod> getConstraints()
  {
    return this.constraints;
  }

  public void setConstraints(HashMap<String, ? extends StorableMethod> constraints)
  {
    this.constraints = constraints;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    if (name == null)
    {
      this.name = "";
    }
    this.name = name;
  }

  public double getPenalty()
  {
    return penalty;
  }

  public void setPenalty(double penalty)
  {
    if (penalty >= 0)
    {
      this.penalty = penalty;
    } else
    {
      throw new IllegalArgumentException("`penalty` should be >= 0");
    }
  }

  public boolean isBuilt()
  {
    return built;
  }

  public void setBuilt(boolean built)
  {
    this.built = built;
  }


  public static double fitnessHolder = 0;

  private void createPointer(double[] arr)
  {
    double fitness = (double) this.pointer.call(arr);
    fitnessHolder = fitness;
    //this.pointer = new ConstrainPointer(fitness);
    pointer = new StorableMethod()
    {
      @Override
      public Object call(Object... parameters)
      {
        return null;
      }
    };
  }
}