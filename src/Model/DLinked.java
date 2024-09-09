package Model;
import Model.No;

public class DLinked <generic> {
	
	private No <generic> header = null;
	private No <generic> trailer = null;
	static int size = 0;
	
	public void addBrinquedo (generic toy) {
		
		//No <generic> verification = brinquedo;
		
		No <generic> brinquedo = new No <generic>(toy);
		
		if(this.trailer == null) {
			this.trailer = brinquedo;
			this.header = brinquedo;
			++ size;
		}
		//se a lista for vazia, o as caixas de acrílico recebem o novo marcador
		
		else {
			No <generic> noAntigo = this.trailer;
			noAntigo.setProximo(brinquedo);
			brinquedo.setAnterior(noAntigo);
			this.trailer = brinquedo;
			++ size; 
		}
	}
	
	public No <generic> getInList (int position) throws Exception {
		
		No <generic> noQueQuero = this.header;
		
		if (position > size){System.out.println("O index não é válido para a lista atual");}
			 if (size == 0) {throw new Exception("A lista está vazia");
		} else {
			for (int i = 0; i < position; i++) {
				noQueQuero = noQueQuero.getProximo();	
				/* o nó que eu quero recebe o próximo até chegar no indice */
			}
		}
		return noQueQuero;
	}
	
	public int indiceElemento (generic element) throws Exception {
		
		if (size == 0) {throw new Exception("A lista está vazia");}
		
		No <generic> elemento = new No <generic>(element);
		No <generic> noQueQuero = this.header;
		No <generic> proximo = this.header;
		
		if (this.header.getBrinquedo() == elemento.getBrinquedo()) {
			return 0;
			
		} else {
			//cria um objeto para receber as informações contidas nos nodes
			
			for (int i = 1; i < size; i++) {
				proximo = noQueQuero.getProximo();
				if (proximo == null) {
					noQueQuero = proximo.getAnterior();
				} else {
					noQueQuero = proximo;
				}
				if (noQueQuero.getBrinquedo() == element) {
					return i;
				}
			//enquanto i < size o nó que quero vai receber o brinquedo do próximo e do próximo
			}	
		}
		
		throw new Exception ("tem não");
	}
	
	public void insereElemento(generic element, int position) throws Exception {
		
		if (position == 0) {
			adicionaInicio(element);			
		} else if (position >= (size)) {
			addBrinquedo(element);
		} else {

			No <generic> anterior = new No <generic> (null);
			No <generic> guarda = new No <generic> (null);
			No <generic> elementoNovo = new No <generic>(element);
			
			guarda = getInList(position);
			
			anterior = guarda.getAnterior();
			
			anterior.setProximo(elementoNovo);
			elementoNovo.setProximo(guarda);
			guarda.setAnterior(elementoNovo);
			
			++size;
		}
}	
	
	public void removeElemento (int position) throws Exception{
		
		if (size == 0) {throw new Exception("A lista está vazia");}
		
		if (position == 0 && size == 1) {
			this.header = null;
			this.trailer = null;
			--size;
			
		} else if (position == 0) { //e size maior
			
			No <generic> novoInicio = new No <generic> (null);
			
			novoInicio = header.getProximo();
			novoInicio.setAnterior(null);
			
			header = novoInicio;
			--size;
			
			//o proximo já aponta para o header
			
		} else if (position >= size-1) {
			
			No <generic> anterior = new No <generic> (null);
			
			anterior = getInList((position-1));
			anterior.setProximo(null);
			--size;
			
		} else if (position > 0 && position < size) {
			
			No <generic> anterior = new No <generic> (null);
			No <generic> proximo = new No <generic> (null);
			No <generic> ponta = new No <generic> (null);
		
			//usar o elemento pra zerar
			//eu não faria anda além de programar, mas me odeio por isso (:
			
			anterior = getInList((position-1));
			proximo = getInList((position+1));
			
			anterior.setProximo(proximo);
			proximo.setAnterior(anterior);
			--size;
		}
	}
	
	public No <generic> getLast() throws Exception {
		if (size == 0) {throw new Exception("A lista está vazia.");}
		return trailer;
	}
	
	public void adicionaInicio(generic element) { //prepend
		
		No <generic> elemento = new No <generic>(element);
		
		if (size == 0) {
			this.header = elemento;
			this.trailer = elemento;
			++size;
			
		} else {
			
			No <generic> proximo = new No <generic> (null);
			
			elemento.setAnterior(null);
			proximo = header;
			proximo.setAnterior(elemento);
			elemento.setProximo(proximo);
			header = elemento;
			++size;
			
		}	
	}
	
	@Override
    public String toString(){
        if(this.header == null){
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        No<generic> buffer = this.header;

        builder.append(buffer.getBrinquedo());

        while(buffer.getProximo() != null){
            builder.append(",");
            buffer = buffer.getProximo();
            builder.append(buffer.getBrinquedo());
        }

        builder.append("]");
        return builder.toString();
    }
}
