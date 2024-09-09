package controller;
import Model.*;

public class ListaEncDupla<generic>{
	
	public DLinked <Object> lista = new DLinked<Object>();
	
	public void teste() throws Exception{

		lista.addBrinquedo("essa matéria vai me deixar maluca!");
        lista.addBrinquedo(2);
        lista.addBrinquedo(5);
        lista.addBrinquedo("Sapinho");
        lista.addBrinquedo(3);
        lista.addBrinquedo(1);
        lista.addBrinquedo("Coelinho");
        System.out.println(lista.toString());
        //ADD OK
        
        System.out.println(lista.indiceElemento("Coelinho"));
        //RETORNA O INDICE DO ELEMENTO INDICADO
        //INDICE ELEMENTO OK
        
        lista.removeElemento(5);
        //REMOVE O ELEMENTO DO INDICE
        //NÃO FUNCIONA COM O QUE N TEM PRÓXIMO

        No<Object> item = lista.getInList(0); 
        System.out.println(item.getBrinquedo().toString());
        //BUSCA DE ACORDO COM O INDICE ENVIADO
        //GET IN LIST OK

        lista.adicionaInicio("Sim");
        //PREPEND OK
        
        lista.insereElemento(15,2);
        System.out.println(lista.toString());
        //ELEMENTO - POSIÇÃO
        //INSERT OK
        
        
        No<Object> last = lista.getLast();
        System.out.println(last.getBrinquedo().toString());
        //LAST OK

    }
}
