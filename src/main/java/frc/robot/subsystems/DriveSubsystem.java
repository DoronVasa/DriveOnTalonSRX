// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Subsystems.DriveConstants;;

public class DriveSubsystem extends SubsystemBase {
  private final TalonSRX leftSideMaster = new TalonSRX(DriveConstants.LEFT_MASTER_TALONSRX_ID);
  private final TalonSRX leftSideSlave = new TalonSRX(DriveConstants.LEFT_SLAVE_TALONSRX_ID);

  private final TalonSRX rightSideMaster = new TalonSRX(DriveConstants.RIGHT_MASTER_TALONSRX_ID);
  private final TalonSRX rightSideSlave = new TalonSRX(DriveConstants.RIGHT_SLAVE_TALONSRX_ID);
  
  public DriveSubsystem() {
    leftSideSlave.follow(leftSideMaster);

    rightSideSlave.follow(rightSideMaster);
    rightSideMaster.setInverted(true);
  }

  public void MoveWithJoystick(double leftJoy, double rightJoy){
    leftSideMaster.set(ControlMode.PercentOutput, leftJoy);
    rightSideMaster.set(ControlMode.PercentOutput, rightJoy);
  }

  public void MoveWithDifferentioal(double leftJoy, double rightJoy){
    double steeringDiffrential = leftJoy * 0.75 * rightJoy;

    if (steeringDiffrential < 0){
        leftSideMaster.set(ControlMode.PercentOutput, leftJoy - steeringDiffrential);
        rightSideMaster.set(ControlMode.PercentOutput, leftJoy);
    }
    else{
        leftSideMaster.set(ControlMode.PercentOutput, leftJoy);
        rightSideMaster.set(ControlMode.PercentOutput, leftJoy - steeringDiffrential);
    }
  }
}