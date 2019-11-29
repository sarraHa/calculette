
grammar Calculette;

@header {


	import java.util.HashMap;
	import java.util.Scanner;  // Import the Scanner class
	
	}

@members{ 

	private TablesSymboles tablesSymboles = new TablesSymboles();
	private int sp = 0;	

	private int evalexpr (int x, String op, int y) {
        if ( op.equals("*") ){
            return x*y;
        } else if ( op.equals("+") ){
            return x+y;
        } else {
           System.err.println("Opérateur arithmétique inconnu : '"+op+"'");
           throw new IllegalArgumentException("Opérateur arithmétique inconnu : '"+op+"'");
        }
    }
    
    private int _label = 0;
    /** générateur de nom d'étiquettes */
    private int nextLabel() { return _label++; }
    
	public boolean isReal(String string) {
	    boolean delimiterMatched = false;
	    char delimiter = '.';
	    for (int i = 0; i < string.length(); i++) {
	        char c = string.charAt(i);
	        if (!(c >= '0' && c <= '9' || c == delimiter)) {
	            // contains not number
	            return false;
	        }
	        if (c == delimiter) {
	            // delimiter matched twice
	            if (delimiterMatched) {
	                return false;
	            }
	            delimiterMatched = true;
	        }
	    }
	    // if matched delimiter once return true
	    return delimiterMatched;
	}
   
}

start returns [String code ]
    :calcul EOF  
    ;


calcul returns [ String code ] 
@init{ 
	
	// On initialise $code, pour ensuite l'utiliser comme accumulateur 
		$code = new String();  
		$code = "\n";
}   

@after{
		System.out.println( sp );
		System.out.println($code);
		
}
    
    :   (decl { $code += $decl.code; })*        
        
        { int entry = nextLabel(); $code += "JUMP " + entry + "\n"; }
      
        NEWLINE*
        
      (fonction { $code += $fonction.code; })* 
        NEWLINE*
        
      { $code += "\n LABEL " + entry + "\n"; }
        (instruction { $code += $instruction.code; })*

        { $code += "\nHALT\n"; } 
    ;
    

decl returns [ String code ] 
    :
        TYPE IDENTIFIANT finInstruction
        {
			//je regarde d'abord si cette variable existe deja    
			//Si une variable qui a le 	même nom et le même type, on interrompt la déclaration 
			//*********************************** */
			// je pense que je dois ajouter ici verifierType(String valeur, String type)
			if( $TYPE.text.equals("int") ){
				
				tablesSymboles.putVar($IDENTIFIANT.text, $TYPE.text);
				//******************* joutee */
				tablesSymboles.ajouteNBVariable();
			    $code = "PUSHI 0\n";
            
				
			}else if( $TYPE.text.equals("float") ){
				
				tablesSymboles.putVar($IDENTIFIANT.text, $TYPE.text);
				// probleme : quand la variable existe on va comme meme afficher pushi 0
	          	tablesSymboles.ajouteNBVariable();
	            $code = "PUSHF 0.0\n";
				
			}else if( $TYPE.text.equals("bool") ){
				
				tablesSymboles.putVar($IDENTIFIANT.text, $TYPE.text);
				// probleme : quand la variable existe on va comme meme afficher pushi 0
	          	tablesSymboles.ajouteNBVariable();
	            $code = "PUSHI 0\n";
				
			}else{
				
				System.err.println("Erreur type non reconnue"); 
				
			}
			
        }
        
    ; 
    

