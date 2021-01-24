package ProjectDP.Core;

import ProjectDP.Exceptions.AttributeNotFoundException;

import java.util.HashMap;

public abstract class Optimizer
{

  private String name;
  private final HashMap<String, Double> hyperparams; // Custom Attribute Holder
  private boolean built = false;

  public Optimizer()
  {
    // For Inheritance
    this("Not Specified");
  }

  public Optimizer(String name)
  {
    this.setName(name);
    this.hyperparams = new HashMap<>();
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return this.toString();
  }

  /*
  We don't need to Return Whole Hyperparameters i guess
  public HashMap<String, Double> getHyperparams()
  {
    return this.hyperparams;
  }
  */
  public void setHyperparams(Attribute... attribute)
  {
    // for every argument
    for (Attribute attr : attribute)
    {
      if (!attr.name.equals("") && !Double.isNaN(attr.value))
      {
        // Check name empty and value is Not a Number
        // if safe to add
        this.hyperparams.put(attr.name, attr.value);
      }
    }
  }

  public double getAttr(String name) throws AttributeNotFoundException
  {
    // Check key into HashMap if not
    //Object hold = this.hyperparams.get(name);
    //return (hold == null ? 0.0 / 0.0 : (double) hold);
    if (hyperparams.containsKey(name))
    {
      return hyperparams.get(name);
    } else
    {
      throw new AttributeNotFoundException(String.format("'%s' attribute not exist in %s", name, this.toString()));
    }
  }

  public void setBuilt(boolean built)
  {
    this.built = built;
  }

  public boolean isBuilt()
  {
    return built;
  }

  public void build(Attribute... attributes)
  {
    if (attributes.length > 0)
    {
      // if there is any attributes
      setHyperparams(attributes);
      // add them is Hyper Parameters
    }
    setBuilt(true);
    System.out.printf("Algorithm: %s | Hyperparameters: %s | \nBuilt: %s.\n",
        getName(), getAttributePairs(hyperparams), isBuilt());
  }

  private static String getAttributePairs(HashMap<String, Double> hyper)
  {
    // Takes HashMap and Returns like
    // { 'key1': value1, 'key2': value2, 'key3': value3, ..., 'keyN': valueN }
    // this

    if (hyper.isEmpty())
    {
      return "{ }";
    }
    else
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

  @Override
  public String toString()
  {
    return this.name;
  }

  // ABSTRACT REGION

  public abstract void update();
}