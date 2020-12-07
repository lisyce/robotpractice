package org.tahomarobotics.robot.chassis;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.tahomarobotics.robot.RobotMap;

public class Chassis extends Subsystem {

    private static final Chassis INSTANCE = new Chassis();

    private final TalonFX frontLeft = new TalonFX(RobotMap.FRONT_LEFT);
    private final TalonFX backLeft = new TalonFX(RobotMap.BACK_LEFT);
    private final TalonFX frontRight = new TalonFX(RobotMap.FRONT_RIGHT);
    private final TalonFX backRight = new TalonFX(RobotMap.BACK_RIGHT);

    private Chassis() {
        backLeft.follow(frontLeft);
        backRight.follow(frontRight);

        //will the back motors follow this as well?
        frontLeft.setInverted(false);
        frontRight.setInverted(false);
        frontLeft.setNeutralMode(NeutralMode.Brake);
        frontRight.setNeutralMode(NeutralMode.Brake);
    }

    public static Chassis getINSTANCE() {
        return INSTANCE;
    }

    public void setPower(double leftPwr, double rightPwr) {
        frontLeft.set(ControlMode.PercentOutput, leftPwr);
        frontRight.set(ControlMode.PercentOutput, rightPwr);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new TeleopDrive());
    }
}
