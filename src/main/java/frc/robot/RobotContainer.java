public class RobotContainer {
  private final Joystick joystick = new Joystick(Constants.JOYSTICK_PORT);
  private final FalconSubsystem falconSubsystem = new FalconSubsystem();
  private final ExampleCommandGroup exampleCommandGroup = new ExampleCommandGroup(falconSubsystem);

  public RobotContainer() {
      configureButtonBindings();
  }

  private void configureButtonBindings() {
      JoystickButton button = new JoystickButton(joystick, Constants.BUTTON_ID);
      button.whenPressed(exampleCommandGroup);
  }
}
