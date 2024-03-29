// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriverControl;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;


public class ArcadeDrive extends CommandBase {
  /** Creates a new ArcadeDrive. */
  Double PO = 0.3;
  public ArcadeDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

    

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Double LJY = RobotContainer.XboxC.getRawAxis(1);
    Double RJX = RobotContainer.XboxC.getRawAxis(4);

    RobotContainer.m_drivetrain.runLeftSide(ControlMode.PercentOutput, (LJY-RJX)* PO);
    RobotContainer.m_drivetrain.runRightSide(ControlMode.PercentOutput, (LJY+RJX)* PO);
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
