import java.util.Random;
import java.util.Scanner;

public class hw3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("В какую игру желаете сыграть?");
        System.out.println("1 - Угадайка. \n2 - Поле Чудес. \nЛюбая другая - выход.");
        System.out.print("Ваш ответ: ");
        int ent = sc.nextInt();
        if(ent == 1){
            gameGuessing();
        } else if (ent == 2){
            gameFieldDreams();
        }
        sc.close();
    }
    public static void gameGuessing(){
        //#1
        System.out.println("Добро пожаловать в игру \"Угадайка\"");
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int hiddenNumber = rnd.nextInt(10);
        int count = 1;
        boolean exit = false;
        while (true){
            if (exit){
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет " );
                int retry = sc.nextInt();
                if (retry == 1){
                    count = 1;
                    exit = false;
                    hiddenNumber = rnd.nextInt(10);
                } else if(retry == 0){
                    break;
                } else{
                    continue;
                }
            }
            System.out.print("Введите ваш ответ: " );
            int enteredNumber = sc.nextInt();
            if (hiddenNumber == enteredNumber){
                System.out.printf("Вы угадали число %d c попытки: %d ", hiddenNumber,count);
                System.out.println();
                exit = true;
            } else if(enteredNumber > hiddenNumber){
                System.out.println("Введенное число больше загаданного.");
                count++;
            } else {
                System.out.println("Введенное число меньше загаданного.");
                count++;
            }
            if (count == 4 ){
                System.out.printf("Вы проиграли. Загаданное число %d \n",hiddenNumber);
                exit = true;
            }
        }

        sc.close();
    }
    public static void gameFieldDreams(){
        //#2
        Scanner sc = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру \"Поле чудес\"");
        String [] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random rnd = new Random();
        String hiddenWord = words[rnd.nextInt(words.length)];

        boolean exit = false;
        while (!exit) {
            System.out.println("Введите слово (выход - q):");
            String enteredWord = sc.next();
            if (hiddenWord.equals(enteredWord)) {
                System.out.println("Поздравляю! Вы угадали слово!");
                exit = true;
            } else if (enteredWord.equals("q")) {
                break;
            } else {
                StringBuilder prompt = new StringBuilder();
                for (int i = 0; i < 15; i++) {
                    if (i >= hiddenWord.length() || i >= enteredWord.length()) {
                        prompt.append('#');
                        continue;
                    }
                    char ch = hiddenWord.charAt(i);
                    if (ch == enteredWord.charAt(i)) {
                        prompt.append(ch);
                    } else {
                        prompt.append('#');
                    }
                }
                System.out.println(prompt);
            }
        }
        sc.close();
    }
}
