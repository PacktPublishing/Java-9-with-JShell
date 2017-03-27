public interface Identifiable {
    int getId();
}

public interface Repository<E extends Identifiable> {
    List<E> getAll();
}

public abstract class Entity implements Identifiable {
    protected final int id;

    public Entity(int id) {
        this.id = id;
    }

    @Override
    public final int getId() {
        return id;
    }
}

public class MobileGame extends Entity {
    protected final String separator = "; ";
    public final String name;
    public int highestScore;
    public int lowestScore;
    public int playersCount;

    public MobileGame(int id, 
        String name, 
        int highestScore, 
        int lowestScore, 
        int playersCount  ) {
        super(id);
        this.name = name;
        this.highestScore = highestScore;
        this.lowestScore = lowestScore;
        this.playersCount = playersCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ");
        sb.append(getId());
        sb.append(separator);
        sb.append("Name: ");
        sb.append(name);
        sb.append(separator);
        sb.append("Highest score: ");
        sb.append(highestScore);
        sb.append(separator);
        sb.append("Lowest score: ");
        sb.append(lowestScore);
        sb.append(separator);
        sb.append("Players count: ");
        sb.append(playersCount);

        return sb.toString();
    }
}

import java.util.stream.Collectors;


public class MemoryMobileGameRepository implements Repository<MobileGame> {
    @Override
    public List<MobileGame> getAll() {
        List<MobileGame> mobileGames = new ArrayList<>();
        mobileGames.add(
            new MobileGame(1, "Uncharted 4000", 5000, 10, 3800));
        mobileGames.add(
            new MobileGame(2, "Supergirl 2017", 8500, 5, 75000));
        mobileGames.add(
            new MobileGame(3, "Super Luigi Run", 32000, 300, 90000));
        mobileGames.add(
            new MobileGame(4, "Mario vs Kong III", 152000, 1500, 750000));
        mobileGames.add(
            new MobileGame(5, "Minecraft Reloaded", 6708960, 8000, 3500000));
        mobileGames.add(
            new MobileGame(6, "Pikachu vs Beedrill: The revenge", 780000, 400, 1000000));
        mobileGames.add(
            new MobileGame(7, "Jerry vs Tom vs Spike", 78000, 670, 20000));
        mobileGames.add(
            new MobileGame(8, "NBA 2017", 1500607, 20, 7000005));
        mobileGames.add(
            new MobileGame(9, "NFL 2017", 3205978, 0, 4600700));
        mobileGames.add(
            new MobileGame(10, "Nascar Remix", 785000, 0, 2600000));
        mobileGames.add(
            new MobileGame(11, "Little BIG Universe", 95000, 3, 546000));
        mobileGames.add(
            new MobileGame(12, "Plants vs Zombies Garden Warfare 3", 879059, 0, 789000));
        mobileGames.add(
            new MobileGame(13, "Final Fantasy XVII", 852325, 0, 375029));
        mobileGames.add(
            new MobileGame(14, "Watch Dogs 3", 27000, 2, 78004));
        mobileGames.add(
            new MobileGame(15, "Remember Me", 672345, 5, 252003));

        return mobileGames;
    }
}


MemoryMobileGameRepository repository = new MemoryMobileGameRepository()
repository.getAll().forEach(mobileGame -> System.out.println(mobileGame));

repository.getAll().forEach(System.out::println);

