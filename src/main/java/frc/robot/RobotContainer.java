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
    // Yotam you gonna hate me for the swith case but fuck it itll be funny.
    switch (Constants.OperatorConstants.driveEnum) {
      case DIFFERENTIAL:
        this.driveSubsystem.setDefaultCommand(new DiffrentialDriveCommand(xboxController));
        break;
      case TANK:
        this.driveSubsystem.setDefaultCommand(new DriveCommand(xboxController));
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + Constants.OperatorConstants.driveEnum);
    }
}

}