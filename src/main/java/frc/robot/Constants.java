/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 * Add your docs here.
 */
public class Constants {
    public static AnalogInput ultrasonic = new AnalogInput(RobotMap.ultrasonicChannel);
    // Drive train speeds
    public static final double fastRobotSpeed = 0.80;
    public static final double slowRobotSpeed = 0.60;
    public static final double robotDefaultSpeed = 0.70;
    public static final double robotSpeedDiff = 0.10;
}
