import ProjectDP.Core.Agent;
import ProjectDP.Core.Attribute;
import ProjectDP.Core.Optimizer;
import ProjectDP.Optimizers.EPO;
import ProjectDP.Exceptions.AttributeNotFoundException;
import Test.ProjectDP.Utils.UnitTest_Constant;

public class Main
{

  public static void main(String[] args) throws AttributeNotFoundException
  {
    Optimizer op = new EPO("Test Algorithm");
    System.out.println(op.getName() + " Tring to test :)");
    op.build(new Attribute("pi", 3.1415), new Attribute("number e", 2.718), new Attribute("Sin45", Math.sin(Math.PI / 4)));
    System.out.println("pi get test " + op.getAttr("pi"));
    System.out.println(op.getAttr("Sin45"));
    //
    UnitTest_Constant utc = new UnitTest_Constant();
    Agent ag = new Agent(5, 3);
    for (int i = 0; i < ag.getPositions().length; i++)
    {
      for (int j = 0; j < ag.getPositions()[0].length; j++)
      {
        System.out.printf("%.2f  ", ag.getPositions()[i][j]);
      }
      System.out.println();
    }
  }
}