public class MemoryMobileGameRepository implements Repository<MobileGame> {
    @Override
    public List<MobileGame> getAll() {
        List<MobileGame> mobileGames = new ArrayList<>();
        mobileGames.add(
            new MobileGame(1, "Uncharted 4000", 5000, 10, 3800));
        mobileGames.add(
            new MobileGame(2, "Supergirl 2017", 8500, 5, 75000));
        mobileGames.add(
            new MobileGame(3, "Super Luigi Run", 32000, 300, 90000));
        mobileGames.add(
            new MobileGame(4, "Mario vs Kong III", 152000, 1500, 750000));
        mobileGames.add(
            new MobileGame(5, "Minecraft Reloaded", 6708960, 8000, 3500000));
        mobileGames.add(
            new MobileGame(6, "Pikachu vs Beedrill: The revenge", 780000, 400, 1000000));
        mobileGames.add(
            new MobileGame(7, "Jerry vs Tom vs Spike", 78000, 670, 20000));
        mobileGames.add(
            new MobileGame(8, "NBA 2017", 1500607, 20, 7000005));
        mobileGames.add(
            new MobileGame(9, "NFL 2017", 3205978, 0, 4600700));
        mobileGames.add(
            new MobileGame(10, "Nascar Remix", 785000, 0, 2600000));
        mobileGames.add(
            new MobileGame(11, "Little BIG Universe", 95000, 3, 546000));
        mobileGames.add(
            new MobileGame(12, "Plants vs Zombies Garden Warfare 3", 879059, 0, 789000));
        mobileGames.add(
            new MobileGame(13, "Final Fantasy XVII", 852325, 0, 375029));
        mobileGames.add(
            new MobileGame(14, "Watch Dogs 3", 27000, 2, 78004));
        mobileGames.add(
            new MobileGame(15, "Remember Me", 672345, 5, 252003));

        return mobileGames;
    }

    public List<MobileGame> getWithLowestScoreGreaterThan(int minimumLowestScore) {
        return getAll().stream()
            .filter(game -> game.lowestScore > minimumLowestScore)
            .collect(Collectors.toList());
    }

    public List<MobileGame> getWithLowestScoreGreaterThanV2(int minimumLowestScore) {
        return getAll().stream()
            .filter((MobileGame game) -> game.lowestScore > minimumLowestScore)        
            .collect(Collectors.toList());
    }
}

MemoryMobileGameRepository repository = new MemoryMobileGameRepository()
repository.getWithLowestScoreGreaterThan(1000).forEach(System.out::println);


public class MemoryMobileGameRepository implements Repository<MobileGame> {
    @Override
    public List<MobileGame> getAll() {
        List<MobileGame> mobileGames = new ArrayList<>();
        mobileGames.add(
            new MobileGame(1, "Uncharted 4000", 5000, 10, 3800));
        mobileGames.add(
            new MobileGame(2, "Supergirl 2017", 8500, 5, 75000));
        mobileGames.add(
            new MobileGame(3, "Super Luigi Run", 32000, 300, 90000));
        mobileGames.add(
            new MobileGame(4, "Mario vs Kong III", 152000, 1500, 750000));
        mobileGames.add(
            new MobileGame(5, "Minecraft Reloaded", 6708960, 8000, 3500000));
        mobileGames.add(
            new MobileGame(6, "Pikachu vs Beedrill: The revenge", 780000, 400, 1000000));
        mobileGames.add(
            new MobileGame(7, "Jerry vs Tom vs Spike", 78000, 670, 20000));
        mobileGames.add(
            new MobileGame(8, "NBA 2017", 1500607, 20, 7000005));
        mobileGames.add(
            new MobileGame(9, "NFL 2017", 3205978, 0, 4600700));
        mobileGames.add(
            new MobileGame(10, "Nascar Remix", 785000, 0, 2600000));
        mobileGames.add(
            new MobileGame(11, "Little BIG Universe", 95000, 3, 546000));
        mobileGames.add(
            new MobileGame(12, "Plants vs Zombies Garden Warfare 3", 879059, 0, 789000));
        mobileGames.add(
            new MobileGame(13, "Final Fantasy XVII", 852325, 0, 375029));
        mobileGames.add(
            new MobileGame(14, "Watch Dogs 3", 27000, 2, 78004));
        mobileGames.add(
            new MobileGame(15, "Remember Me", 672345, 5, 252003));

        return mobileGames;
    }

    public List<MobileGame> getWithLowestScoreGreaterThan(int minimumLowestScore) {
        return getAll().stream()
            .filter(game -> game.lowestScore > minimumLowestScore)
            .collect(Collectors.toList());
    }

