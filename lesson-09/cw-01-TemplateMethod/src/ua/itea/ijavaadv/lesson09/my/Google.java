package ua.itea.ijavaadv.lesson09.my;

import ua.itea.ijavaadv.lesson09.external.google.GooglePhoneFunctions;

/**
 * Created
 * at 19:15
 * on 23.02.17
 * by Iurii Derevianko;
 */
public class Google extends Phone {
    @Override
    public void turnOn() {
        GooglePhoneFunctions.turnOn();
    }

    @Override
    public void turnOff() {
        GooglePhoneFunctions.turnOff();
    }

    @Override
    public void openGmail() {
        GooglePhoneFunctions.openGmail();
    }

    @Override
    public void openVoiceRec() {
        GooglePhoneFunctions.openVoiceRec();
    }
}
