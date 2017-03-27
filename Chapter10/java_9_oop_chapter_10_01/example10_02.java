public interface Sociable {
    String getName();
    int getAge();
    void actAlone();
    void danceAlone();
    void danceWith(Sociable partner);
    void singALyric(String lyric);
    void speak(String message);
    void welcome(Sociable other);
    void sayGoodbyeTo(Sociable other);
}

public abstract class SocialAnimal implements Sociable, Comparable<Sociable> {
    public final String name;
    public final int age;

    public SocialAnimal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected void printMessageWithNameAsPrefix(String message) {
        System.out.println(
            String.format("%s %s", 
                getName(), 
                message));
    }

    public abstract String getDanceRepresentation();

    public abstract String getFirstSoundInWords();

    public abstract String getSecondSoundInWords();

    public abstract String getThirdSoundInWords();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void actAlone() {
        printMessageWithNameAsPrefix("to be or not to be");
    }

    @Override
    public void danceAlone() {
        printMessageWithNameAsPrefix(
            String.format("dances alone %s", 
                getDanceRepresentation()));
    }

    @Override
    public void danceWith(Sociable partner) {
        printMessageWithNameAsPrefix(
            String.format("dances with %s %s",
                partner.getName(),
                getDanceRepresentation()));
    }

    @Override
    public void singALyric(String lyric) {
        printMessageWithNameAsPrefix(
            String.format("sings %s %s %s %s", 
                lyric,
                getFirstSoundInWords(),
                getSecondSoundInWords(),
                getThirdSoundInWords()));
    }

    @Override
    public void speak(String message) {
        printMessageWithNameAsPrefix(
            String.format("says: %s %s", 
                message,
                getDanceRepresentation()));
    }

    @Override
    public void welcome(Sociable other) {
        printMessageWithNameAsPrefix(
            String.format("welcomes %s", 
                other.getName()));
    }

    @Override
    public void sayGoodbyeTo(Sociable other) {
        printMessageWithNameAsPrefix(
            String.format("says goodbye to %s %s%s%s", 
                other.getName(),
                getFirstSoundInWords(),
                getSecondSoundInWords(),
                getThirdSoundInWords()));
    }

    @Override
    public boolean equals(Object other) {
        // Is other this object?
        if (this == other) {
            return true;
        }
        // Is other null?
        if (other == null) {
            return false;
        }
        // Does other have the same type?
        if (!getClass().equals(other.getClass())) {
            return false;  
        }
        SocialAnimal otherSocialAnimal = (SocialAnimal) other;
        // Make sure both the name and age are equal
        return Objects.equals(getName(), otherSocialAnimal.getName())
&& Objects.equals(getAge(), otherSocialAnimal.getAge());
    }

    @Override
    public int compareTo(final Sociable otherSociable) {
        return Integer.compare(getAge(), 
            otherSociable.getAge());
    }
}

public class SocialLion extends SocialAnimal {
    public SocialLion(String name, int age) {
        super(name, age);
    }

    @Override
    public String getDanceRepresentation() {
        return "*-* ^\\/^ (-)";
    }

    @Override
    public String getFirstSoundInWords() {
        return "Roar";
    }

    @Override
    public String getSecondSoundInWords() {
        return "Rrooaarr";
    }

    @Override
    public String getThirdSoundInWords() {
        return "Rrrrrrrroooooaaarrrr";
    }
}


public class SocialParrot extends SocialAnimal {
    public SocialParrot(String name, int age) {
        super(name, age);
    }

    @Override
    public String getDanceRepresentation() {
        return "/|\\ -=- % % +=+";
    }

    @Override
    public String getFirstSoundInWords() {
        return "Yeah";
    }

    @Override
    public String getSecondSoundInWords() {
        return "Yeeaah";
    }

    @Override
    public String getThirdSoundInWords() {
        return "Yeeeaaaah";
    }
}

public class SocialSwan extends SocialAnimal {
    public SocialSwan(String name, int age) {
        super(name, age);
    }

    @Override
    public String getDanceRepresentation() {
        return "^- ^- ^- -^ -^ -^";
    }

    @Override
    public String getFirstSoundInWords() {
        return "OO-OO-OO";
    }

    @Override
    public String getSecondSoundInWords() {
        return "WHO-HO WHO-HO";
    }

