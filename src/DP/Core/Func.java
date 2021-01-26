package DP.Core;

import DP.Exceptions.SizeMismatchException;
import DP.Utils.JNum;

import java.util.ArrayList;
import java.util.function.Function;

public class Func
{

  private String name = "";
  private double penalty;
  private boolean built;
  private Function<double[], Double> pointer;
  private Function<double[], Double> prevPointer;
  private String pointerName;
  private ArrayList<Function<double[], Double>> constraints;
  //
  public static final Function<double[], Double> CHECK = Func::placeHolderFunction; //check function;
  public static final String checkPName = CHECK.getClass().getName(); // test string

  public Func()
  {
    this(Func::placeHolderFunction, null, 0);
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
    setPenalty(penalty);
    setPointer(pointer);
    prevPointer = pointer;
    createPointer(pointer);
    setBuilt(true);
  }

  public double apply(double[] array)
  {
    return this.pointer.apply(array);
  }

  private static double placeHolderFunction(double[] arr)
  {
    return 0;
  }

  public Function<double[], Double> getPointer()
  {
    return pointer;
  }

  public void setPointer(Function<double[], Double> pointer)
  {
    if (pointer != null)
    {
      this.prevPointer = this.pointer;
      this.pointer = pointer;
      setPointerName(pointer);
    } else
    {
      throw new NullPointerException("`Pointer` is null");
    }
  }

  public void setPointerName(String pointerName)
  {
    if (pointerName == null || pointerName.equals("") || pointerName.length() < 3)
    {
      throw new SizeMismatchException("`pointerName` need to more than 3 char and not empty nor null");
    } else
    {
      this.pointerName = pointerName;
    }
  }

  public String getPointerName()
  {
    return this.pointerName;
  }


  private static String setPointerName(Function<double[], Double> pointer)
  {
    String pName = pointer.getClass().getName();
    if (pName.equals(Func.checkPName))
    {
      pName = "callable";
    }
    return pName;
  }

  public ArrayList<Function<double[], Double>> getConstraints()
  {
    return this.constraints;
  }

  public void setConstraints(ArrayList<Function<double[], Double>> constraints)
  {
    this.constraints = constraints;
  }

  public void pushConstraints(Function<double[], Double> constraint)
  {
    if (constraint != null)
    {
      this.getConstraints().add(constraint);
    } else
    {
      throw new NullPointerException("`constraint` function is null");
    }
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
    setPointer(this::constrain_pointer);
    setPointerName("constrain_pointer");
//    if (pointer != null)
//    {
//
//    } else
//    {
//      throw new NullPointerException("`Pointer` is null");
//    }
  }
  static int i = 1;
  private double constrain_pointer(double[] array)
  {
    System.out.println(i++);
    double fitness = this.prevPointer.apply(array);
    for (Function<double[], Double> constraint : constraints)
    {
      if (constraint.apply(array) == JNum.DOUBLE_TRUE) // TODO idk! Check here later
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