instruction returns [ String code ] 
    : expr finInstruction 
        { 
            $code = $expr.code;
        }
    | exprFloat finInstruction 
        { 
            $code = $exprFloat.code;
        }
       
    | assignation finInstruction
        { 
            
            $code = $assignation.code;
        }
        
    |  entrSorti finInstruction
       {
    		$code = $entrSorti.code ;
       }
       
   |TYPE IDENTIFIANT '=' BOOLEAN finInstruction
  	 {

  		if( $TYPE.text.equals("bool") || $TYPE.text.equals("int") ){
        		
        	tablesSymboles.putVar($IDENTIFIANT.text, $TYPE.text);
  			/****************ajoutee */
  			tablesSymboles.ajouteNBVariable();
  			AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
  			$code =  "PUSHI 0\n" + "PUSHI " +  $BOOLEAN.text + "\nSTOREG " + at.adresse + "\n";
        	
        	}else{
        		
        		System.err.println("erreur de type ");
        		System.exit(0);
        		
        	}
  	 } 
    | TYPE IDENTIFIANT '=' expr finInstruction
  	 {

		if( $TYPE.text.equals("int") ){
        		
        	tablesSymboles.putVar($IDENTIFIANT.text, $TYPE.text);
	  		/************ajoutee */
	  		tablesSymboles.ajouteNBVariable();
	  		AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
	  		 
	  		
	  		
	  		$code =  "PUSHI 0\n" + $expr.code + "STOREG " + at.adresse + "\n";
        
        
        	}else{
        		
        		System.err.println("erreur de type ");
        		System.exit(0);
        		
        	}
  	 }
  	
  	| TYPE IDENTIFIANT '=' exprFloat finInstruction
  	 {

  		if( $TYPE.text.equals("float") ){
        		
        	tablesSymboles.putVar($IDENTIFIANT.text, $TYPE.text);
  			/****************ajoutee */
  			tablesSymboles.ajouteNBVariable();
  			AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
  			$code =  "PUSHI 0\n" + $exprFloat.code + "STOREG " + at.adresse + "\n";
        	sp++; 
        	sp--; 
        	
        	}else{
        		
        		System.err.println("erreur de type ");
        		System.exit(0);
        		
        	}
  	 }

  	 
  
  	 
  	 
  	|'while' '(' condition ')' instruction
  	 {
  	 		$code = "";
  	 		
  	 		int label1 = nextLabel();
  	 		int label2 = nextLabel();
  	 		
  	 		$code += "\n LABEL " + label1 + "\n";
  	 		$code += $condition.code ;
  	 		$code += "JUMPF " + label2 + "\n";
        	sp--; 
  	 		$code += $instruction.code ;
  	 		$code += "JUMP " + label1 + "\n";
			$code += "\n LABEL " + label2 + "\n";
  	 }
	|'while' '(' condition ')' bloc
  	  {
  	 		$code = "";
  	 		
  	 		int label1 = nextLabel();
  	 		int label2 = nextLabel();
  	 		
  	 		$code += "\n LABEL " + label1 + "\n";
  	 		$code += $condition.code ;
  	 		$code += "JUMPF " + label2 + "\n";
        	sp--; 
  	 		$code += $bloc.code ;
  	 		$code += "JUMP " + label1 + "\n";
  	 		$code += "\n LABEL " + label2 + "\n";
  	  }
  	| 'if' '(' condition ')' bloc_if = bloc 
  		{
  			$code = "";
  			$code += $condition.code ;
  			
  			int label_fin_if  = nextLabel();
 			
 			$code += "JUMPF " + label_fin_if + "\n";
        	sp--; 
 			$code += $bloc_if.code;
 			
 			int label_rest_code  = nextLabel();
 			
 			$code += "JUMP " + label_rest_code + "\n";
 			$code += $code += "\n LABEL " + label_fin_if + "\n";
  		}
  		
  		('else' bloc_else = bloc 
  			{ 
  				$code +=  $bloc_else.code ; 	
  			}
  		)?
  		{   $code += "\n LABEL " + label_rest_code  + "\n";}
    | 'for' '(' a1 = assignation ';' condition ';' a2 = assignation ')' instruction
       {
       		$code  = "";
       		$code +=  $a1.code ;
       		
       		int label_for  = nextLabel();
       		
       		$code += "\n LABEL " + label_for + "\n";
       		$code += $condition.code ;
       	
       		int label_fin_for = nextLabel();
       	
       		$code += "JUMPF " + label_fin_for + "\n";
        	sp--; 
       		$code += $a2.code ;
       		$code += $instruction.code ;
       		$code += "JUMP " + label_for + "\n";
       		$code += "\n LABEL " + label_fin_for + "\n";
       } 
	    |'for' '(' a1 = assignation ';' condition ';' a2 = assignation ')' bloc
	       {
	       		$code  = "";
	       		$code +=  $a1.code ;
	       		
	       		int label_for  = nextLabel();
	       		
	       		$code += "\n LABEL " + label_for + "\n";
	       		$code += $condition.code ;
	       	
	       		int label_fin_for = nextLabel();
	       	
	       		$code += "JUMPF " + label_fin_for + "\n";
	       		
        		sp--; 
	       		$code += $a2.code ;
	       		$code += $bloc.code ;
	       		$code += "JUMP " + label_for + "\n";
	       		$code += "\n LABEL " + label_fin_for + "\n";
	       } 
	| 'repeat' instruction 'until' '(' condition ')'
	  {
	  	 $code = "";
	  	 
	  	 int label_repeat  = nextLabel();
	  	 int label_fin_repeat  = nextLabel();
	  	 
	  	 $code += "\n LABEL " + label_repeat + "\n";
	  	 $code += $instruction.code;
	  	 $code += $condition.code ;
	  	 $code += "JUMPF " + label_fin_repeat + "\n";
	  	
         sp--; 
	  	 $code += "JUMP " + label_repeat + "\n";
	  	 $code += "\n LABEL " + label_fin_repeat + "\n";
	  }

	| 'repeat' bloc 'until' '(' condition ')'
	  {
	  	 $code = "";
	  	 
	  	 int label_repeat  = nextLabel();
	  	 int label_fin_repeat  = nextLabel();
	  	 
	  	 $code += "\n LABEL " + label_repeat + "\n";
	  	 $code += $bloc.code;
	  	 $code += $condition.code ;
	  	 $code += "JUMPF " + label_fin_repeat + "\n";
	  	 
         sp--; 
	  	 $code += "JUMP " + label_repeat + "\n";
	  	 $code += "\n LABEL " + label_fin_repeat + "\n";
	  }
	  
    | finInstruction
        {
            $code = "\n";
        }
    ;

