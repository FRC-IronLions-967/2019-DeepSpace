package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.lib.drive.ArcadeDrive;
import frc.lib.drive.TankDrive;
import frc.lib.util.IronTalonSRX;
import frc.lib.util.IronVictorSPX;
import frc.robot.Robot;
import frc.robot.commands.drivesubsystem.SplitArcadeLookUpCommand;

public class DriveSubsystem extends Subsystem implements PIDOutput {
	private PIDController pidController;

	public double PIDOutput;

	// public TalonSRX rightMaster;
	public IronTalonSRX rightMaster;
	// public TalonSRX rightSlaveZero;
	public IronTalonSRX rightSlaveZero;
	// public VictorSPX rightSlaveOne;
	public IronVictorSPX rightSlaveOne;

	// public TalonSRX leftMaster;
	public IronTalonSRX leftMaster;
	// public TalonSRX leftSlaveZero;
	public IronTalonSRX leftSlaveZero;
	// public VictorSPX leftSlaveOne;
	public IronVictorSPX leftSlaveOne;

	private int encoderCounter = 0;
	public boolean countsmeet;

	// follows (x*.9)^2
	// private double[] turnLookUp = new double[] { 0, 0.000081, 0.000324, 0.000729, 0.001296, 0.002025, 0.002916,
	// 		0.003969, 0.005184, 0.006561, 0.0081, 0.009801, 0.011664, 0.013689, 0.015876, 0.018225, 0.020736, 0.023409,
	// 		0.026244, 0.029241, 0.0324, 0.035721, 0.039204, 0.042849, 0.046656, 0.050625, 0.054756, 0.059049, 0.063504,
	// 		0.068121, 0.0729, 0.077841, 0.082944, 0.088209, 0.093636, 0.099225, 0.104976, 0.110889, 0.116964, 0.123201,
	// 		0.1296, 0.136161, 0.142884, 0.149769, 0.156816, 0.164025, 0.171396, 0.178929, 0.186624, 0.194481, 0.2025,
	// 		0.210681, 0.219024, 0.227529, 0.236196, 0.245025, 0.254016, 0.263169, 0.272484, 0.281961, 0.2916, 0.301401,
	// 		0.311364, 0.321489, 0.331776, 0.342225, 0.352836, 0.363609, 0.374544, 0.385641, 0.3969, 0.408321, 0.419904,
	// 		0.431649, 0.443556, 0.455625, 0.467856, 0.480249, 0.492804, 0.505521, 0.5184, 0.531441, 0.544644, 0.558009,
	// 		0.571536, 0.585225, 0.599076, 0.613089, 0.627264, 0.641601, 0.6561, 0.670761, 0.685584, 0.700569, 0.715716,
	// 		0.731025, 0.746496, 0.762129, 0.777924, 0.793881, 0.81 };
	private double[] turnLookUp = new double[] {0, 0, 0,  0.1, 0.10009000000000001, 0.10036, 0.10081000000000001, 
		0.10144, 0.10225000000000001, 0.10324000000000001, 0.10441, 0.10576, 0.10729000000000001, 
		0.10900000000000001, 0.11089, 0.11296, 0.11521, 0.11764000000000001, 0.12025000000000001, 
		0.12304000000000001, 0.12601, 0.12916, 0.13249, 0.136, 0.13969, 0.14356000000000002, 
		0.14761000000000002, 0.15184, 0.15625, 0.16084, 0.16561, 0.17056, 0.17569, 0.181, 
		0.18649000000000002, 0.19216, 0.19801000000000002, 0.20404, 0.21025, 0.21664, 0.22321000000000002, 
		0.22996000000000003, 0.23689000000000002, 0.24400000000000002, 0.25129, 0.25876, 
		0.26641000000000004, 0.27424000000000004, 0.28225, 0.29044000000000003, 0.29881, 0.30736, 0.31609, 
		0.325, 0.33409, 0.34336, 0.35281000000000007, 0.36244, 0.37224999999999997, 0.38224, 
		0.39241000000000004, 0.40276, 0.41329000000000005, 0.42400000000000004, 0.43489, 0.44596, 0.45721, 
		0.46864000000000006, 0.48025000000000007, 0.49204000000000003, 0.5040100000000001, 0.5161600000000001, 
		0.52849, 0.541, 0.55369, 0.5665600000000001, 0.5796100000000001, 0.59284, 0.60625, 0.6198400000000001, 
		0.63361, 0.64756, 0.66169, 0.676, 0.69049, 0.70516, 0.72001, 0.73504, 0.75025, 0.76564, 
		0.7812100000000001, 0.79696, 0.81289, 0.8290000000000001, 0.84529, 0.86176, 0.87841, 0.89524, 0.91225, 
		0.92944, 0.94681, 0.96436, 0.98209, 1.0};	// Put methods for controlling this subsystem
	// here. Call these from Commands

