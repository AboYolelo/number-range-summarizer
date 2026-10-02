package numberrangesummarizer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class NumberListParser {

    private static final String DELIMITER = ",";

 
    public List<Integer> parse(String input) {
        if (input == null || input.trim().isEmpty()) {
            return Collections.emptyList();
        }
        List<Integer> numbers = Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .filter(token -> !token.isEmpty())
                .map(NumberListParser::toInteger)
                .collect(Collectors.toList());
        return Collections.unmodifiableList(numbers);
    }

    private static Integer toInteger(String token) {
        try {
            return Integer.valueOf(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Not a valid integer: '" + token + "'", e);
        }
    }
}