    public List<MobileGame> getWithLowestScoreGreaterThanV2(int minimumLowestScore) {
        return getAll().stream()
            .filter((MobileGame game) -> game.lowestScore > minimumLowestScore)        
            .collect(Collectors.toList());
    }

    public List<MobileGame> getStartingWith(String prefix) {
        return getAll().stream()
            .filter(game -> game.name.startsWith(prefix))
            .collect(Collectors.toList());
    }
}

MemoryMobileGameRepository repository = new MemoryMobileGameRepository()
repository.getStartingWith("Su").forEach(System.out::println);


public class MemoryMobileGameRepository implements Repository<MobileGame> {
    @Override
    public List<MobileGame> getAll() {
        List<MobileGame> mobileGames = new ArrayList<>();
        mobileGames.add(
            new MobileGame(1, "Uncharted 4000", 5000, 10, 3800));
        mobileGames.add(
            new MobileGame(2, "Supergirl 2017", 8500, 5, 75000));
        mobileGames.add(
            new MobileGame(3, "Super Luigi Run", 32000, 300, 90000));
        mobileGames.add(
            new MobileGame(4, "Mario vs Kong III", 152000, 1500, 750000));
        mobileGames.add(
            new MobileGame(5, "Minecraft Reloaded", 6708960, 8000, 3500000));
        mobileGames.add(
            new MobileGame(6, "Pikachu vs Beedrill: The revenge", 780000, 400, 1000000));
        mobileGames.add(
            new MobileGame(7, "Jerry vs Tom vs Spike", 78000, 670, 20000));
        mobileGames.add(
            new MobileGame(8, "NBA 2017", 1500607, 20, 7000005));
        mobileGames.add(
            new MobileGame(9, "NFL 2017", 3205978, 0, 4600700));
        mobileGames.add(
            new MobileGame(10, "Nascar Remix", 785000, 0, 2600000));
        mobileGames.add(
            new MobileGame(11, "Little BIG Universe", 95000, 3, 546000));
        mobileGames.add(
            new MobileGame(12, "Plants vs Zombies Garden Warfare 3", 879059, 0, 789000));
        mobileGames.add(
            new MobileGame(13, "Final Fantasy XVII", 852325, 0, 375029));
        mobileGames.add(
            new MobileGame(14, "Watch Dogs 3", 27000, 2, 78004));
        mobileGames.add(
            new MobileGame(15, "Remember Me", 672345, 5, 252003));

        return mobileGames;
    }

    public List<MobileGame> getWithLowestScoreGreaterThan(int minimumLowestScore) {
        return getAll().stream()
            .filter(game -> game.lowestScore > minimumLowestScore)
            .collect(Collectors.toList());
    }

    public List<MobileGame> getWithLowestScoreGreaterThanV2(int minimumLowestScore) {
        return getAll().stream()
            .filter((MobileGame game) -> game.lowestScore > minimumLowestScore)        
            .collect(Collectors.toList());
    }

    public List<MobileGame> getStartingWith(String prefix) {
        return getAll().stream()
            .filter(game -> game.name.startsWith(prefix))
            .collect(Collectors.toList());
    }

    public Optional<MobileGame> getByPlayersCountAndHighestScore(
        int playersCount, 
        int highestScore) {
        return getAll().stream()
            .filter(game -> (game.playersCount == playersCount) && (game.highestScore == highestScore))
            .findFirst();
    }
}

MemoryMobileGameRepository repository = new MemoryMobileGameRepository()
Optional<MobileGame> optionalMobileGame1 = 
    repository.getByPlayersCountAndHighestScore(750000, 152000);
if (optionalMobileGame1.isPresent()) {
    MobileGame mobileGame1 = optionalMobileGame1.get();
    System.out.println(mobileGame1);
} else {
    System.out.println("No mobile game matches the specified criteria.");
}
Optional<MobileGame> optionalMobileGame2 = 
    repository.getByPlayersCountAndHighestScore(670000, 829340);
