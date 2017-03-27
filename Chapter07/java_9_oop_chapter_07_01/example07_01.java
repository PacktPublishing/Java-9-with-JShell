public abstract class VirtualAnimal {
    public final int age;

    public VirtualAnimal(int age) {
        this.age = age;
        System.out.println("VirtualAnimal created.");
    }

    public abstract boolean isAbleToFly();

    public abstract boolean isRideable();

    public abstract boolean isHerbivore();

    public abstract boolean isCarnivore();

    public abstract int getAverageNumberOfBabies();

    public abstract String getBaby();

    public abstract String getAsciiArt();

    public void printAsciiArt() {
        System.out.println(getAsciiArt());
    }

    public void printAverageNumberOfBabies() {
        System.out.println(new String(
            new char[getAverageNumberOfBabies()]).replace(
                "\0", getBaby()));
    }

    public void printAge() {
        System.out.println(
            String.format("I am %d years old", age));
    }

    public boolean isYoungerThan(VirtualAnimal otherAnimal) {
        return age < otherAnimal.age; 
    }

    public boolean isOlderThan(VirtualAnimal otherAnimal) {
        return age > otherAnimal.age;
    }
}

public abstract class VirtualMammal extends VirtualAnimal {
    public boolean isPregnant;

    public VirtualMammal(int age, boolean isPregnant) {
        super(age);
        this.isPregnant = isPregnant;
        System.out.println("VirtualMammal created.");
    }

    public VirtualMammal(int age) {
        this(age, false);
    }
}

public abstract class VirtualDomesticMammal extends VirtualMammal {
    public final String name;
    public String favoriteToy;

    public VirtualDomesticMammal(
        int age, 
        boolean isPregnant, 
        String name, 
        String favoriteToy  ) {
        super(age, isPregnant);
        this.name = name;
        this.favoriteToy = favoriteToy;
        System.out.println("VirtualDomesticMammal created.");
    }

    public VirtualDomesticMammal(
        int age, 
        String name, 
        String favoriteToy) {
        this(age, false, name, favoriteToy);
    }

    public void talk() {
        System.out.println(
            String.format("%s: says something", name));
    }
}

public abstract class VirtualHorse extends VirtualDomesticMammal {
    public VirtualHorse(
        int age, 
        boolean isPregnant, 
        String name, 
        String favoriteToy) {
        super(age, isPregnant, name, favoriteToy);
        System.out.println("VirtualHouse created.");        
    }

    public VirtualHorse(
        int age, 
        String name, 
        String favoriteToy) {
        this(age, false, name, favoriteToy);
    }

    public boolean isAbleToFly() {
        return false;
    }

    public boolean isRideable() {
        return true;
    }

    public boolean isHerbivore() {
        return true;
    }

    public boolean isCarnivore() {
        return false;
    }

    public int getAverageNumberOfBabies() {
        return 1;
    }

    public abstract String getBreed();

    public void printBreed() {
        System.out.println(getBreed());
    }

    protected void printSoundInWords(
        String soundInWords, 
        int times, 
        VirtualDomesticMammal otherDomesticMammal,
        boolean isAngry) {
        String message = String.format("%s%s: %s%s",
            name,
            otherDomesticMammal == null ? 
                "" : String.format(" to %s ", otherDomesticMammal.name),
            isAngry ?
                "Angry " : "",
            new String(new char[times]).replace("\0", soundInWords));
        System.out.println(message);
    }

    public void printNeigh(int times, 
        VirtualDomesticMammal otherDomesticMammal,
        boolean isAngry) {
        printSoundInWords("Neigh ", times, otherDomesticMammal, isAngry);
    }

    public void neigh() {
        printNeigh(1, null, false);
    }

    public void neigh(int times) {
        printNeigh(times, null, false);
    }

    public void neigh(int times, 
        VirtualDomesticMammal otherDomesticMammal) {
        printNeigh(times, otherDomesticMammal, false);
    }

    public void neigh(int times, 
        VirtualDomesticMammal otherDomesticMammal, 
        boolean isAngry) {
        printNeigh(times, otherDomesticMammal, isAngry);
    }

    public void printNicker(int times, 
        VirtualDomesticMammal otherDomesticMammal,
        boolean isAngry) {
        printSoundInWords("Nicker ", times, otherDomesticMammal, isAngry);
    }

    public void nicker() {
        printNicker(1, null, false);
    }

    public void nicker(int times) {
        printNicker(times, null, false);
    }

