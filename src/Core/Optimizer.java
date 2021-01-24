package Core;

public class Optimizer
{
  private String name = "";
  private String hyperparams = null;
  private boolean built = false;
  
  public Optimizer(String name)
  {
    this.name = name;
  }



  @Override
  public String toString()
  {
    return this.name;
  }
}