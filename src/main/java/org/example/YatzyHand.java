package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class YatzyHand {
    private final static List<Integer> SMALL_STRAIGHT = List.of(1, 2, 3, 4, 5);
    private static final List<Integer> LARGE_STRAIGHT = List.of(2, 3, 4, 5, 6);
    private final List<Integer> hand;
    private final Map<Integer, Long> frequency;

    YatzyHand(int... dice) {
        if (dice.length != 5) {
            throw new IllegalArgumentException("This Yatzy played with 5 dice!");
        }

        this.hand = Arrays.stream(dice)
                .boxed()
                .collect(Collectors.toList());

        frequency = this.hand.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public int chance() {
        return intStream().sum();
    }

    public int ones() {
        return sumOf(1);
    }

    public int twos() {
        return sumOf(2);
    }

    public int threes() {
        return sumOf(3);
    }

    public int fours() {
        return sumOf(4);
    }

    public int fives() {
        return sumOf(5);
    }

    public int sixes() {
        return sumOf(6);
    }

    private int sumOf(int number) {
        return intStream()
                .filter(value -> value == number)
                .sum();
    }

    public int small() {
        int result = 0;
        if (SMALL_STRAIGHT.equals(sorted())) {
            result = 15;
        }
        return result;
    }

    public int large() {
        int result = 0;
        if (LARGE_STRAIGHT.equals(sorted())) {
            result = 20;
        }
        return result;
    }

    public int onePair() {
        return valueOfTheMostFrequent(2).orElse(0) * 2;
    }

    public int twoPair() {
        int result = 0;
        List<Integer> diceWithMoreThanTwoFrequency = dieValueFrequencyOf(2);
        if (diceWithMoreThanTwoFrequency.size() == 2) {
            result = diceWithMoreThanTwoFrequency.stream()
                    .mapToInt(Integer::intValue)
                    .sum() * 2;
        }
        return result;
    }

    public int fourOfAKind() {
        return ofAKind(4);
    }

    public int threeOfAKind() {
        return ofAKind(3);
    }

    private int ofAKind(int frequency) {
        return valueOfTheMostFrequent(frequency).orElse(0) * frequency;
    }

    public int fullHouse() {
        int result;
        Optional<Integer> threePair = valueOfTheMostFrequent(3);
        Optional<Integer> twoPair = valueOfTheMostFrequent(2);
        if (threePair.isPresent() && twoPair.isPresent()) {
            result = threePair.get() * 3 + twoPair.get() * 2;
        } else {
            result = 0;
        }
        return result;
    }

    public int yatzy() {
        return valueOfTheMostFrequent(5)
                .map(x -> 50)
                .orElse(0);
    }

    public List<Integer> dieValueFrequencyOf(int frequency) {
        return this.frequency.entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= frequency)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Optional<Integer> valueOfTheMostFrequent(int frequency) {
        return dieValueFrequencyOf(frequency).stream()
                .max(Comparator.naturalOrder());
    }

    private Stream<Integer> stream() {
        return hand.stream();
    }

    private IntStream intStream() {
        return stream().mapToInt(Integer::intValue);
    }

    private List<Integer> sorted() {
        return stream().sorted().toList();
    }
}



