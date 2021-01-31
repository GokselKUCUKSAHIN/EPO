package DP.Optimizers;

import DP.Core.*;
import DP.Math.Random;
import DP.Utils.JNum;

import java.util.ArrayList;
import java.util.HashMap;

public class EPO extends Optimizer
{

  public EPO()
  {
    this("Not Specified");
  }

  public EPO(String name)
  {
    this(name, null);
  }

  public EPO(String name, Attribute... hyperparams)
  {
    super(name);
    if (hyperparams != null)
    {
      setHyperparams(hyperparams);
    }
    setAttr("f", 2);
    setAttr("l", 1.5);
    build(hyperparams);
  }

  public double getL()
  {
    return getAttr("l");
  }

  public void setL(double l)
  {
    setAttr("l", l);
  }

  public double getF()
  {
    return getAttr("f");
  }

  public void setF(double f)
  {
    setAttr("f", f);
  }

  @Override
  public void update(ArrayList<Agent> agents, Agent bestAgent, int iteration, int nIteration)
  {
    /*
    Method that wraps the Emperor Penguin Optimization over all agents and variables.
        Args:
            agents (ArrayList): List of agents.
            bestAgent (Agent): Global best agent.
            iteration (int): Current iteration.
            nIterations (int): Maximum number of iterations.
    */

    // Iterates through every agent
    for (Agent agent : agents)
    {
      // Generates a radius constant
      final double R = Random.getUnifiedRandomNumber();

      // Checks if radius is bigger or equal to 0.5
      final double T = R >= 0.5 ? 0 : 1;

      // Calculates the temperature profile (Eq. 7)
      // T_p = T - n_iterations / (iteration - n_iterations)
      final double T_p = T - nIteration / (double) (iteration - nIteration);

      // Calculates the polygon grid accuracy (Eq. 10)
      // P_grid = np.fabs(best_agent.position - agent.position)
      final double[][] P_grid = JNum.fabs(JNum.sub(bestAgent.getPositions(), agent.getPositions()));

      // Generates a uniform random number and the `C` coefficient
      double r1 = Random.getUnifiedRandomNumber();
      final double[] C = Random.generateUniformRandomNumbers(agent.getN_Variables());

      // Calculates the avoidance coefficient (Eq. 9)
      // A = 2 * (T_p + P_grid) * r1 - T_p
      final double[][] A = JNum.sub(JNum.mult(JNum.sum(P_grid, T_p), 2 * r1), T_p);

      // Calculates the social forces of emperor penguin (Eq. 12)
      // S = (np.fabs(self.f * np.exp(-iteration / self.l) - np.exp(-iteration))) ** 2
      final double S = Math.pow(Math.abs(getF() * Math.exp(-iteration / getL()) - Math.exp(-iteration)), 2);

      // Calculates the distance between current agent and emperor penguin (Eq. 8)
      // D_ep = np.fabs(S * best_agent.position - C * agent.position)
      final double[][] D_ep = JNum.fabs(JNum.sub(JNum.mult(bestAgent.getPositions(), S), JNum.mult(agent.getPositions(), C)));

      // Updates current agent's position (Eq. 13)
      // agent.position = best_agent.position - A * D_ep
      agent.setPositions(JNum.sub(bestAgent.getPositions(), JNum.mult(A, D_ep)));
    }
  }

  @Override
  public void run(Space space, Func function, boolean storeBestOnly, Func preEvalution)
  {
     /*
     Runs the optimization pipeline.
       Args:
           space (Space): A Space object that will be evaluated.
           function (Function): A Function object that will be used as the objective function.
           store_best_only (bool): If True, only the best agent of each iteration is stored in History.
      */

    for (int t = 0; t < space.getN_Iterations(); t++)
    {
      // Updating agents
      this.update(space.getAgents(), space.getBestAgent(), t, space.getN_Iterations());

      // Checking if agents meet the bounds limits
      space.clipLimits();

      // After the update, we need to re-evaluate the search space
      this.evaluate(space, function);
      System.out.printf("Fitness: %6.10f\n", space.getBestAgent().getFit());
      double[][] bestPosition = space.getBestAgent().getPositions();
      System.out.printf("Position: %s\n", JNum.print2DArray(bestPosition));
    }
  }
}