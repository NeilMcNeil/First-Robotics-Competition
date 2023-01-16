package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // Drive train motor ports
  public static final int frontRight = 0;
  public static final int frontLeft = 1;
  public static final int backLeft = 4;
  public static final int backRight = 5;

  // Drive train button and axis ports
  public static final int sliderAxis = 3;
  public static final int speedUpButton = 1;
  public static final int slowDownButton = 2;
  public static final int defaultSpeedButton = 3;
  
  // Intake and shooter motor ports
  public static final int shooterTop = 6;
  public static final int shooterBottom = 7;
  
  // Intake and shooter button ports
  public static final int shooterButtonPort = 4;

  public static final int ultrasonicChannel = 0;
}
