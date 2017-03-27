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
