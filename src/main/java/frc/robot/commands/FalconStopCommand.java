package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FalconSubsystem;

public class FalconStopCommand extends CommandBase {
  private final FalconSubsystem m_falconSubsystem;

  public FalconStopCommand(FalconSubsystem falconSubsystem) {
    m_falconSubsystem = falconSubsystem;

    addRequirements(falconSubsystem);
  }

  @Override
  public void initialize() {
    m_falconSubsystem.stopMotor();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
