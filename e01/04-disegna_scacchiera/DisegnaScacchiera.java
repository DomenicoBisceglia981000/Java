/*
Scrivere un programma che, dato un numero intero positivo N nel flusso di ingresso, 
emetta nel flusso di uscita una scacchiera (da dama, o scacchi) 
in cui ciascuna casella nera è rappresentata da un quadrato di N x N cancelletti ('#') 
e ogni casella bianca da uno di N x N segni meno ('-').

Si ricorda che le scacchiere da dama, o scacchi, sono composte da otto righe e otto colonne 
di caselle alternativamente bianche o nere, e che la prima casella in alto a sinistra è occupata da una casella bianca.
*/
import java.util.*;

public class DisegnaScacchiera{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        stampaScacchiera(n);
    }

    static int calcolaNumeroRighe(int numeroInserito){
        return numeroInserito * 8;
    }

    static int calcolaNumeroColonne(int numeroInserito){
        return numeroInserito * 8;
    }
    
    static void stampaScacchiera(int n){
        boolean cambio = true;
        int numeroRighe = calcolaNumeroRighe(n);
        int numeroColonne = calcolaNumeroRighe(n);
        for(int riga = 0; riga < numeroRighe; riga++){
            if (riga % n == 0){
                if (cambio == true){
                    cambio = false;
                }else{
                    cambio = true;
                }
            }
            for(int colonna = 0; colonna < numeroColonne; colonna++){
                if (colonna % n == 0 && colonna != numeroColonne - 1){
                    if (cambio == true){
                        cambio = false;
                    }else{
                        cambio = true;
                    }
                }
                if (cambio == true){
                    System.out.print("-");
                }else{
                    System.out.print("#");
                }
            }
            System.out.print("\n");
        }
    }

}