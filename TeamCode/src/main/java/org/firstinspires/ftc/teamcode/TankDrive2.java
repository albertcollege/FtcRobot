package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp(name = "TankDrive2", group = "TeleOp2")
public class TankDrive2 extends OpMode {

    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private DcMotor topMotor;


    @Override
    public void init() {
        leftMotor = hardwareMap.get(DcMotor.class, "left");
        rightMotor = hardwareMap.get(DcMotor.class, "right");
        topMotor = hardwareMap.get(DcMotor.class, "top");
    }

    @Override
    public void loop() {
        // --- Drive Motors ---
        double drive = -gamepad1.left_stick_y;
        double turn = -gamepad1.left_stick_x;

        double leftPower = drive + turn;
        double rightPower = drive - turn;

        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);

        double max = Math.max (Math. abs(leftPower), Math.abs(rightPower));


        // --- Top Motor Control ---
        double topPower = 0.1; // Default power is 0.1

        if (gamepad1.dpad_up) {
            topPower = 0.4;
        } else if (gamepad1.dpad_down) {
            topPower = -0.4;
        }
        // If neither is pressed, topPower remains 0.0 as set initially

        // Actually command the top motor
        topMotor.setPower(topPower);

        // --- Telemetry (Optional but Recommended) ---
        telemetry.addData("Left Stick Y", gamepad1.left_stick_y);
        telemetry.addData("Right Stick Y", gamepad1.right_stick_y);
        telemetry.addData("Dpad Up", gamepad1.dpad_up);
        telemetry.addData("Dpad Down", gamepad1.dpad_down);
        telemetry.addData("Power", drive);
        telemetry.addData("Top Power", topPower);
        telemetry.update();
    }
}

