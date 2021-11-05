/**
    Gli oggetti di questa classe rappresentano polinomi sparsi
    Gli oggetti di questa classe sono immutabili
 */

 public class SparsePoly{
    /**
     * Questo record rappresenta un termine (coppia (esponente, coefficiente))
     */
    private record Term(int coeff, int degree){
        public Term{
            if(degree < 0) throw new NegativeDegreeException ("il grado dev'essere non negativo. Trovato : " + degree);
        }
     }
    //Attributi
    // I termini del polinomio. I termini sono ordinati in ordine crescente
    // (1,2), (3,4), (5,6), -> x^2 x^4 x^6
    private List<Term> term;

    //Costruttori:
    /**
     * Costruisce il polinomio zero
     */
    public SparsePoly(){
        term = new ArrayList();
    }

    /**
     * Costruisce il polinomio coeff * x ^ degree
     */
    public SparsePoly(int coeff, int degree){
        this();
        if (coeff != 0) term.add(new Term(coeff, degree));
    }

    //Metodi:
    /**
     * Pre-condizioni : non ci sono, non ha input
     * Effetti collaretali : 
     * Post- condizioni : restituisce il polinomio this + p
     */
    public int degree(){
        if(term.size() == 0) return -1;
        return ter.get(term.size() - 1).degree;
    }

    //rappresenta l'indice all'interno della lista del termine
    private int findByDegree(int degree){
        int min = 0;
        int max = term.size() -1;
        
        while(min <= max){
            int mid = (max+min)>>>1; //shift logico di 1
            if (term.get(mid).degree == degree) return mid;
            
            if (term.get(mid).degree > degree) min = mid+1;
            else max = mid - 1;
            
        }
        return -(min+1);
    }

    /**
     * Pre-condizioni : degree >= 0
     * Effetti collaretali :
     * Post- condizioni : restituisce il coefficiente di  x^degree se degree >= 0
     */
    public int coeff(int degree){
        int i = findByDegree(degree);
        if(i >= 0) return term.get(i).coeff;
        return 0
    }

    /**
     * Pre-condizioni : p diverso da null
     * Effetti collaretali :
     * Post- condizioni : restituisce il polinomio this + p
     */
    public SparsePoly sum(SparsePoly p){
        int indexThis = 0; indexP = 0;
        SparsePoly result = new SparsePoly();
        while(indexThis < term.size() && indexP < p.term.size()){
            if(term.get(indexThis).degree == term.get(indexP).degree){
                if(term.get(indexThis).degree == term.get(indexP).degree){
                    result.term.add(new Term(term.get(indexThis).coeff + p.get(indexThis).coeff, p.get(indexThis).degree));
                }
                
                indexThis++; indexP++;
            }else if((term.get(indexThis).degree < term.get(indexP).degree)){
                result.term.add(p.get(indexThis++));
            }else{
                result.term.add(p.term.get(indexP++));
            }
        }
        for(; indexThis < term.size(); indexThis++)result.term.add(term.get(indexThis));
        for(; indexP < term.size(); indexP++)result.term.add(term.get(indexP));
    }


    /**
     * Pre-condizioni : p diverso da null
     * Effetti collaretali :
     * Post- condizioni : restituisce il polinomio this * p
     */
    public SparsePoly mul(SparsePoly p){
        SparsePoly result = new SparsePoly();
        if(degree() == -1 || p.degree() == -1){
            return new result;
        }
        for(int i = 0; term.Size(); i++)
            for(int j = 0; j < p.term.size(); j++){
                int newCoeff = term.get(i).coeff * p.term.get(j).coeff;
                int newDegree = term.get(i).degree + p.term.get(j).degree;
                int index = result.findByDegree(newDegree);
                if (index >= 0) result.term.set(index, new Term(result.term.get(index).coeff + newCoeff, newDegree));
                else result.term.add(-index+1, new Term(newCoeff, newDegree));
            }
    }

    /**
     * Pre-condizioni : p diverso da null
     * Effetti collaretali :
     * Post- condizioni : restituisce il polinomio this / p
     */
    public SparsePoly diff(SparsePoly p){
        return this.sum(p.minus());
    }

    /**
     * Pre-condizioni : p diverso da null
     * Effetti collaretali :
     * Post- condizioni : restituisce il polinomio -this
     */
    public SparsePoly minus(SparsePoly p){
        SparsePoly result = new SparsePoly();

        for(int i = 0; i < term.size(); i++) 
            result.term.add(new Term(term.get(i).coeff.degree))
            return
    }

 }