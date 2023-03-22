package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FalconSubsystem extends SubsystemBase {
  private static final double kP = 0.1;
  private static final double kI = 0.0;
  private static final double kD = 0.0;

  private static final double kTolerance = 0.1;

  private static final int kMaxEncoderValue = 1000;
  private static final int kMinEncoderValue = 0;

  private final Talon m_motor;
  private final PIDController m_controller;

  public FalconSubsystem(int motorID) {
    m_motor = new TalonFX(motorID);
    m_controller = new PIDController(kP, kI, kD);
    m_controller.setTolerance(kTolerance);
  }

  public void moveToSetpoint(double setpoint) {
    double output = m_controller.calculate(m_motor.getSelectedSensorPosition(), setpoint);

    if (output > 1.0) {
      output = 1.0;
    } else if (output < -1.0) {
      output = -1.0;
    }

    m_motor.set(output);
  }

  public boolean atSetpoint() {
    return m_controller.atSetpoint();
  }

  @Override
  public void periodic() {
    // Ensure the motor doesn't move past the max and min encoder values
    int currentPosition = m_motor.getSelectedSensorPosition();
    if (currentPosition > kMaxEncoderValue) {
      m_motor.setSelectedSensorPosition(kMaxEncoderValue);
    } else if (currentPosition < kMinEncoderValue) {
      m_motor.setSelectedSensorPosition(kMinEncoderValue);
    }
  }
}
