package produto;

/**
*Usado para criar produtos no banco dados.
*
*
*@author Felipe V.
**/

public class Produto {
	
	private float preco=0.0f;
	private String codigo;
	private String nome="";
	private String decricao="";
	private String contatoDistribuidora="";	//Contato com a Distribuidora(forma: email)
	private String localProduzido="";			//Aonde o produto foi fabricado

	private String categoria;
	private String patchIcon=""; // Substituir o iconProduto

	
	public Produto() {
		
	}
	/**Construtor simples**/
	public Produto(String pCodigo,String pName,float pPreco) {
		
		this.setCodigo(pCodigo);
		this.setNome(pName);
		
		this.setPreco(pPreco);
   		
	}
	public Produto(String pCodigo,String pName,float pPreco,String pPatchIcon) {
		
		this.codigo=pCodigo;
		this.setNome(pName);

		this.setPreco(pPreco);
   		this.setPatchIcon(pPatchIcon);
	}

	/**Construtor completo**/
	public Produto(String pCodigo,String pName,float pPreco,String[] categorias,String pLocalProduzido,String pContatoDistribuidora,String pDecricao) {
		
		this.setCodigo(pCodigo);
		this.setNome(pName);
		this.setPreco(pPreco);
		this.setDecricao(decricao);

		this.setLocalProduzido(localProduzido);
		
	}
	
	/**Retornar preço do produto**/
	public float getPreco() {
		return preco;
	}

	/**Setar o preco do produto**/
    public boolean setPreco(float pPreco){
    	if(pPreco>0){
			this.preco=pPreco;
			return true;    		
    	}
    	
    	return false;
    }
	
    /**Retornar nome do produto**/
	public String getNome() {
		return nome;
	}
	
	/**Setar o nome do produto**/
	public boolean setNome(String pnome) {
		if(!pnome.isBlank()) {
			this.nome = pnome;
			return true;
		}
		return false;
	}

	/**Retornar o codigo do produto**/
	public String getCodigo() {
		return this.codigo;
	}

	/**Setar o codigo de um produto tem regex digitos**/
	public void  setCodigo(String pcodigo) {
		this.codigo=pcodigo;
	}

	/**Retornar o lugar onde o produto foi produzido**/
	public String getLocalProduzido() {
		return localProduzido;
	}

	/**Setar o lugar onde o produto foi produzido**/
	public boolean setLocalProduzido(String pLocalProduzido) {
		if(!pLocalProduzido.isBlank()) {
			this.localProduzido = pLocalProduzido;
			return true;
		}
		return false;
	}

	
	/**Retornar o contato da Distribuidora do produto**/
	public String getContatoDistribuidora() {
		return contatoDistribuidora;
	}

	/**Setar o contato da Distribuidora do produto**/
	public boolean setContatoDistribuidora(String pContatoDistribuidora) {
		if(!pContatoDistribuidora.isBlank()) {
			this.contatoDistribuidora = pContatoDistribuidora;
			return true;
		}
		return false;
	}


	/**Retornar a Descricao do produto**/
	public String getDecricao() {
		return decricao;
	}

	/**Setar a Descricao do produto**/
	public boolean setDecricao(String pDecricao) {
		if(!pDecricao.isBlank()) {
			this.decricao = pDecricao;
			return true;
		}
		return false;
	}

	

	
	public String getPatchIcon() {
		return patchIcon;
	}
	public void setPatchIcon(String patchIcon) {
		this.patchIcon = patchIcon;
	}
	
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
	
}
