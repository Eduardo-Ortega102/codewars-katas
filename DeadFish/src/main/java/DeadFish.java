import java.util.List;
import java.util.LinkedList;


public class DeadFish {
    private Integer value;
    private List<Integer> output;

    private DeadFish() {
        this.value = 0;
        this.output = new LinkedList<>();
    }

    public int[] getOutput() {
        return output.stream().mapToInt(Integer::intValue).toArray();
    }

    public void increment() {
        this.value++;
    }

    public void decrement() {
        this.value--;
    }

    public void squares() {
        this.value *= this.value;
    }

    public void addToOutput() {
        this.output.add(this.value);
    }

    public static int[] parse(String data) {
        DeadFish deadFish = new DeadFish();
        for (char command : data.toCharArray()) {
            switch(command) {
                case Command.INCREMENT:
                    deadFish.increment();
                    break;
                case Command.DECREMENT:
                    deadFish.decrement();
                    break;
                case Command.SQUARES:
                    deadFish.squares();
                    break;
                case Command.OUTPUT:
                    deadFish.addToOutput();
                    break;
                default:
                    break;
            }
        }
        return deadFish.getOutput();
    }

    private static class Command {
        public static final char INCREMENT = 'i';
        public static final char DECREMENT = 'd';
        public static final char SQUARES = 's';
        public static final char OUTPUT = 'o';
    }
}