if (optionalMobileGame2.isPresent()) {
    MobileGame mobileGame2 = optionalMobileGame2.get();
    System.out.println(mobileGame2);
} else {
    System.out.println("No mobile game matches the specified criteria.");
}


public class MemoryMobileGameRepository implements Repository<MobileGame> {
    @Override
    public List<MobileGame> getAll() {
        List<MobileGame> mobileGames = new ArrayList<>();
        mobileGames.add(
            new MobileGame(1, "Uncharted 4000", 5000, 10, 3800));
        mobileGames.add(
            new MobileGame(2, "Supergirl 2017", 8500, 5, 75000));
        mobileGames.add(
            new MobileGame(3, "Super Luigi Run", 32000, 300, 90000));
        mobileGames.add(
            new MobileGame(4, "Mario vs Kong III", 152000, 1500, 750000));
        mobileGames.add(
            new MobileGame(5, "Minecraft Reloaded", 6708960, 8000, 3500000));
        mobileGames.add(
            new MobileGame(6, "Pikachu vs Beedrill: The revenge", 780000, 400, 1000000));
        mobileGames.add(
            new MobileGame(7, "Jerry vs Tom vs Spike", 78000, 670, 20000));
        mobileGames.add(
            new MobileGame(8, "NBA 2017", 1500607, 20, 7000005));
        mobileGames.add(
            new MobileGame(9, "NFL 2017", 3205978, 0, 4600700));
        mobileGames.add(
            new MobileGame(10, "Nascar Remix", 785000, 0, 2600000));
        mobileGames.add(
            new MobileGame(11, "Little BIG Universe", 95000, 3, 546000));
        mobileGames.add(
            new MobileGame(12, "Plants vs Zombies Garden Warfare 3", 879059, 0, 789000));
        mobileGames.add(
            new MobileGame(13, "Final Fantasy XVII", 852325, 0, 375029));
        mobileGames.add(
            new MobileGame(14, "Watch Dogs 3", 27000, 2, 78004));
        mobileGames.add(
            new MobileGame(15, "Remember Me", 672345, 5, 252003));

        return mobileGames;
    }

    public List<MobileGame> getWithLowestScoreGreaterThan(int minimumLowestScore) {
        return getAll().stream()
            .filter(game -> game.lowestScore > minimumLowestScore)
            .collect(Collectors.toList());
    }

    public List<MobileGame> getWithLowestScoreGreaterThanV2(int minimumLowestScore) {
        return getAll().stream()
            .filter((MobileGame game) -> game.lowestScore > minimumLowestScore)        
            .collect(Collectors.toList());
    }

    public List<MobileGame> getStartingWith(String prefix) {
        return getAll().stream()
            .filter(game -> game.name.startsWith(prefix))
            .collect(Collectors.toList());
    }

    public Optional<MobileGame> getByPlayersCountAndHighestScore(
        int playersCount, 
        int highestScore) {
        return getAll().stream()
            .filter(game -> (game.playersCount == playersCount) && (game.highestScore == highestScore))
            .findFirst();
    }


    public List<String> getGameNamesTransformedToUpperCase() {
        return getAll().stream()
            .map(game -> game.name.toUpperCase())
            .collect(Collectors.toList());
    }
}

MemoryMobileGameRepository repository = new MemoryMobileGameRepository()
repository.getGameNamesTransformedToUpperCase().forEach(System.out::println);

public class NamesForMobileGame {
    public final String upperCaseName;
    public final String lowerCaseName;

    public NamesForMobileGame(String name) {
        this.upperCaseName = name.toUpperCase();
        this.lowerCaseName = name.toLowerCase();
    }

    public NamesForMobileGame(MobileGame game) {
        this(game.name);
    }
}


