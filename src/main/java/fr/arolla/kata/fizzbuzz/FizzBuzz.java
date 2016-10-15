package fr.arolla.kata.fizzbuzz;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.valueOf;

/**
 * Created by pauline on 13/10/16.
 */
public class FizzBuzz {

    /**
     * etape 1
     * @param number
     * @return
     */
    /*public String fizzBuzz(int number) {
        return "0";
    }*/


    /**
     * etape 2
     * @param number
     * @return
     */

    /*public String fizzBuzz(int number) {
        if(number == 0) {
            return "0";
        }
        return "1";
    }*/

    /**
     * etape 3 : on fait trianguler les cas -> faire émmaerger un pattern ou un design, on pourra refactorer et on aura une couverture suffisante pour ne pas avoir de regressions
     * @param number
     * @return
     */
    /*public String fizzBuzz(int number) {
        if(number == 0) {
            return "0";
        }
        if (number == 3) {
            return "fizz";
        }
        return "1";
    }*/

    /**
     * etape 4 : refactoring -> on peut changer le code mais il ne doit pas faire plus que ce qu'on test !!!!
     *
     */
    /*public String fizzBuzz(int number) {
        if (number == 0) {
            return "0";
        }
        if (number % 3 == 0) {
            return "fizz";
        }
        return String.valueOf(number);
    }*/

    /**
     * etape 5 : should_return_buzz_if_param_is_5
     * @param number
     * @return
     */
    /*public String fizzBuzz(int number) {
        if (number == 0) {
            return "0";
        }
        if (number % 3 == 0) {
            return "fizz";
        }
        if (number % 5 == 0) {
            return "buzz";
        }

        return String.valueOf(number);
    }*/

    /**
     * etape 6
     * @param number
     * @return
     */
    /*public String fizzBuzz(int number) {
        if (number == 0) {
            return "0";
        }
        if (number % 3 == 0 && number % 5 == 0) {
            return "fizzbuzz";
        }
        if (number % 3 == 0) {
            return "fizz";
        }
        if (number % 5 == 0) {
            return "buzz";
        }

        return String.valueOf(number);
    }*/

    /**
     * etape 7 : refactoring
     * @param number
     * @return
     */
    /*public String fizzBuzz(int number) {
        if (number == 0) {
            return "0";
        } else {
            StringBuilder sb = new StringBuilder();

            if (number % 3 == 0) {
                sb.append("fizz");
            }
            if (number % 5 == 0) {
                sb.append("buzz");
            }

            // ctrl + alt + v -> créer une variable, prendra toutes les occurence
            // ctrl + alt + f -> pour un champs
            // ctrl + alt + c -> pour une constante
            String s = sb.toString();
            if (s.isEmpty()) {
                return valueOf(number);
            }
            return s;
        }
    }*/

    /**
     * etape 8 : plus de refactorign avec les stream et les lambdas !!!
     * AVANTAGE : si on veut ajouter une nouvelle regle : exemple % 7 -> "fix", il suffit d'ajouter une rule.
     * Dans la version précédente, ajouter un test, ça alourdit le code, c'est pas clean.
     */
    public String fizzBuzz(int number) {
        // ctrl + alt + n  sur les rules -> pour inliner
        Stream<Rule> rules = Stream.of(new Rule(3, "fizz"), new Rule(5, "buzz"));
        String s = rules.filter(ruleAppliesTo(number)).map(Rule::toString).collect(Collectors.joining());

        // On utilise un optional, on peut donc filtrer (on peut pas filtrer sur une chaine), si c'est pas vide, on retourne la chaine, sinon on fait le orElse c'est à dire la valeur de number.

        // monade = wrapper, fonction est pure, car on a toujours une String retournée meme en cas d'erreur.
        // la monade est un contexte qui encapsule un effet de bord.
        return Optional.of(s).filter(t -> !t.isEmpty()).filter(r -> number != 0).orElseGet(()-> valueOf(number));
    }

    private Predicate<Rule> ruleAppliesTo(int number) {
        return r -> r.worksOn(number);
    }

    // voir SOLID


}
