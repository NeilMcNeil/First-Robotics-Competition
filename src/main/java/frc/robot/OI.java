package frc.robot;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ShooterCommand;

public class OI {
	// Instantiaion of joysticks
	Joystick driverStick = new Joystick(0);
	Joystick operatorStick = new Joystick(1);
	JoystickButton shooter = new JoystickButton(operatorStick, RobotMap.shooterButtonPort);
	// Joystick accessors
	public Joystick getDriverStick() {
		return driverStick;
  }
  public Joystick getOperatorStick() {
		return operatorStick;
	}
	public OI(){
		shooter.whileHeld(new ShooterCommand());
  }
}
