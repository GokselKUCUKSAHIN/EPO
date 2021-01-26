package DP.Core;

import java.util.ArrayList;
import java.util.function.Function;

public class Func
{

  private String name = "";
  private double penalty;
  private boolean built;
  private Function<double[], Double> pointer;
  //private HashMap<String, Function<double[], Double>> constraints;
  ArrayList<Function<double[], Double>> constraints;

  public Func()
  {
    this(null, null, 0);
  }

  public Func(Function<double[], Double> pointer, ArrayList<Function<double[], Double>> constraints, double penalty)
  {
    setName(this.getClass().toString());
    if (constraints == null)
    {
      this.constraints = new ArrayList<>();
    } else
    {
      this.constraints = constraints;
    }
    setBuilt(true);
    setPointer(pointer);
  }

  public Function<double[], Double> getPointer()
  {
    return pointer;
  }

  public void setPointer(Function<double[], Double> pointer)
  {
    this.pointer = pointer;
  }

  public ArrayList<Function<double[], Double>> getConstraints()
  {
    return this.constraints;
  }

  public void setConstraints(ArrayList<Function<double[], Double>> constraints)
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


  private void createPointer(Function<double[], Double> pointer)
  {
    if(pointer != null)
    {
      setPointer(this::constrain_pointer);
    }
    else
    {
      throw new NullPointerException("`Pointer` is null");
    }
  }

  private double constrain_pointer(double[] array)
  {
     double fitness = this.pointer.apply(array);
     for (Function<double[], Double> constraint : constraints)
     {
       if(constraint.apply(array) != 0) // TODO idk! Check here later
       {
          continue; // TODO Fix later
       }
       else
       {
         fitness += this.penalty * fitness;
       }
     }
     return fitness;
  }
}