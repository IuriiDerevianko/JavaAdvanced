package ua.itea.ijavaadv.lesson09.my;

import ua.itea.ijavaadv.lesson09.external.apple.ApplePhoneFunctions;

/**
 * Created
 * at 19:16
 * on 23.02.17
 * by Iurii Derevianko;
 */
public class Apple extends Phone {

    @Override
    public void turnOn() {
        ApplePhoneFunctions.turnOn();
    }

    @Override
    public void turnOff() {
        ApplePhoneFunctions.turnOff();
    }

    @Override
    public void openGmail() {
        ApplePhoneFunctions.openGmail();
    }

    @Override
    public void openVoiceRec() {
        ApplePhoneFunctions.openVoiceRec();
    }
}
