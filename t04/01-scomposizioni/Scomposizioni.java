/*
Bisceglia Domenico;
Mat : 981000;

Scomposizioni 1a versione;
*/

import java.util.*;
import static java.lang.String.*;

public class Scomposizioni{
    public static void main(String[]args){
        int numeroLetto = Integer.parseInt(args[0]);
        List<Integer> primiConosciuti = new LinkedList<Integer>();
        for(int num = 2; num <= numeroLetto; num ++){
            List<Integer> fattori = new LinkedList<Integer>();
            int salvaNumero = num;
            int indexDivisori = 2;
            while (salvaNumero > 1){
                boolean giaDiviso = false;
                if (num == 2){
                    primiConosciuti.add(num);
                    fattori.add(num);
                    salvaNumero = salvaNumero/indexDivisori;
                }else{
                    int indice=0;
                    for(int y:primiConosciuti){
                        indice = y;
                        if(salvaNumero%y == 0){
                            salvaNumero = salvaNumero/y;
                            fattori.add(y);
                            giaDiviso = true;
                            break;
                        }
                    }
                    if (giaDiviso == false){
                        for(int i = indice + 1; i <= salvaNumero; i++){
                            boolean nonPrimo = false;
                            for (int j = 2; j < i; j++){
                                if (i % j == 0){
                                    nonPrimo = true;
                                    break;
                                }
                            }
                            if (nonPrimo == false){
                                primiConosciuti.add(i);
                                salvaNumero = salvaNumero / i;
                                fattori.add(i);
                            }

                        }
                    }   
                }   
                indexDivisori++;
            }
            System.out.println(num + "==>" + fattori);
        }
    }
}