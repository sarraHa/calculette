import java.util.*;

/** 
 * Tables des symboles :
 *     _ Une table pour les variables globales; et,
 *     _ une pour les variables locales.
 *
 *     Chaque table donne pour chaque variable sa position, donc son adresse dans la pile.
 *     On recherche d'abord en local, si défini. Comme on manipule des variables typées, on stocke également le type.
 *     On utlise ici des tables de hachage stockant des objets AdresseType.
 *
 * Pour autoriser un fonction et une variable de même nom, on ajoute aussi :
 *     _ Une Table des étiquettes des fonctions.
 *
 * Note : une pile de tables pourrait être nécessaire,
 *        si on voulait pouvoir définir des fonctions dans des fonctions...
 */
class TablesSymbolesFonction {
    
	public List<TableSymboleFonction> list = new ArrayList<TableSymboleFonction>();
    	
    public boolean nouvelleFonction(String fonction, int label, String t) {
        
	    // il faut que je parcout tout la listes des fonctions et je regarde si cette fonction existe deja 
	  
	    Iterator<TableSymboleFonction> iter = list.iterator(); 
	    
	    while(iter.hasNext()){
	    		
	    	TableSymboleFonction f = iter.next();
	    	
	    	if( f.getIdent().equals( fonction ) && f.getType().equals( t ) ){
	    		
	    		 System.err.println("Fonction \""+ fonction + "\" déjà définie avec type de retour \"" + t +"\".");
	    		 System.exit(0);
	    		 return false;
	    	}
	    }
	    
	    TableSymboleFonction nouvelleFonc = new TableSymboleFonction( fonction , label , t);
	    list.add( nouvelleFonc );
		return true;
	   
	}
    
    public AdresseType getFonction(String fonction) {
    	
	    Iterator<TableSymboleFonction> iter = list.iterator(); 
	    
	    while(iter.hasNext()){
	    		
	    	TableSymboleFonction f = iter.next();
	    	
	    	if( f.getIdent().equals( fonction )  ){
	
	    		 return f.getAdresseTypeFonc();
	    	}
	    }
	    
    	System.err.println("Appel à une fonction non définie \""+fonction+"\"");
		System.exit(0);
    	return null;
    }
    
    public TableSymboles getTablevar( String foncActuelle, String typeFoncActuelle ){
    	
	    Iterator<TableSymboleFonction> iter = list.iterator(); 
	    
	    while(iter.hasNext()){
	    		
	    	TableSymboleFonction f = iter.next();
	    	
	    	if( f.getIdent().equals( foncActuelle ) && f.getType().equals( typeFoncActuelle )   ){
	
	    		 return f.getTablevar();
	    	}
	    }
	    
    	System.err.println("Appel à une fonction non définie \""+typeFoncActuelle+"\"");
		System.exit(0);
    	return null;
    }
    
    public void putVarFonction(String foncActuelle, String typeFoncActuelle , String s, String t) { 
    	
	    Iterator<TableSymboleFonction> iter = list.iterator(); 
	    
	    while(iter.hasNext()){
	    		
	    	TableSymboleFonction f = iter.next();
	    	
	    	if( f.getIdent().equals( foncActuelle ) && f.getType().equals( typeFoncActuelle )   ){
	
	    		// j'ajoute une var
	    		f.addVar(s, t );
	    		
	    	}
	    }
	    
    
    }
    
    public  AdresseType getAdresseTypeFonction(String foncActuelle, String typeFoncActuelle, String symbol) {
  	
	    Iterator<TableSymboleFonction> iter = list.iterator(); 

	    while(iter.hasNext()){
	    		
	    	TableSymboleFonction f = iter.next();
	    	
	    	if( f.getIdent().equals( foncActuelle ) && f.getType().equals( typeFoncActuelle )   ){
	

	    		// j'ajoute une var
	    		///// iciiiiiiiiiiiiiiiiii
	    		return f.getAdresseType( symbol );
	    		
	    	}
	    }
	    System.err.println("Variable non retouvé ");
  		return null;
    }
     


    public void majVarFonc( String foncActuelle, String typeFoncActuelle ) {
    	
    	Iterator<TableSymboleFonction> iter = list.iterator(); 
	    
	    while(iter.hasNext()){
	    		
	    	TableSymboleFonction f = iter.next();
	    	
	    	if( f.getIdent().equals( foncActuelle ) && f.getType().equals( typeFoncActuelle )   ){
	
	    		
	    		f.getTablevar().majVar();
	    		return;
	    		
	    	}
	    }
    	
	    System.err.println("Fonction non retouve ");
	    System.exit(0);
  	

    }
  
    public int nbVarFonction( String foncActuelle, String typeFoncActuelle ) { 
      	
    	Iterator<TableSymboleFonction> iter = list.iterator(); 
	    
	    while(iter.hasNext()){
	    		
	    	TableSymboleFonction f = iter.next();
	    	
	    	if( f.getIdent().equals( foncActuelle ) && f.getType().equals( typeFoncActuelle )   ){
	
	    		
	    		return f.getTablevar().taille;
	    		
	    	}
	    }
	    
	    System.err.println("Fonction non retouve ");
	    System.exit(0);
	    return 0;
    }














}





