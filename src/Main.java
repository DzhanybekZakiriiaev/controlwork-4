import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Cat> myCats = Cat.generateCats().stream()
                .sorted(Comparator.comparingInt(Cat::getOverall))
                .collect(Collectors.toList());
        run(myCats);
    }
    public static void run(List<Cat> myCats){
        printTable(myCats);
        System.out.printf("1: Feed%n2: Play%n3: Heal%na: Buy new Cat%nn: Next day%n");
        System.out.print("Enter option: ");
        Scanner sc = new Scanner(System.in);
        try {
            String option = sc.nextLine();
            switch (option) {
                case "1" -> {
                    System.out.print("Enter cat number: ");
                    int catNumber = sc.nextInt() - 1;
                    if (!myCats.get(catNumber).isAction()) {
                        Cat.feedCat(myCats.get(catNumber));
                        myCats = myCats.stream().sorted(Comparator.comparingInt(Cat::getOverall))
                                .collect(Collectors.toList());
                        System.out.printf("You fed %s, age is %s%n", myCats.get(catNumber).getName(), myCats.get(catNumber).getAge());
                        myCats.get(catNumber).setAction(true);
                        run(myCats);
                    } else {
                        System.out.println("You have already interacted with this cat");
                        run(myCats);
                    }
                }
                case "2" -> {
                    System.out.print("Enter cat number: ");
                    int catNumber = sc.nextInt() - 1;
                    if (!myCats.get(catNumber).isAction()) {
                        Cat.playCat(myCats.get(catNumber));
                        myCats = myCats.stream().sorted(Comparator.comparingInt(Cat::getOverall))
                                .collect(Collectors.toList());
                        System.out.printf("You played with %s, age is %s%n", myCats.get(catNumber).getName(), myCats.get(catNumber).getAge());
                        myCats.get(catNumber).setAction(true);
                        run(myCats);
                    } else {
                        System.out.println("You have already interacted with this cat");
                        run(myCats);
                    }
                }
                case "3" -> {
                    System.out.print("Enter cat number: ");
                    int catNumber = sc.nextInt() - 1;
                    if (!myCats.get(catNumber).isAction()) {
                        Cat.healCat(myCats.get(catNumber));
                        myCats = myCats.stream().sorted(Comparator.comparingInt(Cat::getOverall))
                                .collect(Collectors.toList());
                        System.out.printf("You healed %s, age is %s%n", myCats.get(catNumber).getName(), myCats.get(catNumber).getAge());
                        myCats.get(catNumber).setAction(true);
                        run(myCats);
                    } else {
                        System.out.println("You have already interacted with this cat");
                        run(myCats);
                    }
                }
                case "a" -> {
                    System.out.print("Enter cat name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter cat age: ");
                    int age = sc.nextInt();
                    myCats.add(Cat.buyCat(name, age));
                    myCats = myCats.stream().sorted(Comparator.comparingInt(Cat::getOverall))
                            .collect(Collectors.toList());
                    run(myCats);
                }
                case "n" -> {
                    System.out.println("NEXT DAY");
                    myCats.forEach(cat -> cat.nextDay(cat));
                    myCats.forEach(cat -> cat.setAction(false));
                    myCats = myCats.stream().sorted(Comparator.comparingInt(Cat::getOverall))
                            .collect(Collectors.toList());
                    run(myCats);
                }
                default -> {
                    System.out.println("Wrong input");
                    run(myCats);
                }
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Wrong input");
            run(myCats);
        }
    }
    public static void printTable(List<Cat> cats){
        System.out.println("--+-----------+-----+--------+--------+--------+--------------+");
        System.out.println("# |\t\t  name| age | health |  mood  | hunger | average level|");
        System.out.println("--+-----------+-----+--------+--------+--------+--------------+");
        List<Cat> sortedCats = cats.stream()
                .sorted(Comparator.comparingInt(Cat::getOverall))
                .toList();
        sortedCats.forEach(e -> System.out.printf("%s | %10s|%5s|%8s|%8s|%8s|%14s|%n", sortedCats.indexOf(e)+1, e.getName(), e.getAge(), e.getHealth(), e.getMood(), e.getHunger(), e.getOverall()));
        System.out.println("--+-----------+-----+--------+--------+--------+--------------+");
    }
}