public class MemoryMobileGameRepository implements Repository<MobileGame> {
    @Override
    public List<MobileGame> getAll() {
        List<MobileGame> mobileGames = new ArrayList<>();
        mobileGames.add(
            new MobileGame(1, "Uncharted 4000", 5000, 10, 3800));
        mobileGames.add(
            new MobileGame(2, "Supergirl 2017", 8500, 5, 75000));
        mobileGames.add(
            new MobileGame(3, "Super Luigi Run", 32000, 300, 90000));
        mobileGames.add(
            new MobileGame(4, "Mario vs Kong III", 152000, 1500, 750000));
        mobileGames.add(
            new MobileGame(5, "Minecraft Reloaded", 6708960, 8000, 3500000));
        mobileGames.add(
            new MobileGame(6, "Pikachu vs Beedrill: The revenge", 780000, 400, 1000000));
        mobileGames.add(
            new MobileGame(7, "Jerry vs Tom vs Spike", 78000, 670, 20000));
        mobileGames.add(
            new MobileGame(8, "NBA 2017", 1500607, 20, 7000005));
        mobileGames.add(
            new MobileGame(9, "NFL 2017", 3205978, 0, 4600700));
        mobileGames.add(
            new MobileGame(10, "Nascar Remix", 785000, 0, 2600000));
        mobileGames.add(
            new MobileGame(11, "Little BIG Universe", 95000, 3, 546000));
        mobileGames.add(
            new MobileGame(12, "Plants vs Zombies Garden Warfare 3", 879059, 0, 789000));
        mobileGames.add(
            new MobileGame(13, "Final Fantasy XVII", 852325, 0, 375029));
        mobileGames.add(
            new MobileGame(14, "Watch Dogs 3", 27000, 2, 78004));
        mobileGames.add(
            new MobileGame(15, "Remember Me", 672345, 5, 252003));

        return mobileGames;
    }

    public List<MobileGame> getWithLowestScoreGreaterThan(int minimumLowestScore) {
        return getAll().stream()
            .filter(game -> game.lowestScore > minimumLowestScore)
            .collect(Collectors.toList());
    }

    public List<MobileGame> getWithLowestScoreGreaterThanV2(int minimumLowestScore) {
        return getAll().stream()
            .filter((MobileGame game) -> game.lowestScore > minimumLowestScore)        
            .collect(Collectors.toList());
    }

    public List<MobileGame> getStartingWith(String prefix) {
        return getAll().stream()
            .filter(game -> game.name.startsWith(prefix))
            .collect(Collectors.toList());
    }

    public Optional<MobileGame> getByPlayersCountAndHighestScore(
        int playersCount, 
        int highestScore) {
        return getAll().stream()
            .filter(game -> (game.playersCount == playersCount) && (game.highestScore == highestScore))
            .findFirst();
    }


    public List<String> getGameNamesTransformedToUpperCase() {
        return getAll().stream()
            .map(game -> game.name.toUpperCase())
            .collect(Collectors.toList());
    }

    public List<NamesForMobileGame> getNamesForMobileGames() {
        return getAll().stream()
            .map(game -> new NamesForMobileGame(game.name))
            .collect(Collectors.toList());
    }
}

MemoryMobileGameRepository repository = new MemoryMobileGameRepository()
repository.getNamesForMobileGames().forEach(names -> {
    StringBuilder sb = new StringBuilder();
    sb.append(names.upperCaseName);
    sb.append(" - ");
    sb.append(names.lowerCaseName);
    System.out.println(sb.toString());
});


