package softur.entities;

import softur.webservice.CepWebService;

/*
 * BuscaLogradouro.java
 *
 * Criado em 4 de Junho de 2007, 10:27 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Fabio Souza
 */
public class BuscaLogradouro {
    
    public static void main(String[] args) {
        new BuscaLogradouro();
    }
    
    public BuscaLogradouro() {
        try {
            String cep = "22753212";
            

            CepWebService cepWebService = new CepWebService(cep);
                
            if (cepWebService.getResultado()==1) {
                System.out.println(cepWebService.getLogradouro() + " " + cepWebService.getLogradouro());
                System.out.println(cepWebService.getCidade());
                System.out.println(cepWebService.getBairro());
                System.out.println(cepWebService.getResultado());
                System.out.println(cepWebService.getResultado());
            }
            else {
                System.out.println("Servidor não está respondendo.");
            }            
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }  
    }    
}
