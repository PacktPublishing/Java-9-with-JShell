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