public class MemoryMobileGameRepository implements Repository<MobileGame> {
    @Override
    public List<MobileGame> getAll() {
        List<MobileGame> mobileGames = new ArrayList<>();
        mobileGames.add(
            new MobileGame(1, "Uncharted 4000", 5000, 10, 3800));
        mobileGames.add(
            new MobileGame(2, "Supergirl 2017", 8500, 5, 75000));
        mobileGames.add(
            new MobileGame(3, "Super Luigi Run", 32000, 300, 90000));
        mobileGames.add(
            new MobileGame(4, "Mario vs Kong III", 152000, 1500, 750000));
        mobileGames.add(
            new MobileGame(5, "Minecraft Reloaded", 6708960, 8000, 3500000));
        mobileGames.add(
            new MobileGame(6, "Pikachu vs Beedrill: The revenge", 780000, 400, 1000000));
        mobileGames.add(
            new MobileGame(7, "Jerry vs Tom vs Spike", 78000, 670, 20000));
        mobileGames.add(
            new MobileGame(8, "NBA 2017", 1500607, 20, 7000005));
        mobileGames.add(
            new MobileGame(9, "NFL 2017", 3205978, 0, 4600700));
        mobileGames.add(
            new MobileGame(10, "Nascar Remix", 785000, 0, 2600000));
        mobileGames.add(
            new MobileGame(11, "Little BIG Universe", 95000, 3, 546000));
        mobileGames.add(
            new MobileGame(12, "Plants vs Zombies Garden Warfare 3", 879059, 0, 789000));
        mobileGames.add(
            new MobileGame(13, "Final Fantasy XVII", 852325, 0, 375029));
        mobileGames.add(
            new MobileGame(14, "Watch Dogs 3", 27000, 2, 78004));
        mobileGames.add(
            new MobileGame(15, "Remember Me", 672345, 5, 252003));

        return mobileGames;
    }

    public List<MobileGame> getWithLowestScoreGreaterThan(int minimumLowestScore) {
        return getAll().stream()
            .filter(game -> game.lowestScore > minimumLowestScore)
            .collect(Collectors.toList());
    }

    public List<MobileGame> getWithLowestScoreGreaterThanV2(int minimumLowestScore) {
        return getAll().stream()
            .filter((MobileGame game) -> game.lowestScore > minimumLowestScore)        
            .collect(Collectors.toList());
    }

    public List<MobileGame> getStartingWith(String prefix) {
        return getAll().stream()
            .filter(game -> game.name.startsWith(prefix))
            .collect(Collectors.toList());
    }

    public Optional<MobileGame> getByPlayersCountAndHighestScore(
        int playersCount, 
        int highestScore) {
        return getAll().stream()
            .filter(game -> (game.playersCount == playersCount) && (game.highestScore == highestScore))
            .findFirst();
    }


    public List<String> getGameNamesTransformedToUpperCase() {
        return getAll().stream()
            .map(game -> game.name.toUpperCase())
            .collect(Collectors.toList());
    }

    public List<NamesForMobileGame> getNamesForMobileGames() {
        return getAll().stream()
            .map(game -> new NamesForMobileGame(game.name))
            .collect(Collectors.toList());
    }

    public List<NamesForMobileGame> getNamesForMobileGamesV2() {
        return getAll().stream()
            .map(NamesForMobileGame::new)
            .collect(Collectors.toList());
    }
}

MemoryMobileGameRepository repository = new MemoryMobileGameRepository();
repository.getNamesForMobileGamesV2().forEach(names -> {
    StringBuilder sb = new StringBuilder();
    sb.append(names.upperCaseName);
    sb.append(" - ");
    sb.append(names.lowerCaseName);
    System.out.println(sb.toString());
});

int lowestScoreSum = 0;
for (MobileGame mobileGame : repository.getAll()) {
    lowestScoreSum += mobileGame.lowestScore;
}
System.out.println(lowestScoreSum);

int lowestScoreMapReduceSum = repository.getAll().stream().map(game -> game.lowestScore).reduce(0, (sum, lowestScore) -> sum + lowestScore);
System.out.println(lowestScoreMapReduceSum);

int lowestScoreMapReduceSum2 = 
    repository.getAll().stream().map(game -> game.lowestScore).reduce(0, (sum, lowestScore) -> {
        StringBuilder sb = new StringBuilder();
        sb.append("sum value: ");
        sb.append(sum);
        sb.append(";lowestScore value: ");
        sb.append(lowestScore);
        System.out.println(sb.toString());

        return sum + lowestScore;
    });
System.out.println(lowestScoreMapReduceSum2);

int lowestScoreMapReduceSum3 =
    repository.getAll().stream().mapToInt(game -> game.lowestScore).sum();
System.out.println(lowestScoreMapReduceSum3);

