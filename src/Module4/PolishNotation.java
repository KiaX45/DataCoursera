package Module4;

public class PolishNotation {

    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int index = 0;
        //existen dos posibilidades que sea un numero o una operación
        //los numeros se guardan pero con las operaciones se toman los dos ultimos numeros y se aplica la operación en cuestion
        for (String elemento: tokens) {
            try{
                int value = Integer.parseInt(elemento);
                stack[index] = value;
            }catch (Exception e){
                //si no se pudo convertir a intero significa que es una operación
                //tomamos los dos ultimos numeroes de la pila
                int result = operate(elemento, stack[index], stack[index--]);
                index --;
                stack[index] = result;

            }
            index ++;
        }
        return stack[index];

    }

    public int operate(String operator, int number1, int number2){
        switch (operator){
            case "+" : return number1 + number2;
            case "-" : return number1 - number2;
            case "*" : return number1 * number2;
            case "/" : return number1 / number2;
            default : System.out.println("Opción invalida"); return 0;
        }
    }


}
