package softur.validadores;

public class ValidadorCaracteres {
	
	 public static boolean tamanhoNome( String nome){  
		 for (int i = 1; i <= nome.length(); i++ ) { 
		   i += i;
		   if(i > 30){
			   return false;
		   }
		 } 
			  return true;
	    }

	 

}
