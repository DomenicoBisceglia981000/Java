/*
avendo in input un numero
prendiamo le cifre di n, le ordiniamo in ordine decrescente e 
sottraiamo al numero ottenuto il numero ordinato in ordine crescente

continuando a svolgere l'operazione, ad un certo punto si arriva a 6174
*/
import java.util.Arrays;
import java.util.Scanner;
import java.
public class Kaprekar{


//    static void sort(byte[] a){ //ordinamento
        /*
        * Pre-Condizioni : 
        * Post-Condizioni : 
        * Effetti Collaterali : 
        */
//    }  

    static void reverse(byte[] a){  //posso effettuare dei cambi direttamente sul vettore in input, senza dover fare la return
        /*
        * Pre-Condizioni : a non null
        * Post-Condizioni : al termine della procedura a conterrà il suo reversal
        * Effetti Collaterali : a potrebbe essere modificato
        */
        for(int i = 0; i < a.length/2; i++){
            byte tmp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = tmp;
        }


    }

    static int digitsToNum(byte[] a){
        /*
        * Pre-Condizioni : a non null, ciascuna posizione di a deve contenere un numero compreso tra 0 e 9 (inclusi)
        * Post-Condizioni : restituisce l'intero le cui cifre sono rappresentate dai numeri memorizzati in a
        * Effetti Collaterali : 
        */
        int n = 0;
        for (int i = a.length -1 ; i >= 0; i++){
            n *= 10;
            n += a[i];
        }
        return n;

    }

    static byte[] numToDigits(int n, int digits){
        /*
        * Pre-Condizioni : digits > 0, digits == cifre di n, n >= 0
        * Post-Condizioni : restituisce un array contenente le cifre di n
        * Effetti Collaterali : 
        */
        byte[] a = new byte[digits];
        for(int i = 0; i < digits; i++){
            a[i] = (byte) (n % 10);
            n /= 10;
        }
        return a;
    }

    static int nextKaprekar(int n){
        /*
        * Pre-Condizioni : 0 <= n <= 9999, deve avere almeno due cifre diverse 
        * Post-Condizioni : restituisce il numero successivo della sequenza Kaprekar
        * Effetti Collaterali : 
        */
        byte[] a = numToDigits(n, 4);
        Arrays.sort(a);
        n = digitsToNum(a);
        reverse(a);
        n += digitsToNum(a);    
        return n;
        }

    static void printKaprekar(int n){
        /*
        * Pre-Condizioni : 0 <= n <= 9999, deve avere almeno due cifre diverse
        * Post-Condizioni : stampa la sequenza di Kaprekar a partire dal numero n
        * Effetti Collaterali : System.out viene modificato
        */

        if(n < 0 || n > 9999) throw new IllegatArgumentException("L'input deve essere compreso tra 0 e 9999. \nTrovato: " + n);
        //ILLEGAL ARGUMENT 
        

        while(n != 6174){
            System.out.println(n);
            n = nextKaprekar(n);
        }
        System.out.println(n);
    }

    public static void main(String[]args){

        Scanner s;
        InputStream is;
        try{
            URL u = new URL("https://etcetc").openStreams();
        }catch(MalformedURLException e){
            is = System.in;
        }catch(IOException e){
            is = System.in;
        }
        Scanner s = new Scanner(is)
        
        
        printKaprekar(numero);
    }

}