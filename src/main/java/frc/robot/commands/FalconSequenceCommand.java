package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.FalconSubsystem;

public class FalconSequenceCommand {
    private final SequentialCommandGroup m_commandGroup;

    public FalconSequenceCommand(FalconSubsystem falconSubsystem, double setpoint) {
        m_commandGroup = new SequentialCommandGroup(
            new WaitCommand(5),
            new MoveToFalconSetpointCommand(falconSubsystem, setpoint)
        );
    }

    public SequentialCommandGroup getCommandGroup() {
        return m_commandGroup;
    }
}