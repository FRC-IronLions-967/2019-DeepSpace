/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.text.DecimalFormat;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constraints;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {


  private TalonSRX rightMaster;
  private TalonSRX rightSlaveZero;
  private TalonSRX rightSlaveOne;

  private TalonSRX leftMaster;
  private TalonSRX leftSlaveZero;
  private TalonSRX leftSlaveOne;


  private DecimalFormat df = new DecimalFormat("#.##");
	//follows (x*.9)^2
	private double[] turnLookUp = new double[]{	 0
												,0.000081
												,0.000324
												,0.000729
												,0.001296
												,0.002025
												,0.002916
												,0.003969
												,0.005184
												,0.006561
												,0.0081
												,0.009801
												,0.011664
												,0.013689
												,0.015876
												,0.018225
												,0.020736
												,0.023409
												,0.026244
												,0.029241
												,0.0324
												,0.035721
												,0.039204
												,0.042849
												,0.046656
												,0.050625
												,0.054756
												,0.059049
												,0.063504
												,0.068121
												,0.0729
												,0.077841
												,0.082944
												,0.088209
												,0.093636
												,0.099225
												,0.104976
												,0.110889
												,0.116964
												,0.123201
												,0.1296
												,0.136161
												,0.142884
												,0.149769
												,0.156816
												,0.164025
												,0.171396
												,0.178929
												,0.186624
												,0.194481
												,0.2025
												,0.210681
												,0.219024
												,0.227529
												,0.236196
												,0.245025
												,0.254016
												,0.263169
												,0.272484
												,0.281961
												,0.2916
												,0.301401
												,0.311364
												,0.321489
												,0.331776
												,0.342225
												,0.352836
												,0.363609
												,0.374544
												,0.385641
												,0.3969
												,0.408321
												,0.419904
												,0.431649
												,0.443556
												,0.455625
												,0.467856
												,0.480249
												,0.492804
												,0.505521
												,0.5184
												,0.531441
												,0.544644
												,0.558009
												,0.571536
												,0.585225
												,0.599076
												,0.613089
												,0.627264
												,0.641601
												,0.6561
												,0.670761
												,0.685584
												,0.700569
												,0.715716
												,0.731025
												,0.746496
												,0.762129
												,0.777924
												,0.793881
												,0.81};
  // Put methods for controlling this subsystem
  // here. Call these from Commands
  public DriveSubsystem() {
    rightMaster = new TalonSRX(RobotMap.rightMaster);
    rightSlaveZero = new TalonSRX(RobotMap.rightSlaveZero);
    rightSlaveOne = new TalonSRX(RobotMap.rightSlaveOne);

    leftMaster = new TalonSRX(RobotMap.leftMaster);
    leftSlaveZero = new TalonSRX(RobotMap.leftSlaveZero);
    leftSlaveOne = new TalonSRX(RobotMap.leftSlaveOne);

		rightSlaveZero.follow(rightMaster);
		rightSlaveOne.follow(rightMaster);

		leftSlaveZero.follow(leftMaster);
		leftSlaveOne.follow(leftMaster);

		leftMaster.setInverted(true);
		leftSlaveZero.setInverted(true);
		leftSlaveOne.setInverted(true);
  }

  public void tankDrive(double leftYAxis, double rightYAxis) {
    leftYAxis = Deadband(leftYAxis);
    rightYAxis = Deadband(rightYAxis);

    leftYAxis = leftYAxis*Math.abs(leftYAxis);
    rightYAxis = rightYAxis*Math.abs(rightYAxis);

    move(leftYAxis, rightYAxis);
  }

  public void arcadeDrive(double yAxis, double xAxis) {
    yAxis = Deadband(yAxis);
    xAxis = Deadband(xAxis);

    yAxis = yAxis*Math.abs(yAxis);
    xAxis = xAxis*Math.abs(xAxis);

    double L = yAxis + xAxis;
    double R = yAxis - xAxis;
    double max = Math.abs(L);
    if(Math.abs(R) > max) {
      max = Math.abs(R);
    }
    if((Math.abs(yAxis) <= 1) && (Math.abs(xAxis) <= 1) && (max < 1)) {
      move(L,R);
  } else
    move(L/max, R/max);
  }

  public void arcadeDriveLookup(double yAxis, double xAxis) {
    yAxis = yAxis*Math.abs(yAxis);
    double xAxisConverted = turnLookUp[(int)(Double.valueOf(df.format(Math.abs(xAxis)))*100)];
    if(xAxis > 0) {
      xAxisConverted = -xAxisConverted;
    }
    yAxis = Deadband(yAxis);
    xAxisConverted = Deadband(xAxisConverted);

    double L = yAxis + xAxisConverted;
    double R = yAxis - xAxisConverted;
    double max = Math.abs(L);
    if(Math.abs(R) > max) max = Math.abs(R);
    if((Math.abs(yAxis) <= 1) && (Math.abs(xAxis) <= 1) && (max < 1)){
    	move(L,R);
    } else
    	move(L/max, R/max);
  }
  public double Deadband(double input) {
    // upper deadband
    if(input >= +Constraints.DriveSubsystem_deadband) {
      return input;
    } 
    // lower deadband
    else if(input <= -Constraints.DriveSubsystem_deadband) {
      return input;
    }
    // outside deadband
    return 0;
  }

  public void move(double leftPower, double rightPower) {
		System.out.println("Drive Powers(L,R): " + Double.toString(leftPower) + " : " + Double.toString(rightPower));
		rightMaster.set(ControlMode.PercentOutput, rightPower);
		leftMaster.set(ControlMode.PercentOutput, leftPower);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
