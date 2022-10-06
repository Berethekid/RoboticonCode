// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.ResourceBundle.Control;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  public Drivetrain() {
    RM.setNeutralMode(NeutralMode.Coast);
    LM.setNeutralMode(NeutralMode.Coast);
    RS.setNeutralMode(NeutralMode.Coast);
    LS.setNeutralMode(NeutralMode.Coast);
    


  }

   // Extras
   SlewRateLimiter filter = new SlewRateLimiter(1);
   double percent = 0.1; 

  public TalonFX LM = new TalonFX(Constants.leftM);
  public TalonFX LS = new TalonFX(Constants.leftS);

  public TalonFX RM = new TalonFX(Constants.rightM);
  public TalonFX RS = new TalonFX(Constants.rightS);

  public void runLeftSide(ControlMode cm, double unit){
    LM.set(cm, unit * percent);
    LS.follow(LM);
  }

  public void runRightSide(ControlMode cm, double unit){
    RM.set(cm, unit * percent);
    RS.follow(RM);
  } 
  
  public void runBothSide(ControlMode cm, double unit){
    runLeftSide(cm, unit);
    runRightSide(cm, unit);
  }

  public void SensorZero(){
    RM.setSelectedSensorPosition(0);
    RS.setSelectedSensorPosition(0);
    LM.setSelectedSensorPosition(0);
    LS.setSelectedSensorPosition(0);
  }

  public double getRightPos () {
    double RMPOS = RM.getSelectedSensorPosition();
    return RMPOS;
  }
  public double getLeftPos () {
    return LM.getSelectedSensorPosition();
  }


  public void setDistance(double feet){
    runBothSide(ControlMode.Position, MotorAlg(feet));
    System.out.println("Position set to: " + MotorAlg(feet));
    System.out.println("Position at: " + getRightPos());
  }

  private float MotorAlg(double feet) {
    float unit = (float) (25416.706444 * feet );
    return unit;
  }


    // Gear Ratio
  //4096 ticks = 1 rotation of the motor
  //11:60
  //6.5:1
  //one rotation = 26,624 ticks
  //4in wheels
  //2pi2in = 12.57in
  //- 12708.35322198
  //

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
