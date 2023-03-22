package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.FalconSequenceCommand;
import frc.robot.commands.MoveToFalconSetpointCommand;
import frc.robot.subsystems.FalconSubsystem;

public class RobotContainer {
    private final Joystick m_driverController = new Joystick(0);
    private final FalconSubsystem m_falconSubsystem = new FalconSubsystem(1);

    public RobotContainer() {
        configureButtonBindings();
    }

    private void configureButtonBindings() {
        JoystickButton moveToFalconSetpointButton = new JoystickButton(m_driverController, 2);
        moveToFalconSetpointButton.onTrue(new FalconSequenceCommand(m_falconSubsystem, 10000).getCommandGroup());
    }

    public Command getAutonomousCommand() {
        return null;
    }
}
