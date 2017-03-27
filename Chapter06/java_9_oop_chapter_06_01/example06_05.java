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



