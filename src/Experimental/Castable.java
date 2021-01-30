package Experimental;

public class Castable
{
  // Dictionary
  Class<?> type;
  public Castable(Class<?> type)
  {
    this.type = type;
  }
  public Class<?> getType()
  {
    return this.type;
  }

  @Override
  public String toString()
  {
    return type.getTypeName();
  }
}
