
/**
 * This problem was asked by Amazon.
 * At a popular bar, each customer has a set of favorite drinks, and will happily accept any drink among this set. For example, in the following situation, customer 0 will be satisfied with drinks 0, 1, 3, or 6.
 * preferences = {
 *    0: [0, 1, 3, 6],
 *    1: [1, 4, 7],
 *    2: [2, 4, 7, 5],
 *    3: [3, 2, 5],
 *    4: [5, 8]
 * }
 * A lazy bartender working at this bar is trying to reduce his effort by limiting the drink recipes he must memorize. Given a dictionary input such as the one above, return the fewest number of drinks he must learn in order to satisfy all customers.
 * For the input above, the answer would be 2, as drinks 1 and 5 will satisfy everyone.

 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Problem701 {

    public static void main(String[] args) {

        Map<Integer, Set<Integer>> preferences = new HashMap<Integer, Set<Integer>>() {
            {
                put(0, Set.of(0, 1, 3, 6));
                put(1, Set.of(1, 4, 7));
                put(2, Set.of(2, 4, 7, 5));
                put(3, Set.of(3, 2, 5));
                put(4, Set.of(5, 8));
            }
        };

        Set<Integer> drinks = solution(preferences);

        assert drinks.equals(Set.of(1, 5));

    }

    public static Set<Integer> solution(Map<Integer, Set<Integer>> drinksLookup) {
        final int TOTAL_CUSTOMERS = drinksLookup.size();
        Map<Integer, Set<Integer>> customerLookup = new HashMap<Integer, Set<Integer>>();

        drinksLookup.forEach((cust, drinkSet) -> {
            for (int drink : drinkSet) {
                Set<Integer> customers = customerLookup.getOrDefault(drink, new HashSet<Integer>());
                customers.add(cust);
                customerLookup.put(drink, customers);
            }
        });

        Set<Integer> desiredDrinks = new HashSet<>();

        int totalCustomersSatisfied = 0;
        while (totalCustomersSatisfied < TOTAL_CUSTOMERS) {

            int maxSatisfiedCustomers = Integer.MIN_VALUE;
            int mostSatisfyingDrink = Integer.MIN_VALUE;

            for (Entry<Integer, Set<Integer>> entry : customerLookup.entrySet()) {
                int drink = entry.getKey();
                Set<Integer> customers = entry.getValue();
                if (customers.size() > maxSatisfiedCustomers) {
                    maxSatisfiedCustomers = customers.size();
                    mostSatisfyingDrink = drink;
                }
            }

            desiredDrinks.add(mostSatisfyingDrink);
            totalCustomersSatisfied += maxSatisfiedCustomers;

            Set<Integer> alreadySatisfiedCustomers = customerLookup.get(mostSatisfyingDrink);
            customerLookup.forEach((drink, customers) -> customers.removeAll(alreadySatisfiedCustomers));
        }

        return desiredDrinks;
    }
}
