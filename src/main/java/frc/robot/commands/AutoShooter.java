/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;

public class AutoShooter extends Command {
  int counter;
  public AutoShooter() {
    // Use requires() here to declare subsystem dependencies
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    shoot(0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
public void execute() {
  double rawRange = (Constants.ultrasonic.getAverageVoltage()*102)/24.5;
  System.out.println(rawRange);
  if (rawRange <= 12)
    shoot(1);
  else 
    shoot(0);
  // double timePassed = timeSinceInitialized();
    // if (timePassed<=2)
    //   moveForward(Constants.slowRobotSpeed); 
    // else if (timePassed > 2 && timePassed <= 3.5)
    //   turnRight(Constants.slowRobotSpeed);
    // else if (timePassed > 3.5 && timePassed <= 6)
    //   moveForward(Constants.slowRobotSpeed);
    // else if (timePassed>6 && timePassed <= 7.5)
    //   turnLeft(Constants.slowRobotSpeed);
    // else if (timePassed >7.5 && timePassed < 10){
    //   moveBackwards(Constants.slowRobotSpeed);
    //   shoot(1);
    // }
    // else if (timePassed >= 10)
    //   stationary();
  }
  private void shoot(double speed){
    if (speed == 0)
      Robot.shooterSubsystem.stop();
    else
      Robot.shooterSubsystem.shoot();
  }


  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveSubsystem.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
