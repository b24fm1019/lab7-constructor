import java.util.Random;

public class Character {
    private String name;
    private int hp;
    private int maxHp;
    private int mp;
    private int maxMp;
    private int gold;

    // Constructor 1: Chaining - Заавал this(name, 100, 50) гэж дуудах ёстой
    public Character(String name) {
        this(name, 100, 50);
    }

    // Constructor 2: Үндсэн байгуулагч
    public Character(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.mp = mp;
        this.maxMp = mp;
        this.gold = 0;
    }

    // Constructor 3: Copy Constructor
    public Character(Character other) {
        this.name = other.name;
        this.hp = other.hp;
        this.maxHp = other.maxHp;
        this.mp = other.mp;
        this.maxMp = other.maxMp;
        this.gold = other.gold;
    }

    // Getter-үүд (Тест эдгээрийг шалгана)
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getMp() { return mp; }
    public int getMaxMp() { return maxMp; }
    public int getGold() { return gold; }

    // Түр зуур gold-ыг тохируулах функц (Builder-т хэрэгтэй)
    public void setGold(int gold) { this.gold = gold; }

    // Static Factory Methods
    public static Character createWarrior(String name) {
        return new Character(name, 150, 20);
    }

    public static Character createMage(String name) {
        return new Character(name, 80, 120);
    }

    public static Character random(String name) {
        Random rand = new Random();
        // 50..150 муж: rand.nextInt(max - min + 1) + min
        int randomHp = rand.nextInt(150 - 50 + 1) + 50;
        // 20..100 муж: rand.nextInt(max - min + 1) + min
        int randomMp = rand.nextInt(100 - 20 + 1) + 20;
        return new Character(name, randomHp, randomMp);
    }
}

// 🔴 БОНУС: CharacterBuilder-ийг Character классны ГАДНА (гэхдээ нэг файл дотор) зарлах
// Ингэснээр Class.forName("CharacterBuilder") тест ажиллана.
class CharacterBuilder {
    private String name = "Hero";
    private int hp = 100;
    private int mp = 50;
    private int gold = 0;

    public CharacterBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CharacterBuilder hp(int hp) {
        this.hp = hp;
        return this;
    }

    public CharacterBuilder mp(int mp) {
        this.mp = mp;
        return this;
    }

    public CharacterBuilder gold(int gold) {
        this.gold = gold;
        return this;
    }

    public Character build() {
        Character c = new Character(this.name, this.hp, this.mp);
        c.setGold(this.gold);
        return c;
    }
}