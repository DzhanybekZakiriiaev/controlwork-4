import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cat{
    private String name;
    private int age;
    private int hunger;
    private int mood;
    private int health;
    private boolean action;

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

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
        this.action = false;
    }
    public static void checkStats(Cat cat){
        if (cat.getHunger() > 100){
            cat.setHunger(100);
        }
        if (cat.getHunger() < 0){
            cat.setHunger(0);
        }
        if (cat.getMood() > 100){
            cat.setMood(100);
        }
        if (cat.getMood() < 0){
            cat.setMood(0);
        }
        if (cat.getHealth() > 100){
            cat.setHealth(100);
        }
        if (cat.getHealth() < 0){
            cat.setHealth(0);
        }
    }

    public int getOverall(){
        return (getHealth()+getMood()+getHunger())/3;
    }
    public static void feedCat(Cat cat){
        if (cat.getAge() < 6){
            cat.setHunger(cat.getHunger()+7);
            cat.setMood(cat.getMood()+7);
        }
        else if(cat.getAge() < 10 && cat.getAge() > 6){
            cat.setHunger(cat.getHunger()+5);
            cat.setMood(cat.getMood()+5);
        }
        else if(cat.getAge() > 10){
            cat.setHunger(cat.getHunger()+4);
            cat.setMood(cat.getMood()+4);
        }
        checkStats(cat);
    }
    public static void healCat(Cat cat){
        if (cat.getAge() < 6){
            cat.setHunger(cat.getHunger()-3);
            cat.setMood(cat.getMood()-3);
            cat.setHealth(cat.getHealth()+7);
        }
        else if(cat.getAge() < 10 && cat.getAge() > 6){
            cat.setHunger(cat.getHunger()-5);
            cat.setMood(cat.getMood()-5);
            cat.setHealth(cat.getHealth()+5);
        }
        else if(cat.getAge() > 10){
            cat.setHunger(cat.getHunger()-6);
            cat.setMood(cat.getMood()-6);
            cat.setHealth(cat.getHealth()+4);
        }
        checkStats(cat);
    }
    public void nextDay(Cat cat){
        Random rnd = new Random();
        int health = rnd.nextInt(7)-3;
        cat.setHealth(cat.getHealth()+health);
        int mood = rnd.nextInt(7)-3;
        cat.setMood(cat.getMood()+mood);
        int hunger = rnd.nextInt(5)+1;
        cat.setHunger(cat.getHunger()-hunger);
    }
    public static void playCat(Cat cat){
        if (cat.getAge() < 6){
            cat.setHunger(cat.getHunger()-3);
            cat.setMood(cat.getMood()+7);
            cat.setHealth(cat.getHealth()+7);
        }
        else if(cat.getAge() < 10 && cat.getAge() > 6){
            cat.setHunger(cat.getHunger()-5);
            cat.setMood(cat.getMood()+5);
            cat.setHealth(cat.getHealth()+5);
        }
        else if(cat.getAge() > 10){
            cat.setHunger(cat.getHunger()-6);
            cat.setMood(cat.getMood()+4);
            cat.setHealth(cat.getHealth()+4);
        }
        checkStats(cat);
    }
    public static Cat buyCat(String name, int age){
        Random rnd = new Random();
        int health = rnd.nextInt(61)+20;
        int mood = rnd.nextInt(61)+20;
        int hunger = rnd.nextInt(61)+20;
        return new Cat(name, age, health, mood, hunger);
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