    public void nicker(int times, 
        VirtualDomesticMammal otherDomesticMammal) {
        printNicker(times, otherDomesticMammal, false);
    }

    public void nicker(int times, 
        VirtualDomesticMammal otherDomesticMammal, 
        boolean isAngry) {
        printNicker(times, otherDomesticMammal, isAngry);
    }

    @Override
    public void talk() {
        nicker();
    }
}

public class AmericanQuarterHorse extends VirtualHorse {
    public AmericanQuarterHorse(
        int age, 
        boolean isPregnant, 
        String name, 
        String favoriteToy  ) {
        super(age, isPregnant, name, favoriteToy);
        System.out.println("AmericanQuarterHorse created.");
    }

    public AmericanQuarterHorse(
        int age, String name, String favoriteToy) {
        this(age, false, name, favoriteToy);
    }

    public String getBaby() {
        return "AQH baby ";
    }

    public String getBreed() {
        return "American Quarter Horse";
    }

    public String getAsciiArt() {
        return
            "     >>\\.\n" +
            "    /*  )`.\n" + 
            "   // _)`^)`.   _.---. _\n" +
            "  (_,' \\  `^-)''      `.\\\n" +
            "        |              | \\\n" +
            "        \\              / |\n" +
            "       / \\  /.___.'\\  (\\ (_\n" +
            "      < ,'||     \\ |`. \\`-'\n" +
            "       \\\\ ()      )|  )/\n" +
            "       |_>|>     /_] //\n" +
            "         /_]        /_]\n";
    }
}

public class ShireHorse extends VirtualHorse {
    public ShireHorse(
        int age, 
        boolean isPregnant, 
        String name, 
        String favoriteToy) {
        super(age, isPregnant, name, favoriteToy);
        System.out.println("ShireHorse created.");
    }

    public ShireHorse(
        int age, String name, String favoriteToy) {
        this(age, false, name, favoriteToy);
    }

    public String getBaby() {
        return "ShireHorse baby ";
    }

    public String getBreed() {
        return "Shire Horse";
    }

    public String getAsciiArt() {
        return
            "                        ;;\n" + 
            "                      .;;'*\\\n" + 
            "           __       .;;' ' \\\n" +
            "         /'  '\\.~~.~' \\ /'\\.)\n" +
            "      ,;(      )    /  |\n" + 
            "     ,;' \\    /-.,,(   )\n" +
            "          ) /|      ) /|\n" +    
            "          ||(_\\     ||(_\\\n" +    
            "          (_\\       (_\\\n";
    }
}

public class Thoroughbred extends VirtualHorse {
    public Thoroughbred(
        int age, 
        boolean isPregnant, 
        String name, 
        String favoriteToy) {
        super(age, isPregnant, name, favoriteToy);
        System.out.println("Thoroughbred created.");
    }

    public Thoroughbred(
        int age, String name, String favoriteToy) {
        this(age, false, name, favoriteToy);
    }

    public String getBaby() {
        return "Thoroughbred baby ";
    }

    public String getBreed() {
        return "Thoroughbred";
    }

    public String getAsciiArt() {
        return
            "             })\\-=--.\n" +  
            "            // *._.-'\n" +
            "   _.-=-...-'  /\n" +
            " {{|   ,       |\n" +
            " {{\\    |  \\  /_\n" +
            " }} \\ ,'---'\\___\\\n" +
            " /  )/\\\\     \\\\ >\\\n" +
            "   //  >\\     >\\`-\n" +
            "  `-   `-     `-\n";
    }
}

AmericanQuarterHorse american = 
    new AmericanQuarterHorse(
        8, "American", "Equi-Spirit Ball");
american.printBreed();

System.out.println(american instanceof VirtualAnimal);
System.out.println(american instanceof VirtualMammal);
System.out.println(american instanceof VirtualDomesticMammal);
System.out.println(american instanceof VirtualHorse);
System.out.println(american instanceof AmericanQuarterHorse);

ShireHorse zelda =
    new ShireHorse(9, true, 
        "Zelda", "Tennis Ball");

american.printAverageNumberOfBabies();
american.printAsciiArt();
zelda.printAverageNumberOfBabies();
zelda.printAsciiArt();

Thoroughbred willow = 
    new Thoroughbred(5,
        "Willow", "Jolly Ball");
willow.printAsciiArt();

willow.neigh();
willow.neigh(2);
willow.neigh(2, american);
willow.neigh(3, zelda, true);
american.nicker();
american.nicker(2);
american.nicker(2, willow);
american.nicker(3, willow, true);



