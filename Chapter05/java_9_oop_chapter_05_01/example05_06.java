import java.time.Year;

public class ImmutableVirtualCreature {
    public final String name;
    public final int birthYear;
    public final String hat;
    public final int visibilityLevel;

    ImmutableVirtualCreature(final String name, int birthYear, String hat, int visibilityLevel) {
        this.name = name;
        this.birthYear = birthYear;
        this.hat = hat.toUpperCase();
        this.visibilityLevel = 
            getValidVisibilityLevel(visibilityLevel);
    }

    private int getCurrentYear() {
        return Year.now().getValue();
    }

    private int getValidVisibilityLevel(int levelToValidate) {
        return Math.min(Math.max(levelToValidate, 0), 100);
    }

    public int getAge() {
        return getCurrentYear() - birthYear;
    }

    public ImmutableVirtualCreature evolveToAge(int age) {
        int newBirthYear = getCurrentYear() - age;
        return new ImmutableVirtualCreature(
            name,
            newBirthYear,
            hat,
            visibilityLevel);
    }

    public ImmutableVirtualCreature evolveToVisibilityLevel(
        final int visibilityLevel) {
        int newVisibilityLevel =
            getValidVisibilityLevel(visibilityLevel);
        return new ImmutableVirtualCreature(
            name,
            birthYear,
            hat,
            newVisibilityLevel);
    }
}

ImmutableVirtualCreature meowth1 =
    new ImmutableVirtualCreature(
        "Meowth", 2010, "Baseball cap", 35);
ImmutableVirtualCreature meowth2 = 
    meowth1.evolveToAge(3);
System.out.printf("%d\n", meowth2.getAge());
ImmutableVirtualCreature meowth3 = 
    meowth2.evolveToVisibilityLevel(25);
System.out.printf("%d\n", meowth3.visibilityLevel);

