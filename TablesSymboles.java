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
class TablesSymboles {
   
	private TableSymboles _tableGlobale = new TableSymboles();
    private TableSymboles _tableLocale = null;
    private int numTableLocale = 0;
    private int[] nbVariableLocale = new int[20];
  
    
    // partie pour les fonctions
    private TablesSymbolesFonction tablesSymbolesFonction = new TablesSymbolesFonction(); 
    // c'est à dire on est en traine de traviller dans un bloc de fonction
    private int flagFonction = 0;
    private  String foncActuelle = null ;
    private  String typeFoncActuelle = null ;
    /************************* FONCTIONS *************************/
  
    public void ajouteNBVariable() {
    	nbVariableLocale[ numTableLocale ]++;
    }
    
    public TableSymboles newTableLocale() { 
    	numTableLocale++;
    	
    	System.out.println("numTableLocale " + numTableLocale );
    	// icii on cree plusieurs fois _tableLocale???
    	if( _tableLocale == null ){
    		
    		_tableLocale = new TableSymboles(); 
    	}
	
    	return _tableLocale;
    }
    
    public void dropTableLocale() { 
    	//je dois ici supprimer tous les variable de ce bloc
    	/************************************************/
    	
		
    	for(int i = 0 ; i < nbVariableLocale[ numTableLocale ] ; i++) {
    		_tableLocale.supprimedernierVal();
    	}
    	nbVariableLocale[ numTableLocale ] = 0 ;
    	numTableLocale--;
    	 if( numTableLocale == 0 ) {
    		
    		 _tableLocale = null; 
    	 }
    	
    }

    
    public void putVar(String s, String t) { 
		if (_tableLocale != null) {
			_tableLocale.putVar(s,t);
			
		}
		else
			
			_tableGlobale.putVar(s,t);
    }
    /**
     * Les adresses des variables locales sont comptées négativement à partir de fp.
     * Vision de la pile:
     *                                fp
     *                                \/
     *     ...  rr  p1  p2  ... pcr  fp(-1)
     * 
     * où rr est la place pour la valeur retournée par la fonction (éventuellement)
     * et :
     *     p1 est la place du 1er paramètre 
     *     p2 est la place du 2e paramètre
     *     ...
     *     pcr est le compteur de programme (pc) au retour 
     *                (là où il faut se brancher après sortie de la fonction)  
     *     fp(-1) est la valeur du fp précédent (nécessaire pour restaurer l'environnement)  
     *     fp est la valeur du fp courant, là où est stocké fp(-1)
     * 
     * La distance dans la pile séparant la place de la variable locale correspondant
     * au premier paramètre  de la place pointée par le fp courant est donc égale : 
     * au nombre de paramètres de la fonction plus 2 (à cause de pc et fp qui sont empilés par CALL).
     * 
     * L'adresse par rapport à fp d'une variable est toujours négative et se calcule comme :
     * son rang, moins le nombre de paramètres, moins 2.
     *
     * Note : on a triché ci-dessus dans l'explication pour faire comme si on avait uniquement des variables de type int qui ne prenne qu'une cellule de la pile.
     * Pour gérer les flottants (qui sont supportés "nativement" par la MVàP), il faut tenir compte des tailles des variables qui compte pour 1 ou pour 2 dans 
     * le calcul 
     *
     */
    private AdresseType getAdresseTypeLocale(String symbol) {
	if (_tableLocale != null) {
	    System.err.println("Recherche de "+ symbol + " dans table locale: " + _tableLocale);
	    AdresseType a = _tableLocale.getAdresseType(symbol);
	    if (a != null) { // on a trouvé
		//******************** j'ai changé icii
		// return new AdresseType(a.adresse - (_tableLocale.getTaille() + 2), a.type);
		return new AdresseType(a.adresse + (_tableGlobale.getTaille()), a.type);
	    }
	}
	
	System.err.println(symbol + " pas trouvé en local");
	return null;
    }
   
    private AdresseType getAdresseTypeGlobale(String symbol) {
		System.err.println("Recherche de "+ symbol + " dans table globale: " + _tableGlobale
				   + " => @"+ _tableGlobale.getAdresseType(symbol));
		return _tableGlobale.getAdresseType(symbol);
    }
   
    /****************pour les fonctions **********/
    private AdresseType getAdresseTypeFonction( String symbol) {
  		
  		return tablesSymbolesFonction.getAdresseTypeFonction(foncActuelle,typeFoncActuelle, symbol);
      }
   
    /** donne l'adresse de la variable locale à une fonction (négative) ou globale (positive) */
    public AdresseType getAdresseType(String symbol) { 
	
    	AdresseType a =  getAdresseTypeFonction( symbol );
    	
    	if (a == null)
    		a = getAdresseTypeLocale(symbol);
		if (a == null)
		    a = getAdresseTypeGlobale(symbol);
		if (a != null)                    
		    return a;
	            
		System.err.println("## Erreur : la variable \"" + symbol + "\" n'existe pas");
		return null; // n'importe quoi, et l'adresse n’existe pas!
    }

   
    
    
  //********************************partie fonction**********************
    
    private HashMap<String, AdresseType> _tableFonctions = new HashMap<String, AdresseType>();    
    
    public AdresseType getFonction(String fonction) {
		
    	return tablesSymbolesFonction.getFonction(fonction);
    	
    }

    public boolean nouvelleFonction(String fonction, int label, String t) {
    	
		boolean bol = tablesSymbolesFonction.nouvelleFonction(fonction, label,t);
		if( bol ) {
			
			foncActuelle = fonction ;
			typeFoncActuelle = t;
		}
		return bol ;
    }
    
    public TableSymboles newTableLocaleFonction(){ 
    	flagFonction = 1;
		System.out.println("creation de table locale fonction ");
	
		return tablesSymbolesFonction.getTablevar( foncActuelle, typeFoncActuelle ) ;
	}
	
    public void putVarFonction(String s, String t) { 
		
		tablesSymbolesFonction.putVarFonction(foncActuelle, typeFoncActuelle , s,  t);
    }


    public void majVarFonc(){ 
    
    	tablesSymbolesFonction.majVarFonc( foncActuelle, typeFoncActuelle );
    }
    

    public int nbVarFonction(){ 
    	
    	return tablesSymbolesFonction.nbVarFonction( foncActuelle, typeFoncActuelle );
    }
    
    
    public void dropTableFonction(){ 
    	
    	flagFonction = 0;
    	    	
    }
    
    
}

    




