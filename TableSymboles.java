import java.util.*;
 

public class TableSymboles {

    // A hash table to recall global variables that have been declared so far
    // A variable is represented by its name.
    // We assume that named are not reused, i.e. we can not have a variable x that is both an int and a float.
    private LinkedHashMap<String, AdresseType> table = new LinkedHashMap<String, AdresseType>();

    public AdresseType getAdresseType(String s) {  return table.get(s); }
    
    // n is a short hand for next free address :)
    private int n = 0;
    
    // pour les fonction
    public int taille = table.size();
    
    // returns the next available address that is available to store a global variable (initially 0).
    public Integer getTaille() { return n;}

    public void putVar(String s, String t) {
	   
    	// ********************* ajouter**********************************
	    if( table.get(s) != null && getAdresseType(s).type.equals( t ) ){
	    
		    System.err.println("Erreur : Variable \""+ s + "\" de type " + table.get(s).type + " déjà définie");    
	    }
		//if (table.get(s) != null)
	   //  System.err.println("Erreur : Variable \""+ s + "\" de type " + table.get(s).type + " déjà définie");
		else 
		{
		    AdresseType at = new AdresseType(n,t);
		    // nom de la var et adresse
		    table.put(s, at);
		    n+=AdresseType.getSize(t);
		}
		// je dois ajouter icii une fonction qui supprime en fin

   }
    
    public void supprimedernierVal(){
    	
    	 Iterator iterator = table.entrySet().iterator();
    	 
    	while (iterator.hasNext()) { 
    	 
    	 if ( iterator.next() == null) {
    	    
    		  // iterator.remove(); // Note bien ici sur quelle instance on appelle remove()
    	   }
    	}
    	
    	iterator.remove();
    	
    	
    }
    
    public String toString() { return table.toString(); }
    
    /******** FONCTION ******/
    public void majVar() {
    	
    	taille = table.size() ;
    	for (Map.Entry<String , AdresseType> entry : table.entrySet()) {
    		 AdresseType a = entry.getValue();
    		 a.adresse = a.adresse - (taille + 2) ;
    		//************ je ne sais si j'ajoute un truc ici ou pas 
    	}
    
    }
    
    public void	addParamFonc(String s){ 
    			
    	AdresseType a = table.get(s);
    	a.paramFonc = 1;
    }

    
    
    
    
}
    

