package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;
public class DriveCommand extends Command {

  private Joystick joystick = Robot.m_oi.getDriverStick();
  private double joystickY, joystickX, joystickSlider;
  private boolean speedUpisPressed, speedDownisPressed, defaultSpeedisPressed;
  public DriveCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveSubsystem);
  }

 // Ensures motors aren't already moving 
 @Override
 protected void initialize() {
   Robot.driveSubsystem.stop();
 }

 // Uses the driver joystick to control the drive train with
 //speed damper , speed modifier , change motor speed
 @Override
 protected void execute() {
    joystickY = joystick.getY(); joystickX = -joystick.getX();
    joystickSlider = -joystick.getRawAxis(RobotMap.sliderAxis);
    speedUpisPressed = joystick.getRawButton(RobotMap.speedUpButton);
    speedDownisPressed = joystick.getRawButton(RobotMap.slowDownButton);
    defaultSpeedisPressed = joystick.getRawButton(RobotMap.defaultSpeedButton);
    if (speedUpisPressed) driveRobot(Constants.fastRobotSpeed);
    else if (speedDownisPressed) driveRobot(Constants.slowRobotSpeed);
    else if (defaultSpeedisPressed) driveRobot(Constants.robotDefaultSpeed);
    else driveRobot(Constants.robotDefaultSpeed+(joystickSlider*Constants.robotSpeedDiff));
 } 
 private void driveRobot(double speed) {
   Robot.driveSubsystem.drive(joystickY*speed, joystickX*speed);
  }
  
  // Will only return true if the command is cancelled
  @Override
  protected boolean isFinished() {
    return false;
  }
  
  // Stops the motors
  @Override
  protected void end() {
    Robot.driveSubsystem.stop();
  }
  
  // Ends when the command is interrupted
  @Override
  protected void interrupted() {
    end();
  }
}
