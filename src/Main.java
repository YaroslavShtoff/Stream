import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        findMinMax(Stream.of(4, 2, 3, 1), Comparator.naturalOrder(), (min, max) -> System.out.println("Min: "+min+". "+"Max: "+max));

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(countEvenNums(list));
    }

    public static void findMinMax(Stream<Integer> stream, Comparator<Integer> order, BiConsumer<Integer, Integer> minMaxConsumer){
        try{
            List<Integer> list = stream.sorted(order).collect(Collectors.toList());
            int min = list.get(0);
            int max = list.get(list.size()-1);
            minMaxConsumer.accept(min, max);
        }
        catch (IndexOutOfBoundsException e){
            minMaxConsumer.accept(null, null);
        }
    }

    public static int countEvenNums(ArrayList<Integer> list){
        List<Integer> evenList = list.stream().filter(x -> x%2 == 0).collect(Collectors.toList());
        return evenList.size();
    }
}