entrSorti returns [ String code ] 
    :
        'readln(' IDENTIFIANT ')' 
        {    		
			AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
			
			 
			if( at.type.equals("int")){
				
				$code = "READ \n" +  "STOREG " + at.adresse +"\n";
			
			}else if( at.type.equals("float") ){
		
				$code = "READF \n" +  "STOREG " + at.adresse + "\n";
			
			}else {
				
				System.err.println("Erreur type non reconnue");
			}
        }
        
   |    'println(' IDENTIFIANT ')' 
        {
			AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
			if( at.type.equals("int")){
				
				$code = "PUSHG " + at.adresse + "\n" + "WRITE\n";		
				
			}else if( at.type.equals("float") ){
		
				$code = "PUSHG " + at.adresse + "\n" + "WRITEF\n";	
			
			}else {
				
				System.err.println("Erreur type non reconnue");
			}
        }
    ; 
    

expr  returns [String code, String type]
    :  a=expr '*' b=expr{ $code = $a.code  + "\n" + $b.code  + "MUL" + "\n"; sp--;}
    |  a=expr '/' b=expr{ $code = $a.code  + "\n" + $b.code  + "DIV" + "\n"; sp--;}
    |  a=expr '+' b=expr{ $code = $a.code  + "\n" + $b.code  + "ADD" + "\n"; sp--; }
    |  a=expr '-' b=expr{ $code = $a.code  + "\n" + $b.code  + "SUB" + "\n"; sp--; }
    |  ENTIER { $code = "PUSHI " + $ENTIER.int  + "\n"; }
    |  IDENTIFIANT { 
    					
    					
					 AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
					 if( at.paramFonc == 1 ){
					 	
					 	 $code = "PUSHL " + at.adresse + "\n";
					 	
					 } 
					 else{
					 	$code = "PUSHG " + at.adresse + "\n";
					 }
    					
    				}
    
    				
   	| IDENTIFIANT '(' args ')'                   // appel de fonction  
        {  
       		
       		
       		//a finir*****
       		// on reserve de la place pour la valeur de retour 
    	   	// ÇA DEPEND DE TYPE 
       		$code = "";
       		 
       		AdresseType at = tablesSymboles.getFonction($IDENTIFIANT.text );
       		//$type = at.type; je ne sais pas si je le fais ou pas 
       		
       		if( at.type.equals("int") ){
            
	            $code = "PUSHI 0\n";
				sp++;
				
			}else if( at.type.equals("float") ){
				
	            $code = "PUSHF 0.0\n";
				
			}else {
				
				System.err.println("Erreur type non reconnue"); 	
			} 
                 	
   			// empiler les args
   			$code += $args.code ; 
   		
   			$code += "CALL " + at.adresse + "\n" ;
   			
   			for( int i = 0; i < $args.size ; i++){		
   				$code += "POP \n";
   				
   			}
        
        }
    |  '(' expr ')'
    ;
    
    
