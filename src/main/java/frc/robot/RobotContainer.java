// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.DiffrentialDriveCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.XboxController;

public class RobotContainer {
  private final DriveSubsystem driveSubsystem = new DriveSubsystem(); 

  private final XboxController xboxController = new XboxController(Constants.OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    // Fuck it just comment one of theese out based on what you wonna drive idk how to do this properly.
    this.driveSubsystem.setDefaultCommand(new DiffrentialDriveCommand(xboxController));

    // this.driveSubsystem.setDefaultCommand(new DriveCommand(xboxController));
  }
}