// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Shooter_systems;




import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Kicker extends SubsystemBase {
  /** Creates a new Kicker. */
  public Kicker() {}
    private static CANSparkMax kicker = new CANSparkMax(Constants.kickerWheel, MotorType.kBrushless);

  public void runKicker(double speed){
    kicker.setInverted(true);
    kicker.set(speed);
   
  } 
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
