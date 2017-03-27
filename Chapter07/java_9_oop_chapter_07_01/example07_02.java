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

public abstract class VirtualDomesticMammal extends VirtualMammal {
    public final String name;
    public String favoriteToy;

    public VirtualDomesticMammal(
        int age, 
        boolean isPregnant, 
        String name, 
        String favoriteToy) {
        super(age, isPregnant);
        this.name = name;
        this.favoriteToy = favoriteToy;
        System.out.println("VirtualDomesticMammal created.");
    }

    public VirtualDomesticMammal(
        int age, String name, String favoriteToy) {
        this(age, false, name, favoriteToy);
    }

    protected final void printSoundInWords(
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
        System.out.println("VirtualHorse created.");        
    }

    public VirtualHorse(
        int age, String name, String favoriteToy) {
        this(age, false, name, favoriteToy);
    }

    public final boolean isAbleToFly() {
        return false;
    }

    public final boolean isRideable() {
        return true;
    }

    public final boolean isHerbivore() {
        return true;
    }

    public final boolean isCarnivore() {
        return false;
    }

    public int getAverageNumberOfBabies() {
        return 1;
    }

    public abstract String getBreed();

    public final void printBreed() {
        System.out.println(getBreed());
    }

    public final void printNeigh(
        int times, 
        VirtualDomesticMammal otherDomesticMammal,
        boolean isAngry) {
        printSoundInWords("Neigh ", times, otherDomesticMammal, isAngry);
    }

    public final void neigh() {
        printNeigh(1, null, false);
    }

    public final void neigh(int times) {
        printNeigh(times, null, false);
    }

    public final void neigh(int times, 
        VirtualDomesticMammal otherDomesticMammal) {
        printNeigh(times, otherDomesticMammal, false);
    }

    public final void neigh(int times, 
        VirtualDomesticMammal otherDomesticMammal, 
        boolean isAngry) {
        printNeigh(times, otherDomesticMammal, isAngry);
    }

    public final void printNicker(int times, 
        VirtualDomesticMammal otherDomesticMammal,
        boolean isAngry) {
        printSoundInWords("Nicker ", times, otherDomesticMammal, isAngry);
    }

    public final void nicker() {
        printNicker(1, null, false);
    }

    public final void nicker(int times) {
        printNicker(times, null, false);
    }

    public final void nicker(int times, 
        VirtualDomesticMammal otherDomesticMammal) {
        printNicker(times, otherDomesticMammal, false);
    }

    public final void nicker(int times, 
        VirtualDomesticMammal otherDomesticMammal, 
        boolean isAngry) {
        printNicker(times, otherDomesticMammal, isAngry);
    }

    @Override
    public final void talk() {
        nicker();
    }
}

public abstract class VirtualDomesticCat extends VirtualDomesticMammal {
    public VirtualDomesticCat(
        int age, 
        boolean isPregnant, 
        String name, 
        String favoriteToy) {
        super(age, isPregnant, name, favoriteToy);
        System.out.println("VirtualDomesticCat created.");        
    }

    public VirtualDomesticCat(
        int age, String name, String favoriteToy) {
        this(age, false, name, favoriteToy);
    }

    public final boolean isAbleToFly() {
        return false;
    }

    public final boolean isRideable() {
        return false;
    }

    public final boolean isHerbivore() {
        return false;
    }

    public final boolean isCarnivore() {
        return true;
    }

    public int getAverageNumberOfBabies() {
        return 5;
    }

public final void printMeow(int times) {
        printSoundInWords("Meow ", times, null, false);
    }

    @Override
    public final void talk() {
        printMeow(1);
    }
}

public final class MaineCoon extends VirtualDomesticCat {
    public MaineCoon(
        int age, 
        boolean isPregnant, 
        String name, 
        String favoriteToy) {
        super(age, isPregnant, name, favoriteToy);
        System.out.println("MaineCoon created.");        
    }

    public MaineCoon(
        int age, String name, String favoriteToy) {
        this(age, false, name, favoriteToy);
    }

    public String getBaby() {
        return "Maine Coon baby ";
    }

