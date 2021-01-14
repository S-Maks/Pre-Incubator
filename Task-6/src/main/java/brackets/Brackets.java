package brackets;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Data
public class Brackets {
    private static List<String> result;

    private String str;

    public Brackets(String str) {
        this.str = str;
        result = new ArrayList<>();
    }

    public void start() {
        try {
            if (checkBrackets()) {
                System.out.println("The brackets are placed correctly");
            } else {
                throw new IncorrectBrackets();
            }
        } catch (IncorrectBrackets ex) {
            ex.printStackTrace();
        }
    }

    private boolean checkBrackets() throws IncorrectBrackets {
        List<String> test = Arrays.stream(str.split(""))
                .parallel()
                .filter(str -> str.equals("<")
                        || str.equals(">")
                        || str.equals("{")
                        || str.equals("}")
                        || str.equals("(")
                        || str.equals(")")
                        || str.equals("[")
                        || str.equals("]"))
                .collect(Collectors.toList());
        test.forEach(s -> {
            if (s.equals("<") || s.equals("{") || s.equals("(") || s.equals("[")) {
                result.add(s);
            } else {
                result.removeIf(String -> result.get(result.size() - 1).equals("<") & s.equals(">"));
                result.removeIf(String -> result.get(result.size() - 1).equals("[") & s.equals("]"));
                result.removeIf(String -> result.get(result.size() - 1).equals("{") & s.equals("}"));
                result.removeIf(String -> result.get(result.size() - 1).equals("(") & s.equals(")"));
            }
        });
        return result.size() == 0;//check the same number of opening and closing brackets
    }
}
