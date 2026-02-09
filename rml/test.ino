
#include <PinChangeInt.h>
#include <PinChangeIntConfig.h>
#include <EEPROM.h>
#define _NAMIKI_MOTOR
#include <fuzzy_table.h>
#include <PID_Beta6.h>
#include <MotorWheel.h>
#include <Omni4WD.h>

irqISR(irq1, isr1);
MotorWheel wheel1(3, 2, 4, 5, &irq1);
irqISR(irq2, isr2);
MotorWheel wheel2(11, 12, 14, 15, &irq2);
irqISR(irq3, isr3);
MotorWheel wheel3(9, 8, 16, 17, &irq3);
irqISR(irq4, isr4);
MotorWheel wheel4(10, 7, 18, 19, &irq4);
Omni4WD Omni(&wheel1, &wheel2, &wheel3, &wheel4);

int speed = 30;
long dist_accel;
long delaying;

long senseDistance() {
    long duration;
    pinMode(6, OUTPUT);
    digitalWrite(6, LOW);
    delayMicroseconds(2);
    digitalWrite(6, HIGH);
    delayMicroseconds(5);
    digitalWrite(6, LOW);
    pinMode(6, INPUT);
    duration = pulseIn(6, HIGH);
    delay(100);
    return duration / 29 / 2 * 10;
}

void square() {
    dist_accel = speed * 2.9940119760479043;
    delaying = (167 * (30 - dist_accel));
    Omni.setCarAdvance(speed);
    Omni.setCarSpeedMMPS(speed, 500);
    delay(delaying);
    Omni.setCarSlow2Stop(500);
    delay(500);
	
    dist_accel = speed * 2.9940119760479043;
    delaying = (167 * ((90 * 2.4638813) - dist_accel)) / speed;
    Omni.setCarRotateRight(speed);
    Omni.setCarSpeedMMPS(speed, 500);
    delay(delaying);
    Omni.setCarSlow2Stop(500);
    delay(500);
	
    dist_accel = speed * 2.9940119760479043;
    delaying = (167 * (300 - dist_accel));
    Omni.setCarAdvance(speed);
    Omni.setCarSpeedMMPS(speed, 500);
    delay(delaying);
    Omni.setCarSlow2Stop(500);
    delay(500);
	
    dist_accel = speed * 2.9940119760479043;
    delaying = (167 * ((90 * 2.4638813) - dist_accel)) / speed;
    Omni.setCarRotateRight(speed);
    Omni.setCarSpeedMMPS(speed, 500);
    delay(delaying);
    Omni.setCarSlow2Stop(500);
    delay(500);
	
    dist_accel = speed * 2.9940119760479043;
    delaying = (167 * (30 - dist_accel));
    Omni.setCarAdvance(speed);
    Omni.setCarSpeedMMPS(speed, 500);
    delay(delaying);
    Omni.setCarSlow2Stop(500);
    delay(500);
	
    dist_accel = speed * 2.9940119760479043;
    delaying = (167 * ((90 * 2.4638813) - dist_accel)) / speed;
    Omni.setCarRotateRight(speed);
    Omni.setCarSpeedMMPS(speed, 500);
    delay(delaying);
    Omni.setCarSlow2Stop(500);
    delay(500);
	
    dist_accel = speed * 2.9940119760479043;
    delaying = (167 * (300 - dist_accel));
    Omni.setCarAdvance(speed);
    Omni.setCarSpeedMMPS(speed, 500);
    delay(delaying);
    Omni.setCarSlow2Stop(500);
    delay(500);
	
    dist_accel = speed * 2.9940119760479043;
    delaying = (167 * ((90 * 2.4638813) - dist_accel)) / speed;
    Omni.setCarRotateRight(speed);
    Omni.setCarSpeedMMPS(speed, 500);
    delay(delaying);
    Omni.setCarSlow2Stop(500);
    delay(500);}

void setup() {
    TCCR1B = TCCR1B & 0xf8 | 0x01;
    TCCR2B = TCCR2B & 0xf8 | 0x01;
    Omni.PIDEnable(0.31, 0.01, 0, 10);
}

void loop() {
    speed = 150 / 5;
	long count = 0;
	
    while ((count < 5)) {
        count = (count + 1);
	square();
    }
    while(1); // Stop après exécution
}