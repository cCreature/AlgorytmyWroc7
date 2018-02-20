package Zajecia0302.PracaDomowa;

import java.util.Stack;

public class OdwrotnaNotacjaPolska {
    public static void main(String[] args) {
        //String wejscie = "( a + b * c - d ) / e ^ ( f + g ) / h ="; //ze względu
        String wejscie = "a * b + c * d =";
        //na problemy z parsowaniem w windowsie tak podaję przykład
        String[] inputArray = wejscie.split(" ");
        //muszę w jakiś sposób rodzielić elementy żeby było jasne
        //i zapisać do tablicy po pojedynczym znaku
        //WAŻNE dzielę ze względu na spacje to znaczy, że jeden element od drugiego
        //musi być oddzielony przez spacje

        Stack<String> stack = new Stack<>(); //tworzę stos

        String helper = "";

        for(String element : inputArray) //przechodzę po każdym elemencie listy
        {
            switch (element) //w zależności od tego jaki jest element
            {
                case "=": //jeżeli jest = oznacza, że koniec wejścia
                    //i muszę wydrukować wszystkie operatory jakie mam na stosie
                    while (!stack.empty()){
                        System.out.printf("%s", stack.pop());
                    }
                    break;

                case "(": //( po prostu wrzucam na stos
                    //później posłuży mi jako znacznik do którego mam drukować elementy
                    stack.push(element);
                    break;

                case ")": //) nie wrzucam na stos
                    //muszę wydrukować wszystkie operatory, które mam na stosie
                    //do momentu aż natrafię na (
                    helper = stack.pop();
                    while(!helper.equals("(")){
                        System.out.printf("%s", helper);
                        helper = stack.pop();
                    }
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "^": //jeżeli otrzymałem operator
                    while (!stack.empty()) //dopóki stos jest pusty
                    {
                        //wyliczam "moc operatora" jeżeli jest potęgowanie (moc 3) lub bieżący operator jest większy lub równy
                        //mocą od operatora który jest bieżąco na szczycie stosu (nie pobieram go tylko podglądam)
                        if (GetOperatorLevel(element) == 3 || GetOperatorLevel(element) >= GetOperatorLevel(stack.peek()))
                            break; //przerywam działanie pętli
                        else
                            System.out.printf("%s", stack.pop()); //jeżeli nie spełniony warunek wówczas drukuje
                        //operator ze stosu i od nowa wykonuje pętlę
                    }
                    stack.push(element); //jeżeli wyczyścił się stos lub wyszliśmy z pętli przez break
                    //wrzucam bieżący operator na stos
                    break;
                default:
                    System.out.printf("%s", element); //jeżeli to nie jest żaden z operatorów, a także ( i ) to przepisuje literkę

            }
        }
    }

    //metoda służy do "wyliczania" mocy operatora zgodnie z kolejnością wykonywania działań
    //najmniejszy priorytet mają dodawanie i odejmowanie w dalszej kolejności mnożenie i dzielenie
    //największy - potęgowanie
    private static int GetOperatorLevel(String elemet)
    {
        switch (elemet){
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            default:
                return -1;

        }
    }

}
