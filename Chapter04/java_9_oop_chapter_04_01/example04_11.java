import java.time.Year;

public class VirtualCreature {
    public static int getAttackPower() {
        return 45;
    }

    public static int getDefensePower() {
        return 85;
    }
    
    public static int getSpecialAttackPower() {
        return 35;
    }

    public static int getSpecialDefensePower() {
        return 95;
    }

    public static int getAverageSpeed() {
        return 85;
    }

    public static int getCatchRate() {
        return 25;
    }

    public static int getGrowthRate() {
        return 10;
    }

    public final String name;
    private int birthYear;
    private String hat = "NONE";
    private int visibilityLevel;

    VirtualCreature(String name, int birthYear, String hat, int visibilityLevel) {
        this.name = name;
        this.birthYear = birthYear;
        setHat(hat);
        setVisibilityLevel(visibilityLevel);
    }

    private int getCurrentYear() {
        return Year.now().getValue();
    }

    public int getAge() {
        return getCurrentYear() - birthYear;
    }

    public void setAge(final int age) {
        birthYear = getCurrentYear() - age;
    }

    public String getHat() {
        return hat;
    }

    public void setHat(final String hat) {
        this.hat = hat.toUpperCase();
    }

    public int getVisibilityLevel() {
        return visibilityLevel;
    }

    public void setVisibilityLevel(final int visibilityLevel) {
        this.visibilityLevel = 
            Math.min(Math.max(visibilityLevel, 0), 100);
    }
}
System.out.printf("%d\n", VirtualCreature.getSpecialAttackPower());
System.out.printf("%d\n", VirtualCreature.getSpecialDefensePower());
VirtualCreature vulpix = 
    new VirtualCreature("Vulpix", 2012, "Fedora", 35);
System.out.printf("%d", vulpix.getGrowthRate())

