// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriverControl.Shooting;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class runShooter extends CommandBase {
  /** Creates a new runShooter. */
  double m_value;
  boolean FIN;
  public runShooter(double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_Shooter, RobotContainer.m_Beltsystem);
    m_value = speed;
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_value > 0) {
      RobotContainer.m_Shooter.setShootMotors(ControlMode.PercentOutput, m_value);
      FIN = true;
    }
    if (m_value < 0) {
      RobotContainer.m_Shooter.setShootMotors(ControlMode.PercentOutput, -0.5);
      FIN = true;
    }
    if (m_value == 0) {
      RobotContainer.m_Shooter.setShootMotors(ControlMode.PercentOutput, 0.0);
      FIN = true;
      }
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
