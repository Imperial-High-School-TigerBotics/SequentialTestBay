package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.FalconSubsystem;

public class FalconSequenceCommand {
    private final SequentialCommandGroup m_commandGroup;

    public FalconSequenceCommand(FalconSubsystem falconSubsystem, double setpoint) {
        m_commandGroup = new SequentialCommandGroup(
            new MoveToFalconSetpointCommand(falconSubsystem, setpoint).withTimeout(5),
            new FalconStopCommand(falconSubsystem)
        );
    }

    public SequentialCommandGroup getCommandGroup() {
        return m_commandGroup;
    }
}
