import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cat{
    private String name;
    private int age;
    private int hunger;
    private int mood;
    private int health;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Cat(String name, int age, int hunger, int mood, int health) {
        this.name = name;
        this.age = age;
        this.hunger = hunger;
        this.mood = mood;
        this.health = health;
    }

    public int getOverall(){
        return (getHealth()+getMood()+getHunger())/3;
    }

    public static List<Cat> generateCats(){
        List<Cat> cats = new ArrayList<>(3);
        Random rnd = new Random();
        List<String> names = List.of("Peach","Jasper","Poppy","Seth","Toby","Kitsune","Neko","Jeff","Andrew");
        while (cats.size() != 3){
            int age = rnd.nextInt(18)+1;
            int health = rnd.nextInt(100)+1;
            int mood = rnd.nextInt(100)+1;
            int hunger = rnd.nextInt(100)+1;
            int index = rnd.nextInt(8);
            cats.add(new Cat(names.get(index),age,health,mood,hunger));
        }
        return cats;
    }

}
