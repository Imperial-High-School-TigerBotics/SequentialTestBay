import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class FalconSequenceCommand extends SequentialCommandGroup {
  private final FalconSubsystem m_falconSubsystem;

  public FalconSequenceCommand(FalconSubsystem falconSubsystem, double setpoint) {
    m_falconSubsystem = falconSubsystem;

    addCommands(
      new MoveToFalconSetpointCommand(falconSubsystem, setpoint)
    );
  }

  @Override
  public void end(boolean interrupted) {
    // Stop the Falcon motor when the command is finished or interrupted
    m_falconSubsystem.stopMotor();
  }
}
