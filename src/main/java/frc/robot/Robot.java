package frc.robot;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.lib.log.Logging;
import frc.lib.util.MACAddress;
import frc.lib.util.MACConfigChooser;
import frc.robot.networktables.*;
import frc.robot.properties.ConstraintsProperties;
import frc.robot.properties.RobotMapProperties;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.CargoArmSubsystem;
import frc.robot.subsystems.HatchPanelIntakeSubsystem;
import frc.robot.subsystems.CargoIntakeSubsystem;
import frc.robot.subsystems.CargoSubsystem;
import frc.robot.subsystems.HatchPanelSubsystem;
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
  public static CargoArmSubsystem m_cargoArmSubsystem;
  public static HatchPanelIntakeSubsystem m_hatchPanelIntakeSubsystem;
  public static CargoSubsystem m_cargoSubsystem;
  public static CargoIntakeSubsystem m_cargoIntakeSubsystem;
  public static HatchPanelSubsystem m_hatchPanelSubsystem;
  //always declare properties objects before subsystems or else it will fail to instantiate
  public static MACAddress m_macaddress = new MACAddress();
  public static MACConfigChooser m_macconfigchooser;
  //  = new MACConfigChooser(m_macaddress.getMACAddress(), macArray, constraintsPaths, mapPaths);
  public static ConstraintsProperties m_constraintsProperties;
  //  = new ConstraintsProperties(m_macconfigchooser.getConstraintsPath());
  public static RobotMapProperties m_robotMapProperties;
  //  = new RobotMapProperties(m_macconfigchooser.getRobotmapPath());
  public static DriveSubsystem m_driveSubsystem;
  //  = new DriveSubsystem();
  public static OI m_oi;

  // Command m_autonomousCommand;
  // SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    String macArray[] = { "00-80-2F-19-0C-F3", "00-80-2F-19-0C-F5", "00-80-2F-17-86-03" };
    String constraintsPaths[] = { "/home/lvuser/deploy/greenBox/greenBoxConstraints.properties",
        "/home/lvuser/deploy/practiceBot/practiceBotConstraints.properties",
        "/home/lvuser/deploy/compBot/compBotConstraints.properties" };
    String mapPaths[] = { "/home/lvuser/deploy/greenBox/greenBoxRobotmap.properties",
        "/home/lvuser/deploy/practiceBot/practiceBotRobotmap.properties",
        "/home/lvuser/deploy/compBot/compBotRobotmap.properties" };

    m_macaddress = new MACAddress();
    m_macconfigchooser = new MACConfigChooser(m_macaddress.getMACAddress(), macArray, constraintsPaths, mapPaths);

    m_constraintsProperties = new ConstraintsProperties(m_macconfigchooser.getConstraintsPath());
    m_robotMapProperties = new RobotMapProperties(m_macconfigchooser.getRobotmapPath());

    limelight vision = new limelight();
    System.out.println(vision.getTX());
    System.out.println(vision.getTY());
    System.out.println(vision.getTA());
    m_navigationSubsystem = new NavigationSubsystem();
    m_driveSubsystem = new DriveSubsystem();
    m_cargoArmSubsystem = new CargoArmSubsystem();
    m_hatchPanelIntakeSubsystem = new HatchPanelIntakeSubsystem();
    m_cargoSubsystem = new CargoSubsystem();
    m_cargoIntakeSubsystem = new CargoIntakeSubsystem();
    m_hatchPanelSubsystem = new HatchPanelSubsystem();
    
    
    m_oi = new OI();

    new Thread(() -> {
      UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
      camera.setResolution(192, 144);
      
      CvSink cvSink = CameraServer.getInstance().getVideo();
      CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 192, 144);
      
      Mat source = new Mat();
      Mat output = new Mat();
      
      while(!Thread.interrupted()) {
          cvSink.grabFrame(source);
          Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
          outputStream.putFrame(output);
      }
  }).start();
    // m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // // chooser.addOption("My Auto", new MyAutoCommand());
    // SmartDashboard.putData("Auto mode", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
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
    m_cargoArmSubsystem.disabledInit();
    m_hatchPanelIntakeSubsystem.disabledInit();
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
    // m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
     * switch(autoSelected) { case "My Auto": autonomousCommand = new
     * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
     * ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    // if (m_autonomousCommand != null) {
    //   m_autonomousCommand.start();
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
    //   m_autonomousCommand.cancel();
    // }
    logger = Logging.getInstance("TeleopLog");

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
