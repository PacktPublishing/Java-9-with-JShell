import java.time.Year;

public class VirtualCreature {
    public final static int ATTACK_POWER = 45;
    public final static int DEFENSE_POWER = 85;
    public final static int SPECIAL_ATTACK_POWER = 35;
    public final static int SPECIAL_DEFENSE_POWER = 95;
    public final static int AVERAGE_SPEED = 85;
    public final static int CATCH_RATE = 25;
    public final static int GROWTH_RATE = 10;

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
System.out.printf("%d\n", VirtualCreature.SPECIAL_ATTACK_POWER);
System.out.printf("%d\n", VirtualCreature.SPECIAL_DEFENSE_POWER);
VirtualCreature golbat = 
    new VirtualCreature("Golbat", 2015, "Baseball cap", 75);
System.out.printf("%d\n", golbat.GROWTH_RATE);

