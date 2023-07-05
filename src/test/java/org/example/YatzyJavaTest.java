package org.example;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class YatzyJavaTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        Assertions.assertThat(new YatzyHand(2, 3, 4, 5, 1).chance()).isEqualTo(15);
        Assertions.assertThat(new YatzyHand(3, 3, 4, 5, 1).chance()).isEqualTo(16);
    }

    @Test
    public void yatzy_scores_50() {
        Assertions.assertThat(new YatzyHand(4, 4, 4, 4, 4).yatzy()).isEqualTo(50);
        Assertions.assertThat(new YatzyHand(6, 6, 6, 6, 6).yatzy()).isEqualTo(50);
        Assertions.assertThat(new YatzyHand(6, 6, 6, 6, 3).yatzy()).isEqualTo(0);
    }

    @Test
    public void test_1s() {
        Assertions.assertThat(new YatzyHand(1, 2, 3, 4, 5).ones()).isEqualTo(1);
        Assertions.assertThat(new YatzyHand(1, 2, 1, 4, 5).ones()).isEqualTo(2);
        Assertions.assertThat(new YatzyHand(6, 2, 2, 4, 5).ones()).isEqualTo(0);
        Assertions.assertThat(new YatzyHand(1, 2, 1, 1, 1).ones()).isEqualTo(4);
    }

    @Test
    public void test_2s() {
        Assertions.assertThat(new YatzyHand(1, 2, 3, 2, 6).twos()).isEqualTo(4);
        Assertions.assertThat(new YatzyHand(2, 2, 2, 2, 2).twos()).isEqualTo(10);
    }

    @Test
    public void test_threes() {
        Assertions.assertThat(new YatzyHand(1, 2, 3, 2, 3).threes()).isEqualTo(6);
        Assertions.assertThat(new YatzyHand(2, 3, 3, 3, 3).threes()).isEqualTo(12);
    }

    @Test
    public void fours_test() {
        Assertions.assertThat(new YatzyHand(4, 4, 4, 5, 5).fours()).isEqualTo(12);
        Assertions.assertThat(new YatzyHand(4, 4, 5, 5, 5).fours()).isEqualTo(8);
        Assertions.assertThat(new YatzyHand(4, 5, 5, 5, 5).fours()).isEqualTo(4);
    }

    @Test
    public void fives() {
        Assertions.assertThat(new YatzyHand(4, 4, 4, 5, 5).fives()).isEqualTo(10);
        Assertions.assertThat(new YatzyHand(4, 4, 5, 5, 5).fives()).isEqualTo(15);
        Assertions.assertThat(new YatzyHand(4, 5, 5, 5, 5).fives()).isEqualTo(20);
    }

    @Test
    public void sixes_test() {
        Assertions.assertThat(new YatzyHand(4, 4, 4, 5, 5).sixes()).isEqualTo(0);
        Assertions.assertThat(new YatzyHand(4, 4, 6, 5, 5).sixes()).isEqualTo(6);
        Assertions.assertThat(new YatzyHand(6, 5, 6, 6, 5).sixes()).isEqualTo(18);
    }

    @Test
    public void one_pair() {
        Assertions.assertThat(new YatzyHand(3, 4, 3, 5, 6).onePair()).isEqualTo(6);
        Assertions.assertThat(new YatzyHand(5, 3, 3, 3, 5).onePair()).isEqualTo(10);
        Assertions.assertThat(new YatzyHand(5, 3, 6, 6, 5).onePair()).isEqualTo(12);
    }

    @Test
    public void two_Pair() {
        Assertions.assertThat(new YatzyHand(3, 3, 5, 4, 5).twoPair()).isEqualTo(16);
        Assertions.assertThat(new YatzyHand(3, 3, 5, 5, 5).twoPair()).isEqualTo(16);
        Assertions.assertThat(new YatzyHand(1, 2, 3, 4, 5).twoPair()).isEqualTo(0);
        Assertions.assertThat(new YatzyHand(3, 3, 3, 3, 5).twoPair()).isEqualTo(0);
    }

    @Test
    public void three_of_a_kind() {
        Assertions.assertThat(new YatzyHand(3, 3, 3, 4, 5).threeOfAKind()).isEqualTo(9);
        Assertions.assertThat(new YatzyHand(5, 3, 5, 4, 5).threeOfAKind()).isEqualTo(15);
        Assertions.assertThat(new YatzyHand(3, 3, 3, 3, 5).threeOfAKind()).isEqualTo(9);
    }

    @Test
    public void four_of_a_knd() {
        Assertions.assertThat(new YatzyHand(3, 3, 3, 3, 5).fourOfAKind()).isEqualTo(12);
        Assertions.assertThat(new YatzyHand(5, 5, 5, 4, 5).fourOfAKind()).isEqualTo(20);
        Assertions.assertThat(new YatzyHand(3, 3, 3, 3, 3).fourOfAKind()).isEqualTo(12);
    }

    @Test
    public void smallStraight() {
        Assertions.assertThat(new YatzyHand(1, 2, 3, 4, 5).small()).isEqualTo(15);
        Assertions.assertThat(new YatzyHand(2, 3, 4, 5, 1).small()).isEqualTo(15);
        Assertions.assertThat(new YatzyHand(1, 2, 2, 4, 5).small()).isEqualTo(0);
        Assertions.assertThat(new YatzyHand(2, 3, 4, 5, 6).small()).isEqualTo(0);

    }

    @Test
    public void largeStraight() {
        Assertions.assertThat(new YatzyHand(6, 2, 3, 4, 5).large()).isEqualTo(20);
        Assertions.assertThat(new YatzyHand(2, 3, 4, 5, 6).large()).isEqualTo(20);
        Assertions.assertThat(new YatzyHand(1, 2, 2, 4, 5).large()).isEqualTo(0);
        Assertions.assertThat(new YatzyHand(1, 2, 3, 4, 5).large()).isEqualTo(0);
    }

    @Test
    public void fullHouse() {
        Assertions.assertThat(new YatzyHand(6, 2, 2, 2, 6).fullHouse()).isEqualTo(18);
        Assertions.assertThat(new YatzyHand(2, 3, 4, 5, 6).fullHouse()).isEqualTo(0);
    }
}