exprFloat  returns [String code]
    :  a=exprFloat '*' b=exprFloat{ $code = $a.code  + "\n" + $b.code  + "FMUL" + "\n"; sp--; sp--;}
    |  a=exprFloat '/' b=exprFloat{ $code = $a.code  + "\n" + $b.code  + "FDIV" + "\n"; sp--; sp--; }
    |  a=exprFloat '+' b=exprFloat{ $code = $a.code  + "\n" + $b.code  + "FADD" + "\n"; sp--; sp--; }
    |  a=exprFloat '-' b=exprFloat{ $code = $a.code  + "\n" + $b.code  + "FSUB" + "\n"; sp--; sp--; }
  
    |  REELLE { $code = "PUSHF " + $REELLE.text  + "\n"; }
    |  IDENTIFIANT { 
						AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
						$code = "PUSHG " + at.adresse + "\n";
    					sp++; 
    				}
    |  '(' exprFloat ')'
    ;


exprBoolean  returns [String code]
  
     : IDENTIFIANT { 					
				
				AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
				
				if( at.type.equals("bool")){
					
								
					 if( at.paramFonc == 1 ){
					 	
					 	 $code = "PUSHL " + at.adresse + "\n";
					 	
					 } 
					 else{
					 	$code = "PUSHG " + at.adresse + "\n";
					 } 
					
				}else{
					System.out.println("erreur de type ce n est pas un boolean'");	
				}
	
    					
    		 }
    | BOOLEAN {
    	
    	$code = "PUSHI " + $BOOLEAN.text  + "\n";
    }
    
    ; 


   // FAIRE UNE AUTRE EXPR POUR LES FLOAT

assignation returns [ String code ] 
    : IDENTIFIANT '=' expr 
        {  		
     	  	AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
        	if( at.type.equals("int") ){
     
        	// je dois voir aussi si le type match ou pas
        	// sinon erreur ???        	
        	$code = $expr.code +  "STOREG " + at.adresse + "\n";
        	sp--; 
        	
        	}else{
        		
        		System.err.println("Erreur de type ");
        		System.exit(0);
        		
        	}
        	
        }
        // FAIRE UN OU ICII POUR EXPR DE FLOAT
    |  IDENTIFIANT '=' exprFloat 
        {  		
        	AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
        	if( at.type.equals("float") ){
        
        	$code = $exprFloat.code +  "STOREG " + at.adresse + "\n";
        	sp--; 
        	}else{
        		
        		System.err.println("Erreur de type ");
        		System.exit(0);	
        	}	
        }       
    ;


bloc returns [ String code ] 
@init{ 	$code = "";  

		TableSymboles _tableLocale =  tablesSymboles.newTableLocale();
	}
    :   '{'  
    		(instruction { $code += $instruction.code; })* 
    		 
			  	
    		
        '}' 
        { 
        	System.out.println( _tableLocale.toString() );
        	tablesSymboles.dropTableLocale() ;
        	System.out.println( _tableLocale.toString() );
        } 
;

