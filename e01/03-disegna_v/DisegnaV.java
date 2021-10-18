import java.util.*;
public class DisegnaV{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int numero = scan.nextInt();
        creaStringa(numero);
    }
    static void creaStringa(int n){
        int asterischi = (2 * n) - 1;
        for(int riga = 1; riga <= n; riga++){
            String stringa = "";
            for(int colonna = 1; colonna <= asterischi; colonna++){
                if (riga == n && colonna == n){
                    stringa = stringa + "*";
                }else{
                    if (colonna == riga || colonna == asterischi - riga + 1){
                        stringa = stringa + "*";
                    }else{
                        stringa = stringa + " ";
                    }
                }
            
            }
            stampaStringa(stringa);
        }
    }


    static void stampaStringa(String s){
        System.out.println(s);
    }
}
//2 * N - 1 asterischi
