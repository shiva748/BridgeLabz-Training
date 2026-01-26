
@FunctionalInterface
interface LightAction {

    void activate();
}

public class SmartHomeLightingAutomation {

    public static void main(String[] args) {

        LightAction motionTrigger = () -> System.out.println("Motion detected → Lights ON at full brightness");

        LightAction nightTimeTrigger = () -> System.out.println("Night time → Dim lights to 30%");

        LightAction voiceCommandTrigger = () -> System.out.println("Voice command → Turn ON bedroom lights");

        System.out.println("--- Smart Home Lighting System ---");

        runTrigger("Motion Sensor", motionTrigger);
        runTrigger("Time Schedule", nightTimeTrigger);
        runTrigger("Voice Assistant", voiceCommandTrigger);
    }

    private static void runTrigger(String triggerName, LightAction action) {
        System.out.print(triggerName + " → ");
        action.activate();
    }
}
