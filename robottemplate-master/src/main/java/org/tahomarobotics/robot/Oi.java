package org.tahomarobotics.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

public class Oi {

    private static final Oi INSTANCE = new Oi();
    private static final XboxController driveController = new XboxController(0);
    //not yet in use
    private static final XboxController manipController = new XboxController(1);

    //Just used the numbers given, not quite if it's implemented correctly
    private static final double DEADBAND = 3d/125;

    public static Oi getINSTANCE() {
        return INSTANCE;
    }

    private Oi() {}

    private double calcWithDeadband(double controllerInput) {
        if(controllerInput > DEADBAND || controllerInput < (-1*DEADBAND)) return controllerInput;
        else return 0d;
    }

    public double getLeftDrivePwr() {
        double controllerLeftY = driveController.getY(GenericHID.Hand.kLeft);
        return calcWithDeadband(controllerLeftY);
    }

    public double getRightDrivePwr() {
        double controllerRightY = driveController.getY(GenericHID.Hand.kRight);
        return calcWithDeadband(controllerRightY);
    }

}
