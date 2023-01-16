package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveSubsystem extends Subsystem {

	Victor frontRight = new Victor(RobotMap.frontRight);
	Victor backRight = new Victor(RobotMap.backRight);
	Victor frontLeft = new Victor(RobotMap.frontLeft);
	Victor backLeft = new Victor(RobotMap.backLeft);

	SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, backLeft);
	SpeedControllerGroup right = new SpeedControllerGroup(frontRight, backRight);
	private DifferentialDrive drive;

	public DriveSubsystem() {
		frontRight.setInverted(true);
		frontLeft.setInverted(true);
		backRight.setInverted(true);
		backLeft.setInverted(true);
		drive = new DifferentialDrive(left, right);
	}
	public void drive(double straight, double rotation) {
		drive.arcadeDrive(straight, rotation);
	}
	
	// Stops the motors on the drivetrain
	public void stop() {
		drive.stopMotor();
	}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
	setDefaultCommand(new DriveCommand());
  }
}
