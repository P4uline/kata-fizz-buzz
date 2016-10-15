package fr.arolla.kata.fizzbuzz;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by pauline on 13/10/16.
 */
public class FizzBuzzTest {


    private FizzBuzz underTest = new FizzBuzz();

    // alt + enter -> raccourci generique
    // alt + insert -> creation d'une methode de test
    @Test
    public void should_return_0_if_param_is_0() throws Exception {
        assertThat(underTest.fizzBuzz(0)).isEqualTo("0");
    }

    // faire rater le test : on s'assure que le test sert à quelque chose.
    @Test
    public void should_return_1_if_param_is_1() {
        assertThat(underTest.fizzBuzz(1)).isEqualTo("1");
    }

    @Test
    public void should_return_fizz_if_param_is_3() throws Exception {
        assertThat(underTest.fizzBuzz(3)).isEqualTo("fizz");
    }

    @Test
    public void should_return_buzz_if_param_is_5() throws Exception {
        assertThat(underTest.fizzBuzz(5)).isEqualTo("buzz");
    }

    @Test
    public void should_return_fizzbuzz_if_param_is_multiple_of_3_and_5() {
        assertThat(underTest.fizzBuzz(15)).isEqualTo("fizzbuzz");
    }
}
