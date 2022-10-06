// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.*;
import frc.robot.commands.DriverControl.ArcadeDrive;
import frc.robot.commands.DriverControl.TankDrive;
import frc.robot.commands.DriverControl.Intake.DeployIntake;
import frc.robot.commands.DriverControl.Intake.SolenoidTest;
import frc.robot.commands.DriverControl.Lift.setLiftPos;
import frc.robot.commands.DriverControl.Shooting.SendBallToShooter;
import frc.robot.commands.DriverControl.Shooting.runShooter;
import frc.robot.subsystems.Air_Systems;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elli;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Shooter_systems.BeamBreaks;
import frc.robot.subsystems.Shooter_systems.BeltSystem;
import frc.robot.subsystems.Shooter_systems.Intake;
import frc.robot.subsystems.Shooter_systems.Kicker;
import frc.robot.subsystems.Shooter_systems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public final static Drivetrain m_drivetrain = new Drivetrain();
  public final static Shooter m_Shooter = new Shooter();
  public final static Kicker m_Kicker = new Kicker();
  public final static BeltSystem m_Beltsystem = new BeltSystem();
  public final static BeamBreaks m_Beambreaks = new BeamBreaks();
  public final static Elli m_Elli = new Elli();
  public final static Intake m_intake = new Intake();
  public final static Air_Systems m_air_system = new Air_Systems();

  

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */




  // Controller
  
  public static Joystick XboxC = new Joystick(Constants.JOYSTICK_PORT);

  public static double getDeadZone (int axis){
    if (Math.abs(XboxC.getRawAxis(axis)) < 0.1) {
      return 0.0;
    } else {
      return XboxC.getRawAxis(axis);
    }
  }
  
  public static JoystickButton AB = new JoystickButton(XboxC, 1);
  public static JoystickButton BB = new JoystickButton(XboxC, 2);
  public static JoystickButton XB = new JoystickButton(XboxC, 3);
  public static JoystickButton YB = new JoystickButton(XboxC, 4);
  public static JoystickButton LB = new JoystickButton(XboxC, 5);
  public static JoystickButton RB = new JoystickButton(XboxC, 6);
  public static JoystickButton HB = new JoystickButton(XboxC, 7);
  public static JoystickButton ZB = new JoystickButton(XboxC, 8);
  public static JoystickButton LJB = new JoystickButton(XboxC, 9);
  public static JoystickButton RJB = new JoystickButton(XboxC, 10);

  
  private void configureButtonBindings() {

 /*   AB.whenPressed(new setLiftPos(0.0));
    YB.whenPressed(new setLiftPos(Constants.LIFT_MAX)); */

    XB.whenPressed(new DeployIntake(Constants.Intake_Speed, true));
    XB.whenReleased(new DeployIntake(0.0, false));


    LB.whenPressed(new SendBallToShooter(1));
    LB.whenReleased(new SendBallToShooter(0));

    YB.whenPressed(new SendBallToShooter(-1));
    YB.whenReleased(new SendBallToShooter(0));

    RB.whenPressed(new runShooter(0.6));
    RB.whenReleased(new runShooter(0.0));

    HB.whenPressed(new SolenoidTest(true));
    ZB.whenPressed(new SolenoidTest(false));


    RJB.whenPressed(new ArcadeDrive());
    LJB.whenPressed(new TankDrive());



  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
