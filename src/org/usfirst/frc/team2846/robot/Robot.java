package org.usfirst.frc.team2846.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static AHRS navXBoard;

	@Override
	public void robotInit() {
		try {
			navXBoard = new AHRS(SPI.Port.kMXP);
		} catch (RuntimeException ex) {
			DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
		}
	}

	@Override
	public void autonomousInit() {

	}

	@Override
	public void autonomousPeriodic() {

	}

	@Override
	public void teleopInit() {
		SmartDashboard.putString("angle", navXBoard.getFirmwareVersion());
	}
	
	@Override
	public void teleopPeriodic() {
		SmartDashboard.putNumber("angle", navXBoard.getAngle());
		SmartDashboard.putNumber("compass", navXBoard.getCompassHeading());
		SmartDashboard.putNumber("pitch", navXBoard.getPitch());
		SmartDashboard.putNumber("roll", navXBoard.getRoll());
		SmartDashboard.putNumber("yaw", navXBoard.getYaw());
	}

	@Override
	public void testPeriodic() {
	}
}