blocFonction returns [ String code ] 
@init{ 	

	$code = ""; 
	
	TableSymboles _tableLocale =  tablesSymboles.newTableLocale();

}
    :   '{'     		
    		(instruction { $code += $instruction.code;  })* 
    		
			// dans le cas des fonc    	
    		('return' expr ';')?{		
    			
    			
    			$code += $expr.code ;
	    		$code += "STOREL " +   (-3 - tablesSymboles.nbVarFonction() ) + "\n" ;  // pas fini 
	       		$code += "RETURN\n";
	       	
    		}
    		    		
        '}'
         { 
        		
       		
        	System.out.println( _tableLocale.toString() );
        	tablesSymboles.dropTableLocale() ;
        	System.out.println( _tableLocale.toString() );
       
         }  
         
; 

    

condition returns [String code]
    
    : a = expr '<' b = expr { $code = $a.code + $b.code + "INF\n";sp--; }
    | a = expr '>' b = expr { $code = $a.code + $b.code + "SUP\n"; sp--; }
    | a = expr '<=' b = expr { $code = $a.code + $b.code + "INFEQ\n"; sp--; }
    | a = expr '>=' b = expr { $code = $a.code + $b.code + "SUPEQ\n"; sp--; }
    | a = expr '==' b = expr { $code = $a.code + $b.code + "EQUAL\n"; sp--; }
    | a = expr '!=' b = expr { $code = $a.code + $b.code + "NEQ\n"; sp--; }
    | exprBoolean { $code = $exprBoolean.code ;}
    
    | c1 = condition 'and' c2 = condition 
  	  {
  	  	$code = $c1.code + $c2.code + "MUL\n" + "PUSHI 0\n" + "SUP\n" ;
      }
    | c1 = condition 'or' c2 = condition 
  	  {
  	  	System.out.println("sara");
  	  	$code = $c1.code + $c2.code + "ADD\n" + "PUSHI 0\n" + "SUP\n" ;
      }
    | 'not' '(' condition ')' 
  	  {
  	  	$code = $condition.code + "PUSHI 1\n" + "SUB\n" + "PUSHI -1\n" + "MUL\n";      	
      }
    | '(' condition ')'{ $code = $condition.code ; }

    	 
    
    | 'true'  { $code = "PUSHI 1\n"; sp++; }
    | 'false' { $code = "PUSHI 0\n"; sp++; }
    | a1 = exprFloat '<' b1 = exprFloat { $code = $a1.code + $b1.code + "FINF\n"; sp--; sp--; }
    | a1 = exprFloat '>' b1 = exprFloat { $code = $a1.code + $b1.code + "FSUP\n"; sp--; sp--; }
    | a1 = exprFloat '<=' b1 = exprFloat { $code = $a1.code + $b1.code + "FINFEQ\n"; sp--; sp--; }
    | a1 = exprFloat '>=' b1 = exprFloat { $code = $a1.code + $b1.code + "FSUPEQ\n"; sp--; sp--; }
    | a1 = exprFloat '==' b1 = exprFloat { $code = $a1.code + $b1.code + "FEQUAL\n"; sp--; sp--; }
    | a1 = exprFloat '!=' b1 = exprFloat { $code = $a1.code + $b1.code + "FNEQ\n"; sp--; sp--; }
    
    ;
    


fonction returns [ String code ]
@init{ 


	  
//	  TableSymboles _tableLocaleFonction =  tablesSymboles.newTableLocaleFonction();
	  // je peux ici saufgarder quel fonction on est en traine de trvailler
}     // instancier la table locale
@after{ 


	
	
    

} // détruire la table locale
    : TYPE IDENTIFIANT 
        { 
     		// code java gérer la déclaration de "la variable" de retour de la fonction
            int labelDebut = nextLabel();
            $code = "";
            $code += "\n LABEL " + labelDebut + "\n";        
      		tablesSymboles.nouvelleFonction( $IDENTIFIANT.text, labelDebut , $TYPE.text);      		 
        	// je saufgarde ici dans quelle fonction on travaille
       		TableSymboles _tableLocaleFonction =  tablesSymboles.newTableLocaleFonction();
        }
        '('  params ? ')' 
        blocFonction 
        {
            
            // corps de la fonction
            $code += $blocFonction.code; 
             
        	
            tablesSymboles.dropTableFonction() ;
        }
  
   
        
    ;


