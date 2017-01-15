package org.usfirst.frc.team2846.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Simple program for testing the navX-MXP Board on our robot.
 * The navX values will be displayed on the SmartDashboard while the
 * robot is enabled.
 */
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
		navXBoard.reset();
		SmartDashboard.putString("angle", navXBoard.getFirmwareVersion());
	}
	
	@Override
	public void teleopPeriodic() {
		SmartDashboard.putNumber("navX.angle", navXBoard.getAngle());
		SmartDashboard.putNumber("navX.compass", navXBoard.getCompassHeading());
		SmartDashboard.putNumber("navX.pitch", navXBoard.getPitch());
		SmartDashboard.putNumber("navX.roll", navXBoard.getRoll());
		SmartDashboard.putNumber("navX.yaw", navXBoard.getYaw());
		SmartDashboard.putNumber("navX.DisplacementX", navXBoard.getDisplacementX());
		SmartDashboard.putNumber("navX.DisplacementY", navXBoard.getDisplacementY());
		SmartDashboard.putNumber("navX.DisplacementZ", navXBoard.getDisplacementZ());
		SmartDashboard.putNumber("navX.VelocityX", navXBoard.getVelocityX());
		SmartDashboard.putNumber("navX.VelocityY", navXBoard.getVelocityY());
		SmartDashboard.putNumber("navX.VelocityZ", navXBoard.getVelocityZ());
		SmartDashboard.putBoolean("navX.isConnected", navXBoard.isConnected());
		SmartDashboard.putBoolean("navX.isMoving", navXBoard.isMoving());
		SmartDashboard.putBoolean("navX.isRotating", navXBoard.isRotating());
		
	}

	@Override
	public void testPeriodic() {
	}
}
