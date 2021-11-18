// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.RobotMap; 

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Talon;

// try this if DifferentialDrive doesn't work
// change TalonSRX to Talon and do the following import
// import edu.wpi.first.wpilibj.Talon;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  Talon frontLeftMotor;
	Talon frontRightMotor;
	Talon backLeftMotor;
  Talon backRightMotor;
  
  DifferentialDrive drive;
  
  SpeedControllerGroup leftControllerGroup;
  SpeedControllerGroup rightControllerGroup; 

  public DriveTrain() {
    // create each of the 4 drive train motors and get their channel #s from RobotMap
    this.frontLeftMotor = new Talon(RobotMap.FRONT_LEFT_DRIVE_CHANNEL); 
    this.frontRightMotor = new Talon(RobotMap.FRONT_RIGHT_DRIVE_CHANNEL); 
    this.backLeftMotor = new Talon(RobotMap.BACK_LEFT_DRIVE_CHANNEL); 
    this.backRightMotor = new Talon(RobotMap.BACK_RIGHT_DRIVE_CHANNEL); 

    // link the two motors on each side of the drivetrain
    // SpeedContorllerGroup() takes two SpeedController objects AND Talon objects
    // It does NOT take TalonSRX (idk why)
    this.leftControllerGroup = new SpeedControllerGroup(frontLeftMotor, backLeftMotor);
    this.rightControllerGroup = new SpeedControllerGroup(frontRightMotor, backRightMotor);

    // create DifferentialDrive
    // takes two SpeedControllers 
    this.drive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);
  }

  // https://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/drive/DifferentialDrive.html#:~:text=leftSpeed%2C%20double%C2%A0rightSpeed)-,Tank%20drive%20method%20for%20differential%20drive%20platform.,-void

  public void tankDrive(double leftSpeed, double rightSpeed) {
    // https://first.wpi.edu/FRC/roborio/beta/docs/java/edu/wpi/first/wpilibj/drive/DifferentialDrive.html#:~:text=Forward%20is%20positive.-,tankDrive,-public%C2%A0void%C2%A0tankDrive
    this.drive.tankDrive(leftSpeed, rightSpeed); 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
