

public class Expression {

public static void main(String[] srg) {

    String expr = "5 * 3 + 2 * 7 + 4 * 4 * 1 + 2 * 9 - 1 / 2";
    float result = evaluate(expr);

    System.out.println(result);

}

public static float evaluate(String expr) {
    expr = expr.replace(" ", ""); // Falls String die Leerzeichen enthält

    //Plus Fall
    int plusIndex = expr.lastIndexOf('+');  //lastIndexOf liefert -1 zurück, falls nichts gefunden wird
    if (plusIndex != -1) {
        float leftResult = evaluate(expr.substring(0, plusIndex));
        float rightResult = evaluate(expr.substring(plusIndex + 1));
        return leftResult + rightResult;
    }

    //Minus Fall
    int minusIndex = expr.lastIndexOf('-');
    if (minusIndex != -1) {
        float leftResult = evaluate(expr.substring(0, minusIndex));
        float rightResult = evaluate(expr.substring(minusIndex + 1));
        return leftResult - rightResult;
    }

    //Multiplikation Fall
    int multiplyIndex = expr.lastIndexOf('*');
    if (multiplyIndex != -1) {
        float leftResult = evaluate(expr.substring(0, multiplyIndex));
        float rightResult = evaluate(expr.substring(multiplyIndex + 1));
        return leftResult * rightResult;
    }

    //Division Fall
    int divisionIndex = expr.lastIndexOf('/');
    if (divisionIndex != -1) {
        float leftResult = evaluate(expr.substring(0, divisionIndex));
        float rightResult = evaluate(expr.substring(divisionIndex + 1));
        return leftResult / rightResult;
    }

    // Basisfall - einmalige Zahl
    return Float.parseFloat(expr);
}

}







