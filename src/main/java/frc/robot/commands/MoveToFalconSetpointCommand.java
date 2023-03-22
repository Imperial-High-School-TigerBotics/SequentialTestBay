package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FalconSubsystem;

public class MoveToFalconSetpointCommand extends CommandBase {
  private final FalconSubsystem m_falconSubsystem;
  private final double m_setpoint;

  public MoveToFalconSetpointCommand(FalconSubsystem falconSubsystem, double setpoint) {
    m_falconSubsystem = falconSubsystem;
    m_setpoint = setpoint;

    addRequirements(falconSubsystem);
  }

  @Override
  public void initialize() {
    m_falconSubsystem.moveToSetpoint(m_setpoint);
  }

  @Override
  public boolean isFinished() {
    return m_falconSubsystem.atSetpoint();
  }
}
