package ua.itea.ijavaadv.lesson09.my;

/**
 * Created
 * at 19:06
 * on 23.02.17
 * by Iurii Derevianko;
 *
 * Template Method;
 */
public abstract class Phone {

    abstract void turnOn();
    abstract void turnOff();
    abstract void openGmail();
    abstract void openVoiceRec();

    void sendVoiceMessageViaGmail() {
        System.out.println("sendVoiceMessageViaGmail turn ON;");
    }

}
