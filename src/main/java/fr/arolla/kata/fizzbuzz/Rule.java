package fr.arolla.kata.fizzbuzz;

/**
 * Created by pauline on 13/10/16.
 */
public class Rule {

    private final int multiple;
    private final String value;

    public Rule(int multiple, String value) {
        this.multiple = multiple;
        this.value = value;
    }

    boolean worksOn(int number) {
        return number % multiple == 0;
    }

    @Override
    public String toString() {
        return value;
    }
}