params
    : TYPE IDENTIFIANT 	
        { 
            
            // code java gérant  une variable locale (argi)
      		if( $TYPE.text.equals("int") ){
				
				 
				 
				
				tablesSymboles.putVarFonction($IDENTIFIANT.text, $TYPE.text);
				//******************* joutee */
				//tablesSymboles.ajouteNBVariable();
				
				
			}else if( $TYPE.text.equals("float") ){
				
				tablesSymboles.putVarFonction($IDENTIFIANT.text, $TYPE.text);
				// probleme : quand la variable existe on va comme meme afficher pushi 0
	          	//tablesSymboles.ajouteNBVariable();
	           
			}else {
				
				System.err.println("Erreur type non reconnue"); 
				
			}
      
      
        }  
        ( ',' TYPE IDENTIFIANT 
            { 
           
	            // code java gérant  une variable locale (argi)
	      		if( $TYPE.text.equals("int") ){
					
					tablesSymboles.putVarFonction($IDENTIFIANT.text, $TYPE.text);
					//******************* joutee */
					//tablesSymboles.ajouteNBVariable();
					
					// probleme : quand la variable existe on va comme meme afficher pushi 0
		           
					
				}else if( $TYPE.text.equals("float") ){
					
					tablesSymboles.putVarFonction($IDENTIFIANT.text, $TYPE.text);
					// probleme : quand la variable existe on va comme meme afficher pushi 0
		           //tablesSymboles.ajouteNBVariable();
		           
				}else {
					
					System.err.println("Erreur type non reconnue"); 
					
				}
	            } 
        )*
    	{ 
    	 
    		
    		// METTRE À JOUR LES ADRESSE
    		
    		tablesSymboles.majVarFonc() ;
   
    	}
    ;

 // init nécessaire à cause du ? final et donc args peut être vide (mais $args sera non null) 
args returns [ String code, int size]
@init{ $code = new String(); $size = 0; }
    : ( expr
    { 
        // code java pour première expression pour arg1
    	$code = $expr.code;
    	$size++; 
    	
    }
    ( ',' expr
    { 
        // code java pour expression suivante pour argi
   		$code += $expr.code ;
  		$size++;
    } 
    )* 
      )? 
    ;



finInstruction  : ';';

//le jeton NEWLINE qui peut servir maintenant à terminer une instruction.
// Attention aussi à l'ordre des déclarations dans le lexer : les mots-clés réservés ne peuvent pas être des identifiants. 

// lexer
NEWLINE : '\r'? '\n'  -> skip;

WS :   (' '|'\t')+ -> skip  ;

BOOLEAN :  '0'|'1' ;

ENTIER : ('-')?('0'..'9')+  ;

REELLE :  ('-')?('0'..'9')+'.'('0'..'9')+ ;


TYPE : 'int' | 'float' | 'bool';

MOTCLE
    : ( 'break' | 'class' | 'double' | 'else' | 'if' | 'import' | 'public' | 'static' | 'throws' ) 
    ;
  
IDENTIFIANT : ('A'..'Z'|'a'..'z')+;

READLN : 'readln';
PRINTLN : 'println';

COMMENTAIRE
	: (   ( ('//')~('\n')*  ) | ('/')('*')(~('*')~('/')+)*('*')('/') )
	-> skip ; 

UNMATCH : . -> skip ;	


// lexer


//...


// comment faire por interdire le faite d'utliser des mots cle comme ident ???
// 	
//  pour le test 
//java MVaPAssembler test2.mvap
// java CBaP test2.mvap.cbap

// probleme

/*
* float i;
i = 7.2 + 2.0 ;
if( 5.2 > i ){
	
	int x = 3;
	println(x);
}else{

 println(i);
}
*/