    @Override
    public String getThirdSoundInWords() {
        return "WHO-WHO WHO-WHO";
    }
}

public class InsufficientMembersException extends Exception {
    private final int numberOfMembers;

    public InsufficientMembersException(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }
}

public class CannotRemovePartyLeaderException extends Exception {
}

import java.util.concurrent.ThreadLocalRandom;

public class Party<T extends Sociable & Comparable<Sociable>> {
    protected final List<T> members;
    protected T partyLeader;

    public Party(T partyLeader) {
        this.partyLeader = partyLeader;
        members = new ArrayList<>();
        members.add(partyLeader);
    }

    public T getPartyLeader() {
        return partyLeader;
    }
    public void addMember(T newMember) {
        members.add(newMember);
        partyLeader.welcome(newMember);
    }

    public T removeMember(T memberToRemove) throws CannotRemovePartyLeaderException {
        if (memberToRemove.equals(partyLeader)) {
            throw new CannotRemovePartyLeaderException();
        }
        int memberIndex = members.indexOf(memberToRemove);
        if (memberIndex >= 0) {
            members.remove(memberToRemove);
            memberToRemove.sayGoodbyeTo(partyLeader);
            return memberToRemove;
        } else {
            return null;
        }
    }

    public void makeMembersAct() {
        for (T member : members) {
            member.actAlone();
        }
    }

    public void makeMembersDance() {
        for (T member : members) {
            member.danceAlone();
        }
    }

    public void makeMembersSingALyric(String lyric) {
        for (T member : members) {
            member.singALyric(lyric);
        }
    }

    public void declareNewPartyLeader() throws InsufficientMembersException {
        if (members.size() == 1) {
            throw new InsufficientMembersException(members.size());
        }
        T newPartyLeader = partyLeader;
        while (newPartyLeader.equals(partyLeader)) {
            int pseudoRandomIndex = 
                ThreadLocalRandom.current().nextInt(
                    0,
                    members.size());
            newPartyLeader = members.get(pseudoRandomIndex);
        }
        partyLeader.speak(
            String.format("%s is our new party leader.", 
                newPartyLeader.getName()));
        newPartyLeader.danceWith(partyLeader);
        if (newPartyLeader.compareTo(partyLeader) < 0) {
            // The new party leader is younger
            newPartyLeader.danceAlone();
        }
        partyLeader = newPartyLeader;
    }
}

SocialLion simba = new SocialLion("Simba", 10);
SocialLion mufasa = new SocialLion("Mufasa", 5);
SocialLion scar = new SocialLion("Scar", 9);
SocialLion nala = new SocialLion("Nala", 7);
Party<SocialLion> lionsParty = new Party<>(simba);

lionsParty.addMember(mufasa);
lionsParty.addMember(scar);
lionsParty.addMember(nala);

lionsParty.makeMembersAct();
lionsParty.makeMembersDance();
try {
    lionsParty.removeMember(nala);
} catch (CannotRemovePartyLeaderException e) {
    System.out.println(
        "We cannot remove the party leader.");
}
try {
    lionsParty.declareNewPartyLeader();
} catch (InsufficientMembersException e) {
    System.out.println(
        String.format("We just have %s member",
            e.getNumberOfMembers()));
}
lionsParty.makeMembersSingALyric("Welcome to the jungle");

SocialParrot rio = new SocialParrot("Rio", 3);
SocialParrot thor = new SocialParrot("Thor", 6);
SocialParrot rambo = new SocialParrot("Rambo", 4);
SocialParrot woody = new SocialParrot("Woody", 5);
Party<SocialParrot> parrotsParty = new Party<>(rio);

parrotsParty.addMember(thor);
parrotsParty.addMember(rambo);
parrotsParty.addMember(woody);

parrotsParty.makeMembersDance();
try {
    parrotsParty.removeMember(rambo);
} catch (CannotRemovePartyLeaderException e) {
    System.out.println(
        "We cannot remove the party leader.");
}
try {
    parrotsParty.declareNewPartyLeader();
} catch (InsufficientMembersException e) {
    System.out.println(
        String.format("We just have %s member",
            e.getNumberOfMembers()));
}
parrotsParty.makeMembersSingALyric("Fly like a bird");

// The following lines won't compile
// and will generate errors in JShell
lionsParty.addMember(rio);
parrotsParty.addMember(simba);
