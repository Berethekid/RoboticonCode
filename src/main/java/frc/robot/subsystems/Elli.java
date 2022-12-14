// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elli extends SubsystemBase {
  /** Creates a new Elli. */
  public Elli() {
    // SupplyCurrentLimitConfiguration cfg = new SupplyCurrentLimitConfiguration(true, 50, 50, 0);
    // Elli_L.configSupplyCurrentLimit(cfg);
    // Elli_R.configSupplyCurrentLimit(cfg);
  }

  public TalonFX Elli = new TalonFX(Constants.ELLI);

  public DigitalInput LiftSwitch = new DigitalInput(Constants.LIFT_LIMIT_SWITCH);

  public int elli_pos = 0;

  public void setElliMotorsPos(double pos) {
    Elli.set(ControlMode.Position, pos);
  }

  public void setElliMotorsPercent(double pos) {
    Elli.set(ControlMode.PercentOutput, pos);
  }

  public void setMotorsZero () {
    Elli.setSelectedSensorPosition(0, 0, 0);
    System.out.println("Lift Zero");
  }

  public double getElliPos () {
    return Elli.getSelectedSensorPosition();
  }

  public Boolean getLiftSwitch () {
    return LiftSwitch.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
