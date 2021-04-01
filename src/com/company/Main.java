package com.company;
import java.util.Scanner;
import static java.lang.Character.isDigit;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a Line: ");
        String startLine = in.nextLine();
        StringBuffer line = new StringBuffer(startLine);
        int i = 0;


        if(validityCheck(startLine)==true) {
            while (i < line.length()) {

                if (isDigit(line.charAt(i)) == false) {
                    i++;
                } else {
                    brackets(line, i, Character.digit(line.charAt(i), 10));
                }
            }
            System.out.println(line);

            in.close();
        }
    }

    public static boolean validityCheck(String line){
        int count = 0;
        for(int i = 0;i < line.length();i++) { // проверям чтобы скобки и числа встречались  в нужном порядке
            if (isDigit(line.charAt(i)) == true && line.charAt(i + 1) == '[') {
                count++;
            }
            if (line.charAt(i) == ']') {
                count = count - 1;
            }
            if (((line.charAt(i) >= 'a') && (line.charAt(i) <= 'z')) || ((line.charAt(i) > '1') && (line.charAt(i) <= '9')) || (line.charAt(i) == ']') || (line.charAt(i) == '[')) {
            }
            else count--;
        }
        if (count < 0) { System.out.println("incorrect string");return false; }
        else return true;
    }


    public static StringBuffer brackets(StringBuffer line, int i, int number){
        line.delete(i,i+2);//удаляем число и левую скобку

        String finishLine = "";
        while (line.charAt(i)!=']'){
            if (isDigit(line.charAt(i)) == false){
                finishLine = finishLine + line.charAt(i);
                i++;

            }
            else{
                brackets(line,i,Character.digit(line.charAt(i),10));}//запускаем в методе тот же метод для работы с повторными строками
        }
        line.delete(i,i+1);// удаляем правою скобку

        for(int k = 1;k < number-1;k++){
            finishLine = finishLine + finishLine;
            }
        line.insert(i,finishLine);
        return line;
        }

    }