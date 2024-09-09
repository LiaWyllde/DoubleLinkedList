package view;
import Model.*;
import controller.*;

public class Main {

	public static void main(String[] args) {
        ListaEncDupla lista = new ListaEncDupla();
        try {
            lista.teste();
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

}
