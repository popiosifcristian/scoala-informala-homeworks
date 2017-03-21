/** This is our main class where we will have the main and where we will create our objects
 * @author Pop Iosif Cristian
 */
public class House {
    public static void main(String[] args) {
        SamsungSmartFridge fridge = new SamsungSmartFridge("SN-SMSG009");
        float consumption=fridge.getConsumption();
        System.out.println("Consumption after creating the fridge is "+consumption+" w");
        fridge.start();
        consumption=fridge.getConsumption();
        System.out.println("Consumption after starting the fridge is "+ consumption+" w");
        fridge.superFreezer();
        consumption=fridge.getConsumption();
        System.out.println("Consumption after starting the super freezer function is "+ consumption+" w");
        IRobotVacuum600Series IRobot = new IRobotVacuum600Series("SN-IR007");

        IRobotVacuum someVacum = (IRobotVacuum) IRobot;
        System.out.println("Consumption after creating the vacum is "+someVacum.getConsumption()+" w");
        someVacum.start();
        System.out.println("Consumption after starting the vacum is "+someVacum.getConsumption()+" w");
        someVacum.cleanPetHair();
        System.out.println("Consumption of the vacum after starting the clean pet hair is "+someVacum.getConsumption()+" w");

        AppleMac mac=new AppleMac("MAC-PRO013");
        mac.start();
        System.out.println("Consumption after creating the mac is "+mac.getConsumption()+" w");
        mac.musicPlayer();
        System.out.println("Consumption of the mac after starting the music player is "+mac.getConsumption()+" w");
        BoshBlender someBlender=new BoshBlender("BB-PRO112");
        someBlender.start();
        System.out.println("Consumption after creating the blender is "+someBlender.getConsumption()+" w");
        someBlender.superFastFunction();
        System.out.println("Consumption of the blender after starting the super fast function is "+someBlender.getConsumption()+" w");


    }
}