package frc.robot;
import java.util.Date;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.lib.log.Logging;
import frc.lib.util.MACAddress;
import frc.lib.util.MACConfigChooser;
import frc.robot.networktables.limelight;
import frc.robot.properties.ConstraintsProperties;
import frc.robot.properties.RobotMapProperties;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.HatchPanelSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.CargoSubsystem;
import frc.robot.subsystems.NavigationSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static Logging logger;

  public static NavigationSubsystem m_navigationSubsystem;
  public static HatchPanelSubsystem m_hatchPanelSubsystem;
  public static CargoSubsystem m_cargoSubsystem;
  public static IntakeSubsystem m_intakeSubsystem;
  // always declare properties objects before subsystems or else it will fail to
  // instantiate
  public static MACAddress m_macaddress;
  public static MACConfigChooser m_macconfigchooser;
  public static ConstraintsProperties m_constraintsProperties;
  public static RobotMapProperties m_robotMapProperties;
  public static DriveSubsystem m_driveSubsystem;
  public limelight m_lLimelight;
  public static OI m_oi;

  // Command m_autonomousCommand;
  // SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    String macArray[] = {"00-80-2F-17-86-03", "00-80-2F-19-0C-F5", "00-80-2F-19-0C-F5"};
    String constraintsPaths[] = { "/home/lvuser/deploy/greenBox/greenBoxConstraints.properties",
        "/home/lvuser/deploy/practiceBot/practiceBotConstraints.properties",
        "/home/lvuser/deploy/compBot/compBotConstraints.properties" };
    String mapPaths[] = { "/home/lvuser/deploy/greenBox/greenBoxRobotmap.properties",
        "/home/lvuser/deploy/practiceBot/practiceBotRobotmap.properties",
        "/home/lvuser/deploy/compBot/compBotRobotmap.properties" };

    m_macaddress = new MACAddress(new byte[] {0,0,0,0,0,0});
    m_macconfigchooser = new MACConfigChooser(m_macaddress.getMACAddress(), macArray, constraintsPaths, mapPaths);

    m_constraintsProperties = new ConstraintsProperties(m_macconfigchooser.getConstraintsPath());
    m_robotMapProperties = new RobotMapProperties(m_macconfigchooser.getRobotmapPath());

    m_navigationSubsystem = new NavigationSubsystem();
    m_driveSubsystem = new DriveSubsystem();
    m_hatchPanelSubsystem = new HatchPanelSubsystem();
    m_cargoSubsystem = new CargoSubsystem();
    m_intakeSubsystem = new IntakeSubsystem();
    m_oi = new OI();

    // CameraServer.getInstance().startAutomaticCapture();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {
    m_hatchPanelSubsystem.disabledInit();
    m_navigationSubsystem.disabledinit();

    try {
      logger.close();
      System.out.println("logger closed");
    } catch (Exception e) {
      System.out.println("logger not started");
    }

  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString code to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons to
   * the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_hatchPanelSubsystem.armUp();
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {

      e.printStackTrace();
    }
    m_hatchPanelSubsystem.grabberClose();

    // m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
     * switch(autoSelected) { case "My Auto": autonomousCommand = new
     * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
     * ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    // if (m_autonomousCommand != null) {
    // m_autonomousCommand.start();
    // }
    logger = Logging.getInstance("Autolog");
    logger.log("Auto Init");
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    // if (m_autonomousCommand != null) {
    // m_autonomousCommand.cancel();
    // }
    Date date = new Date();

    logger = Logging.getInstance("TeleOp:"+ date);
    teleopLoggerInit();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    teleopLogerPeriodic();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  private void teleopLoggerInit() {
    // StringBuilder builder = new StringBuilder();
    // builder.append("limeLightTX").append(",")
    //        .append("limeLightTY").append(",")
    //        .append("limeLightTA").append(",")
    //        .append("ArmLeftCuremt").append(",")
    //        .append("ArmRightCurent").append(",")
    //        .append("DriveLeft0Curent").append(",")
    //        .append("DriveLeft1Curent").append(",")
    //        .append("DriveLeft2Curent").append(",")
    //        .append("DriveRight0Curent").append(",")
    //        .append("DriveRight1Curent").append(",")
    //        .append("DriveRight2Curent").append(",");
    //       //  .append("IMU_Calabrated").append(",")
    //       //  .append("IMU_Yaw").append(",")
    //       //  .append("IMU_Pitch").append(",")
    //       //  .append("IMU_Roll").append(",");
    // logger.log(builder.toString());
  }

  private void teleopLogerPeriodic() {
    // StringBuilder builder = new StringBuilder();
    // builder.append(Double.toString(m_lLimelight.getTX())).append(",")
    //        .append(Double.toString(m_lLimelight.getTY())).append(",")
    //        .append(Double.toString(m_lLimelight.getTA())).append(",")
    //        .append(Double.toString(m_cargoSubsystem.leftArm.getOutputCurrent())).append(",")
    //        .append(Double.toString(m_cargoSubsystem.rightArm.getOutputCurrent())).append(",")
    //        .append(Double.toString(m_driveSubsystem.leftMaster.getOutputCurrent())).append(",")
    //        .append(Double.toString(m_driveSubsystem.leftSlaveZero.getOutputCurrent())).append(",")
    //        .append(Double.toString(0)).append(",")
    //        .append(Double.toString(m_driveSubsystem.rightMaster.getOutputCurrent())).append(",")
    //        .append(Double.toString(m_driveSubsystem.rightSlaveZero.getOutputCurrent())).append(",")
    //        .append(Double.toString(0)).append(",");
    //       //  .append(Boolean.toString(m_navigationSubsystem.gyro.isCalibrating())).append(",")
          //  .append(Double.toString(m_navigationSubsystem.gyro.getYaw())).append(",")
          //  .append(Double.toString(m_navigationSubsystem.gyro.getPitch())).append(",")
          //  .append(Double.toString(m_navigationSubsystem.gyro.getRoll())).append(",");
    // logger.log(builder.toString());
  }
}
