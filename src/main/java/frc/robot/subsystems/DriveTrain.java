// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.RobotMap; 

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  TalonSRX frontLeftMotor;
	TalonSRX frontRightMotor;
	TalonSRX backLeftMotor;
	TalonSRX backRightMotor;
	Joystick leftJoy;
	Joystick rightJoy;
	DifferentialDrive drive;

  public DriveTrain() {
    frontLeftMotor = new TalonSRX(RobotMap.FRONT_LEFT_DRIVE_CHANNEL); 
    frontRightMotor = new TalonSRX(RobotMap.FRONT_RIGHT_DRIVE_CHANNEL); 
    backLeftMotor = new TalonSRX(RobotMap.BACK_LEFT_DRIVE_CHANNEL); 
    backRightMotor = new TalonSRX(RobotMap.BACK_RIGHT_DRIVE_CHANNEL); 

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}