	public DriveSubsystem() {
		// rightMaster = new TalonSRX(Robot.m_robotMapProperties.getDriveRightMaster());
		rightMaster = new IronTalonSRX(Robot.m_robotMapProperties.getDriveRightMaster());
		// rightSlaveZero = new TalonSRX(Robot.m_robotMapProperties.getDriveRightSlaveZero());
		rightSlaveZero = new IronTalonSRX(Robot.m_robotMapProperties.getDriveRightSlaveZero());
		// rightSlaveOne = new VictorSPX(Robot.m_robotMapProperties.getDriveRightSlaveOne());
		rightSlaveOne = new IronVictorSPX(Robot.m_robotMapProperties.getDriveRightSlaveOne());

		// leftMaster = new TalonSRX(Robot.m_robotMapProperties.getDriveLeftMaster());
		leftMaster = new IronTalonSRX(Robot.m_robotMapProperties.getDriveLeftMaster());
		// leftSlaveZero = new TalonSRX(Robot.m_robotMapProperties.getDriveLeftSlaveZero());
		leftSlaveZero = new IronTalonSRX(Robot.m_robotMapProperties.getDriveLeftSlaveZero());
		// leftSlaveOne = new VictorSPX(Robot.m_robotMapProperties.getDriveLeftSlaveOne());
		leftSlaveOne = new IronVictorSPX(Robot.m_robotMapProperties.getDriveLeftSlaveOne());

		rightSlaveZero.follow(rightMaster);
		rightSlaveOne.follow(rightSlaveZero);

		leftSlaveZero.follow(leftMaster);
		leftSlaveOne.follow(leftSlaveZero);

		rightMaster.setInverted(false);
		rightSlaveZero.setInverted(false);
		rightSlaveOne.setInverted(false);

		leftMaster.setInverted(true);
		leftSlaveZero.setInverted(true);
		leftSlaveOne.setInverted(true);

		rightMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		leftMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);

		pidController = new PIDController(Robot.m_constraintsProperties.getkP(), Robot.m_constraintsProperties.getkI(),
				Robot.m_constraintsProperties.getkD(), Robot.m_navigationSubsystem.gyro, this);

		pidController.disable();
		pidController.setInputRange(-180.0f, 180.0f);
		pidController.setOutputRange(-1.0, 1.0);
		pidController.setAbsoluteTolerance(Robot.m_constraintsProperties.getPIDTolerance());
		pidController.setContinuous(true);
	}

	public void tankDrive(double leftYAxis, double rightYAxis) {
		TankDrive tankDrive = new TankDrive(Math.sqrt(leftYAxis), Math.sqrt(rightYAxis), Robot.m_constraintsProperties.getDeadband());
		move(tankDrive.getLeftOutput(), tankDrive.getRightOutput());
	}

	public void arcadeDrive(double yAxis, double xAxis) {
		ArcadeDrive arcadeDrive = new ArcadeDrive(xAxis, yAxis, Robot.m_constraintsProperties.getDeadband());
		move(arcadeDrive.getL(), arcadeDrive.getR());
	}

	public void arcadeDriveLookup(double yAxis, double xAxis) {
		ArcadeDrive arcadeDrive = new ArcadeDrive(xAxis, yAxis, Robot.m_constraintsProperties.getDeadband(),
				turnLookUp);
		move(arcadeDrive.getL(), arcadeDrive.getR());
	}

	public void move(double leftPower, double rightPower) {
		rightMaster.set(ControlMode.PercentOutput, rightPower);
		leftMaster.set(ControlMode.PercentOutput, leftPower);
	}

	public void enablePid() {
		pidController.enable();
	}

	public void disablePid() {
		pidController.disable();
	}

	public void pidSetPoint(double input) {
		pidController.setSetpoint(input);
	}

	public void pidWrite(double output) {
		if (pidController.getDeltaSetpoint() < 0) {
			PIDOutput = output;
		} else {
			PIDOutput = -output;
		}
	}

	public boolean pidDone() {
		if (Math.abs(Math.abs(pidController.getSetpoint())
				- Math.abs(Robot.m_navigationSubsystem.gyro.getYaw())) < Robot.m_constraintsProperties
						.getPIDTolerance()) {
			return true;
		} else {
			return false;
		}
	}

	public double getLeftEncoder() {
		return -leftMaster.getSensorCollection().getQuadraturePosition();
	}

	public double getRightEncoder() {
		return rightMaster.getSensorCollection().getQuadraturePosition();
	}

	public boolean zeroEncoders() {
		leftMaster.getSensorCollection().setQuadraturePosition(0, 0);
		rightMaster.getSensorCollection().setQuadraturePosition(0, 0);
		if (encoderCounter > 10) {
			encoderCounter = 0;
			return true;
		} else {
			encoderCounter++;
			return false;
		}
	}

	public boolean driveDistance(double count) {
		countsmeet = false;
		if (count > 0) {
			if ((getLeftEncoder() + getRightEncoder()) / 2 > count) {
				countsmeet = true;
				return true;
			} else {
				return false;
			}
		} else {
			if ((getLeftEncoder() + getRightEncoder()) / 2 < count) {
				countsmeet = true;
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new SplitArcadeLookUpCommand());
	}
}
