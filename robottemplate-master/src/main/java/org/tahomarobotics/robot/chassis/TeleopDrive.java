package org.tahomarobotics.robot.chassis;

import edu.wpi.first.wpilibj.command.Command;
import org.tahomarobotics.robot.Oi;

public class TeleopDrive extends Command {

    private static final Oi oi = Oi.getINSTANCE();
    private static final Chassis chassis = Chassis.getINSTANCE();

    public TeleopDrive() {
        requires(Chassis.getINSTANCE());
    }

    //continuously set left and right drive power to readout from joysticks
    @Override
    protected void execute() {
        double leftPwr = oi.getLeftDrivePwr();
        double rightPwr = oi.getRightDrivePwr();
        chassis.setPower(leftPwr, rightPwr);
    }

    //set robot to 0 power (rn this will have the brakes applied) when the command finishes (which is never rn)
    @Override
    protected void end() {
        chassis.setPower(0d, 0d);
    }

    //Will run forever, not sure what conditions to stop on
    @Override
    protected boolean isFinished() {
        return false;
    }
}
