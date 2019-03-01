package frc.robot.commands.navigation;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.drivesubsystem.moveTimeCommand;
import frc.robot.commands.hatchpanelsubsystem.CloseGrabberCommand;
import frc.robot.commands.hatchpanelsubsystem.OpenGrabberCommand;

public class limelightAutoScore extends CommandGroup {
  /**
   * Add your docs here.
   */
  public limelightAutoScore(boolean isDepo) {
    // open or close depending on if we are tring to get or deposit the hatch
    if (isDepo) {
      addSequential(new CloseGrabberCommand());
    } else {
      addSequential(new OpenGrabberCommand());  
    }
  
    // get to the target
    addSequential(new limelightGetToTarget());

    // grab or deposit the hatch
    if (isDepo) {
      addSequential(new OpenGrabberCommand());  
    } else {
      addSequential(new CloseGrabberCommand());
    }
    // move away from the target to let the drivers know that we are deposited
    addSequential(new moveTimeCommand(.5, -.5));
  }
}
