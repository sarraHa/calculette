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
class TableSymboleFonction{

	    private String ident;
	    private String type;
	    private int label;
	    private AdresseType at;
	    
	    private TableSymboles tableVariables = new TableSymboles(); 
	    
	    public TableSymboleFonction ( String ident,  int label, String type){
	        
	    	this.ident = ident; 
	        this.type = type;   // type of the function
	        this.label =  label;
	        at = new AdresseType(label , type );
	        
	    }
	    
	    
	   public AdresseType getAdresseType( String symbol ) {

		   return tableVariables.getAdresseType( symbol  );	

	   }
	    
	   public AdresseType getAdresseTypeFonc(){

		   return at ;	
	   }
	   
	   public String getIdent() {
		   
		   return ident;
	   }
	  
	   public String getType() {
		   
		   return type;
	   }
	   
	   public TableSymboles getTablevar(){
		   
		   return tableVariables;
	   }
	   
	   public void addVar( String s, String t){
		   
		   tableVariables.putVar(s, t);
		   tableVariables.addParamFonc( s );
		   
	   }
	   

	   
	   
   
}

    





