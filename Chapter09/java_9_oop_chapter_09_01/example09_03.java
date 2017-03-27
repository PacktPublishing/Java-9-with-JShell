public interface DrawableInComic {
    String getNickName();
    void drawSpeechBalloon(String message);
    void drawSpeechBalloon(DrawableInComic destination, String message);
    void drawThoughtBalloon(String message);
}

public interface DrawableInGame {
    String getFullName();
    int getScore();
    int getX();
    int getY();
    void setLocation(int x, int y);
    void draw();
    boolean isIntersectingWith(DrawableInGame otherDrawableInGame);
}

public interface Hideable {
    int getNumberOfEyes();
    void show();
    void hide();
}

public interface Powerable {
    int getSpellPower();
    void useSpellToHide(Hideable hideable);
}

public interface Fightable {
    int getSwordPower();
    int getSwordWeight();
    void unsheathSword();
    void unsheathSword(Hideable hideable);
}

public class SpiderDog implements DrawableInComic {
    protected final String nickName;

    public SpiderDog(String nickName) {
        this.nickName = nickName;
    }

    protected void speak(String message) {
        System.out.println(
            String.format("%s -> %s",
                nickName,
                message));
    }

    protected void think(String message) {
        System.out.println(
            String.format("%s -> ***%s***",
                nickName,
                message));
    }

    @Override
    public String getNickName() {
        return nickName;
    }

    @Override
    public void drawSpeechBalloon(String message) {
        speak(message);
    }

    @Override
    public void drawSpeechBalloon(DrawableInComic destination, 
        String message) {
        speak(String.format("message: %s, %s",
            destination.getNickName(),
            message));
    }

    @Override
    public void drawThoughtBalloon(String message) {
        think(message);
    }
}

public class WonderCat implements DrawableInComic {
    protected final String nickName;
    protected final int age;