    @Override
    public int getAverageNumberOfBabies() {
        return 6;
    }

    public String getAsciiArt() {
        return
            "  ^_^\n" + 
            " (*.*)\n" +
            "  |-|\n" +
            " /   \\\n";
    }
}

public abstract class VirtualBird extends VirtualAnimal {
    public String feathersColor;

    public VirtualBird(int age, String feathersColor) {
        super(age);
        this.feathersColor = feathersColor;
        System.out.println("VirtualBird created.");
    }

    public final boolean isAbleToFly() {
        // Not all birds are able to fly in real-life
        // However, all our virtual birds are able to fly
        return true;
    }

}

public abstract class VirtualDomesticBird extends VirtualBird {
    public final String name;

    public VirtualDomesticBird(int age, 
        String feathersColor, 
        String name) {
        super(age, feathersColor);
        this.name = name;
        System.out.println("VirtualDomesticBird created.");
    }
}

public final class Cockatiel extends VirtualDomesticBird {
    public Cockatiel(int age, 
        String feathersColor, String name) {
        super(age, feathersColor, name);
        System.out.println("Cockatiel created.");
    }

    public boolean isRideable() {
        return true;
    }

    public boolean isHerbivore() {
        return true;
    }

    public boolean isCarnivore() {
        return true;
    }

    public int getAverageNumberOfBabies() {
        return 4;
    }

    public String getBaby() {
        return "Cockatiel baby ";
    }

    public String getAsciiArt() {
        return
            "     ///\n" +
            "      .////.\n" +
            "      //   //\n" +
            "      \\ (*)\\\n" +
            "      (/    \\\n" +
            "       /\\    \\\n" +
            "      ///     \\\\\n" +
            "     ///|     |\n" +
            "    ////|     |\n" +
            "   //////    /\n" +
            "  ////  \\   \\\n" +
            "  \\\\    ^    ^\n" +
            "   \\\n" +
            "    \\\n";
    }
}

public final class VirtualDomesticRabbit extends VirtualDomesticMammal {
    public VirtualDomesticRabbit(
        int age, 
        boolean isPregnant, 
        String name, 
        String favoriteToy) {
        super(age, isPregnant, name, favoriteToy);
        System.out.println("VirtualDomesticRabbit created.");        
    }

    public VirtualDomesticRabbit(
        int age, String name, String favoriteToy) {
        this(age, false, name, favoriteToy);
    }

    public final boolean isAbleToFly() {
        return false;
    }

    public final boolean isRideable() {
        return false;
    }

    public final boolean isHerbivore() {
        return true;
    }

    public final boolean isCarnivore() {
        return false;
    }

    public int getAverageNumberOfBabies() {
        return 6;
    }

    public String getBaby() {
        return "Rabbit baby ";
    }

    public String getAsciiArt() {
        return
            "   /\\ /\\\n" + 
            "   \\ V /\n" + 
            "   | **)\n" + 
            "   /  /\n" + 
            "  /  \\_\\_\n" + 
            "*(__\\_\\\n";
    }
}

void printBabies(VirtualAnimal animal) {
    animal.printAverageNumberOfBabies();
}

void printAsciiArt(VirtualAnimal animal) {
    animal.printAsciiArt();
}


Cockatiel tweety = 
    new Cockatiel(3, "White", "Tweety");
VirtualDomesticRabbit bunny = 
    new VirtualDomesticRabbit(2, "Bunny", "Sneakers");
MaineCoon garfield = 
    new MaineCoon(3, "Garfield", "Lassagna");

System.out.println(tweety.name);
printBabies(tweety);
printAsciiArt(tweety);

System.out.println(bunny.name);
printBabies(bunny);
printAsciiArt(bunny);

System.out.println(garfield.name);
printBabies(garfield);
printAsciiArt(garfield);

void makeItTalk(VirtualDomesticMammal domestic) {
    domestic.talk();
}

makeItTalk(bunny);
makeItTalk(garfield);

tweety.printAge();
bunny.printAge();
garfield.printAge();
tweety.isOlderThan(bunny);
garfield.isYoungerThan(tweety);
bunny.isYoungerThan(garfield);

