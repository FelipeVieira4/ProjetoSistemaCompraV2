package produto;

/**
 *  
 * Usado para instanciar um produto,compra,quantidades do produto e a Garantia do produto(s) comprado.
 * 
 * 
 * @author Felipe V.
 * **/
public class CompraProduto{
	
	private int qtda=0;
	private float precoCompra=0.0f;					//Preço da compra do produto
	private Produto produto;

	
	


	/**Metodo construtor sem Garantia**/
	public CompraProduto(Produto pProduto,int pQtda) {
		this.produto=pProduto;
		this.setQtda(pQtda);
		
		this.setPrecoTotal();
	}
	
	
	/**Retorna a valor de quantidades**/
	public int getQtda() {
		return qtda;
	}

	/**Setar a quantidades**/
	public boolean setQtda(int pqtda) {
		if(pqtda>0){
	          this.qtda=pqtda;
	          return true;
	        }
	        return false;
	}
	
	/**Setar o preco da comprar**/
	public float getPrecoTotal() {
		return precoCompra;
	}

	/**Calcular o preco da comprar**/
	public void setPrecoTotal() {
		this.precoCompra = (this.produto.getPreco()*this.qtda);
	}

	/**Retornar o produto da compra**/
	public Produto getProduto() {
		return produto;
	}

	/**Setar o produto da compra**/
	public boolean setProduto(Produto p) {
		if(p!=null) {
			this.produto = p;
			return true;
		}
		return false;
	}
		
}
