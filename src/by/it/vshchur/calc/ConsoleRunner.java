package by.it.vshchur.calc;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer=new Printer();
        Parser parser=new Parser();

        Scanner scanner=new Scanner(System.in);

        for(;;){
            String expression=scanner.nextLine();
            if (expression.equals("end"))
                break;
            Var var = null;
            try {
                var = parser.calc(expression);
                printer.print(var);
            } catch (CalcException e) {
                System.out.println("Ошибка в "+expression);
                System.out.println(e.getMessage());
            }

        }
    }
}