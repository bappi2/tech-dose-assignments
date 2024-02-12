package org.mmefta.javastreamdemo.customfuncinterface;

interface Calculator {
    // void switchOn();

    // void sum (int x);

    int substract(int a, int b);
}
/* public class CalculatorImpl implements Calculator{
    public static void main(String[] args) {
        Calculator callc = new CalculatorImpl();
        callc.switchOn();

        // () -> {body}
    }

    @Override
    public void switchOn() {
        System.out.println("Switch On");
    }
} */

public class CalculatorImpl {
    public static void main(String[] args) {

       /* Calculator calc = () -> System.out.println("Switch On");
        calc.switchOn();*/

        /*Calculator calc = x -> System.out.println("Sum is " + x );
        calc.sum(12);
*/
        /*Calculator calc = (a, b) -> b - a;
        System.out.println(calc.substract(8, 20));
*/
        Calculator calc = (a, b) -> {
            if (b < a) {
                throw new RuntimeException("b cannot be smaller than a");
            }
            else {
                return b - a;
            }
        };
        System.out.println(calc.substract(8, 20));
    }
}


