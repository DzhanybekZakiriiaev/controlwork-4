import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Cat> myCats = Cat.generateCats();
        printTable(myCats);
    }

    public static void printTable(List<Cat> cats){
        System.out.println("--+-----------+-----+--------+--------+--------+--------------+");
        System.out.println("# |\t\t  name| age | health |  mood  | hunger | average level|");
        System.out.println("--+-----------+-----+--------+--------+--------+--------------+");
        List<Cat> sortedCats = cats.stream()
                .sorted(Comparator.comparingInt(Cat::getOverall))
                .collect(Collectors.toList());
        sortedCats.forEach(e -> System.out.printf("%s | %10s|%5s|%8s|%8s|%8s|%14s|%n", sortedCats.indexOf(e)+1, e.getName(), e.getAge(), e.getHealth(), e.getMood(), e.getHunger(), e.getOverall()));
        System.out.println("--+-----------+-----+--------+--------+--------+--------------+");
    }
}