    public WonderCat(String nickName, int age) {
        this.nickName = nickName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String getNickName() {
        return nickName;
    }

    @Override
    public void drawSpeechBalloon(String message) {
        String meow = 
            (age > 2) ? "Meow" : "Meeoow Meeoow";
        System.out.println(
            String.format("%s -> %s",
                nickName,
                meow));
    }

    @Override
    public void drawSpeechBalloon(DrawableInComic destination, 
        String message) {
        System.out.println(
            String.format("%s ==> %s --> %s",
                destination.getNickName(),
                nickName,
                message));
    }

    @Override
    public void drawThoughtBalloon(String message) {
        System.out.println(
            String.format("%s thinks: '%s'",
                nickName,
                message));
    }
}

public class WonderCat implements 
    DrawableInComic, DrawableInGame {
    protected final String nickName;
    protected final int age;
    protected int score;
    protected final String fullName;
    protected int x;
    protected int y;
   
    public WonderCat(String nickName, int age, 
        String fullName, int score, 
        int x, int y) {
        this.nickName = nickName;
        this.age = age;
        this.fullName = fullName;
        this.score = score;
        this.x = x;
        this.y = y;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String getNickName() {
        return nickName;
    }

    @Override
    public void drawSpeechBalloon(String message) {
        String meow = 
            (age > 2) ? "Meow" : "Meeoow Meeoow";
        System.out.println(
            String.format("%s -> %s",
                nickName,
                meow));
    }

    @Override
    public void drawSpeechBalloon(DrawableInComic destination, 
        String message) {
        System.out.println(
            String.format("%s ==> %s --> %s",
                destination.getNickName(),
                nickName,
                message));
    }

    @Override
    public void drawThoughtBalloon(String message) {
        System.out.println(
            String.format("%s thinks: '%s'",
                nickName,
                message));
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println(
            String.format("Moving WonderCat %s to x:%d, y:%d",
                fullName,
                this.x,
                this.y));
    }

    @Override
    public void draw() {
        System.out.println(
            String.format("Drawing WonderCat %s at x:%d, y:%d",
                fullName,
                x,
                y));
    }

    @Override
    public boolean isIntersectingWith(
        DrawableInGame otherDrawableInGame) {
        return ((x == otherDrawableInGame.getX()) && 
            (y == otherDrawableInGame.getY()));
    }
}

public class HideableWonderCat extends WonderCat implements Hideable {
    protected final int numberOfEyes;

    public HideableWonderCat(String nickName, int age, 
        String fullName, int score, 
        int x, int y, int numberOfEyes) {
        super(nickName, age, fullName, score, x, y);
        this.numberOfEyes = numberOfEyes;
    }

    @Override
    public int getNumberOfEyes() {
        return numberOfEyes;
    }

    @Override
    public void show() {
        System.out.println(
            String.format(
                "My name is %s and you can see my %d eyes.",
                getFullName(), 
                numberOfEyes));
    }

    @Override
    public void hide() {
        System.out.println(
            String.format(
                "%s is hidden.", 
                getFullName()));
    }
}

public class PowerableWonderCat extends WonderCat implements Powerable {
    protected final int spellPower;
    
    public PowerableWonderCat(String nickName, int age, 
        String fullName, int score, 
        int x, int y, int spellPower) {
        super(nickName, age, fullName, score, x, y);
        this.spellPower = spellPower;
    }

    @Override
    public int getSpellPower() {
        return spellPower;
    }

    @Override
    public void useSpellToHide(Hideable hideable) {
        System.out.println(
            String.format(
                "%s uses his %d spell power to hide the Hideable with %d eyes.",
                getFullName(),
                spellPower,
                hideable.getNumberOfEyes()));
    }
}

public class FightableWonderCat extends WonderCat implements Fightable {
    protected final int swordPower;
    protected final int swordWeight;

    public FightableWonderCat(String nickName, int age, 
        String fullName, int score, 
        int x, int y, int swordPower,
        int swordWeight) {
        super(nickName, age, fullName, score, x, y);
        this.swordPower = swordPower;
        this.swordWeight = swordWeight;
    }

    private void printSwordInformation() {
        System.out.println(
            String.format(
                "%s unsheaths his sword.", 
                getFullName()));
        System.out.println(
            String.format(
                "Sword power: %d. Sword weight: %d.", 
                swordPower,
                swordWeight));
    }

    @Override
    public int getSwordPower() {
        return swordPower;
    }
    
    @Override
    public int getSwordWeight() {
        return swordWeight;
    }

    @Override
    public void unsheathSword() {
        printSwordInformation();
    }

    @Override
    public void unsheathSword(Hideable hideable) {
        printSwordInformation();
        System.out.println(
            String.format("The sword targets a Hideable with %d eyes.",
                hideable.getNumberOfEyes()));
    }
}

SpiderDog spiderDog1 = 
    new SpiderDog("Buddy");
WonderCat wonderCat1 = 
    new WonderCat("Daisy", 1, "Mrs. Daisy", 100, 15, 15);
HideableWonderCat hideableWonderCat1 =
    new HideableWonderCat("Molly", 5, "Mrs. Molly", 450, 20, 10, 3); 
PowerableWonderCat powerableWonderCat1 =
    new PowerableWonderCat("Princess", 5, "Mrs. Princess", 320, 20, 10, 7);
FightableWonderCat fightableWonderCat1 =
    new FightableWonderCat("Abby", 3, "Mrs. Abby", 1200, 40, 10, 7, 5);

spiderDog1 instanceof SpiderDog
spiderDog1 instanceof DrawableInComic

wonderCat1 instanceof WonderCat
wonderCat1 instanceof DrawableInComic
wonderCat1 instanceof DrawableInGame

hideableWonderCat1 instanceof WonderCat
hideableWonderCat1 instanceof HideableWonderCat
hideableWonderCat1 instanceof DrawableInComic
hideableWonderCat1 instanceof DrawableInGame
hideableWonderCat1 instanceof Hideable

powerableWonderCat1 instanceof WonderCat
powerableWonderCat1 instanceof PowerableWonderCat
powerableWonderCat1 instanceof DrawableInComic
powerableWonderCat1 instanceof DrawableInGame
powerableWonderCat1 instanceof Powerable

fightableWonderCat1 instanceof WonderCat
fightableWonderCat1 instanceof FightableWonderCat
fightableWonderCat1 instanceof DrawableInComic
fightableWonderCat1 instanceof DrawableInGame
fightableWonderCat1 instanceof Fightable

SpiderDog teddy = new SpiderDog("Teddy");
SpiderDog winston = new SpiderDog("Winston");
teddy.drawSpeechBalloon(
    String.format("Hello, my name is %s", teddy.getNickName()));
teddy.drawSpeechBalloon(winston, "How do you do?");
winston.drawThoughtBalloon("Who are you? I think.");

WonderCat oliver = 
    new WonderCat("Oliver", 10, "Mr. Oliver", 0, 15, 25);
oliver.drawSpeechBalloon(
    String.format("Hello, my name is %s", oliver.getNickName()));
teddy.drawSpeechBalloon(oliver, 
    String.format("Hello %s", oliver.getNickName()));

HideableWonderCat misterHideable = 
    new HideableWonderCat("Mr. Hideable", 310, 
        "Mr. John Hideable", 67000, 15, 25, 3);
if (misterHideable.isIntersectingWith(oliver)) {
    misterHideable.setLocation(
        oliver.getX() + 30, oliver.getY() + 30);
}
misterHideable.show();

PowerableWonderCat merlin = 
    new PowerableWonderCat("Merlin", 35, 
        "Mr. Merlin", 78000, 30, 40, 200);
merlin.setLocation(
    merlin.getX() + 5, merlin.getY() + 5);
merlin.draw();
merlin.useSpellToHide(misterHideable);
misterHideable.show();

FightableWonderCat spartan = 
    new FightableWonderCat("Spartan", 28, 
        "Sir Spartan", 1000000, 60, 60, 100, 50);
spartan.setLocation(
    spartan.getX() + 30, spartan.getY() + 10);
spartan.draw();
spartan.unsheathSword(misterHideable);

misterHideable.drawThoughtBalloon(
    "I guess I must be friendly...");
misterHideable.drawSpeechBalloon(
    spartan, "Pleased to meet you, Sir!");

// The following code is just for educational purposes
// and it doesn't represent a best practice
// We should always take advantage of polymorphism instead
public void doSomethingWithWonderCat(WonderCat wonderCat) {
    if (wonderCat instanceof HideableWonderCat) {
        HideableWonderCat hideableCat = (HideableWonderCat) wonderCat;
        hideableCat.show();
    } else if (wonderCat instanceof FightableWonderCat) {
        FightableWonderCat fightableCat = (FightableWonderCat) wonderCat;
        fightableCat.unsheathSword();
    } else if (wonderCat instanceof PowerableWonderCat) {
        PowerableWonderCat powerableCat = (PowerableWonderCat) wonderCat;
        System.out.println(
            String.format("Spell power: %d", 
                powerableCat.getSpellPower()));
    } else {
        System.out.println("This WonderCat isn't cool.");
    }
}

doSomethingWithWonderCat(misterHideable);
doSomethingWithWonderCat(spartan);
doSomethingWithWonderCat(merlin);
doSomethingWithWonderCat(oliver);

public interface DrawableInComic {
    String getNickName();
    void drawSpeechBalloon(String message);
    void drawSpeechBalloon(DrawableInComic destination, String message);
    void drawThoughtBalloon(String message);
    default void drawScreamBalloon(String message) {
        drawSpeechBalloon(message);
    }
}

public class SpiderDog implements DrawableInComic {
    protected final String nickName;

    public SpiderDog(String nickName) {
        this.nickName = nickName;
    }

    protected void speak(String message) {
        System.out.println(
            String.format("%s -> %s",
                nickName,
                message));
    }

    protected void think(String message) {
        System.out.println(
            String.format("%s -> ***%s***",
                nickName,
                message));
    }

    protected void scream(String message) {
        System.out.println(
            String.format("%s screams +++ %s +++",
                nickName,
                message));
    }

    @Override
    public String getNickName() {
        return nickName;
    }

    @Override
    public void drawSpeechBalloon(String message) {
        speak(message);
    }

    @Override
    public void drawSpeechBalloon(DrawableInComic destination, 
        String message) {
        speak(String.format("message: %s, %s",
            destination.getNickName(),
            message));
    }

    @Override
    public void drawThoughtBalloon(String message) {
        think(message);
    }

    @Override
    public void drawScreamBalloon(String message) {
        scream(message);
    }
}

SpiderDog rocky = new SpiderDog("Rocky");
FightableWonderCat maggie = 
    new FightableWonderCat("Maggie", 2, 
        "Mrs. Maggie", 5000000, 10, 10, 80, 30);
rocky.drawScreamBalloon("I am Rocky!");
maggie.drawScreamBalloon("I am Mrs. Maggie!");

