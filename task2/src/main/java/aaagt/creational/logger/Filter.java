package aaagt.creational.logger;

import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        return source.stream()
                .peek(num -> {
                    if (num > treshold) {
                        logger.log(String.format("Элемент \"%d\" проходит", num));
                    } else {
                        logger.log(String.format("Элемент \"%d\" не проходит", num));
                    }
                })
                .filter(num -> num > treshold)
                .toList();
    }
}
