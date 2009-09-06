package cheloniidae.frames;

import cheloniidae.*;
import cheloniidae.commands.*;
import cheloniidae.replicators.*;

import java.awt.Color;

import java.util.Random;

public abstract class CoreCommands {
  protected Random rng = new Random ();

  public static Move move (double distance) {return new Move (distance);}
  public static Jump jump (double distance) {return new Jump (distance);}

  public static Turn  turn  (double angle) {return new Turn (angle);}
  public static Bank  bank  (double angle) {return new Bank (angle);}
  public static Pitch pitch (double angle) {return new Pitch (angle);}

  public static LineSize  size  (double size) {return new LineSize (size);}
  public static LineColor color (Color color) {return new LineColor (color);}

  public static Position            position            (Vector position)            {return new Position (position);}
  public static Direction           direction           (Vector direction)           {return new Direction (direction);}
  public static DirectionComplement directionComplement (Vector directionComplement) {return new DirectionComplement (directionComplement);}

  public static NullCommand pass  ()            {return new NullCommand ();}
  public static Debug       debug (String text) {return new Debug (text);}

  public static Repeat          repeat   (int repetitions, TurtleCommand ... commands) {return new Repeat (repetitions, commands);}
  public static CommandSequence sequence (TurtleCommand ... commands)                  {return new CommandSequence (commands);}

  public static InductiveReplicator<StandardRotationalTurtle> inductiveReplicator (int copies, TurtleCommand inductiveStep,
                                                                                   TurtleCommand ... replicatedActions) {
    return new InductiveReplicator<StandardRotationalTurtle> (copies, inductiveStep, replicatedActions);
  }

  public double random ()             {return rng.nextDouble ();}
  public double random (double scale) {return rng.nextDouble () * scale;}
}