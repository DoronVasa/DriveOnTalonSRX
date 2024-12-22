// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class DiffrentialDriveCommand extends Command {
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();

  private final XboxController controller;
 
  public DiffrentialDriveCommand(XboxController controller) {
    this.controller = controller;

    addRequirements();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftJoy = this.controller.getLeftY();
    double rightJoy = this.controller.getRightX();

    driveSubsystem.moveWithDifferentioal(leftJoy, rightJoy);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveSubsystem.stopMotors();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
