import java.util.*;
import java.io.*;

public class Lychrel{
    public static void main(String[]args){
        int numero = Integer.parseInt(args[0]);
        do{
            numero = numero + calcolaNumeroSpeculare(numero);
            System.out.println(numero);
        }while(isPalindromo(numero) == false);
        
    }

    public static boolean isPalindromo(int numero){
        String stringaNumero = String.valueOf(numero);
        for(int i = (stringaNumero.length()) - 1; i >= ((stringaNumero.length()) - 1)/2; i--){
            if (stringaNumero.charAt(i) != stringaNumero.charAt((stringaNumero.length() - 1) - i)){
                return false;
            }
        }
        return true;
    }

    public static int calcolaNumeroSpeculare(int numero){
    String speculare = "";
    String numeroEntrante = String.valueOf(numero);
    for(int i = (numeroEntrante.length()) - 1; i >= 0; i--){
        speculare = speculare + numeroEntrante.charAt(i);
    }
    return Integer.parseInt(speculare);
}
}

