// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;
/* Utlizes DriveTrain subsystem and implements joystick control */
import frc.robot.subsystems.DriveTrain; 

public class DriveCommand extends CommandBase {
  /** Creates a new DriveCommand. */
  Joystick leftJoy;
  Joystick rightJoy;

  public DriveCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    this.leftJoy = new Joystick(RobotMap.LEFT_JOYSTICK); 
    this.rightJoy = new Joystick(RobotMap.RIGHT_JOYSTICK); 

    addRequirements(RobotContainer.m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftSpeed = leftJoy.getRawAxis(RobotMap.LEFT_JOYSTICK);
    double rightSpeed = rightJoy.getRawAxis(RobotMap.RIGHT_JOYSTICK);

    RobotContainer.m_driveTrain.tankDrive(leftSpeed, rightSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
