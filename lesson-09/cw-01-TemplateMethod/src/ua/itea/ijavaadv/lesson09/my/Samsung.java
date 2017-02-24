package ua.itea.ijavaadv.lesson09.my;

import ua.itea.ijavaadv.lesson09.external.samsung.SamsungPhoneFunctions;

/**
 * Created
 * at 19:14
 * on 23.02.17
 * by Iurii Derevianko;
 */
public class Samsung extends Phone {
    @Override
    public void turnOn() {
        SamsungPhoneFunctions.turnOn();
    }

    @Override
    public void turnOff() {
        SamsungPhoneFunctions.turnOff();
    }

    @Override
    public void openGmail() {
        SamsungPhoneFunctions.openGmail();
    }

    @Override
    public void openVoiceRec() {
        SamsungPhoneFunctions.openVoiceRec();
    }
}
