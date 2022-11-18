package model;

public class Arvore implements IArvore {
	
	No raiz;

	public Arvore() {
		raiz = null;
	}

	@Override
	public void insertLeaf(int valor) {
		No no = new No();
		no.dado = valor;
		no.esquerda = null;
		no.direita = null;
		
		insert (no, raiz);
	}

	private void insert(No no, No raizSubArvore) {
		if (raiz == null) {
			raiz = no;
		} else {
			
//			Vai para a Direita
			if (no.dado < raizSubArvore.dado) {
				if(raizSubArvore.esquerda == null) {
					raizSubArvore.esquerda = no;
				} else {
					insert(no, raizSubArvore.esquerda);
				}
			}
			
//			Vai para a Esquerda
			if (no.dado >= raizSubArvore.dado) {
				if (raizSubArvore.direita == null) {
					raizSubArvore.direita = no;
				} else {
					insert(no, raizSubArvore.direita);
				}
			}
		}
	}

	
	@Override
	public void search(int valor) throws Exception {
		try {
			No no = searchNode(raiz, valor);
			int nivel = nodeLevel(raiz, valor);
			System.out.println("\n\nDado: " + no.dado + " no nível: " + nivel);
		} catch (Exception e) {
			System.err.println("Dado inexistente");
		}
	}

	private int nodeLevel(No raizSubArvore, int valor) throws Exception {
		if (raiz == null) {
			throw new Exception("Arvore vazia");
		} else if (valor < raizSubArvore.dado) {
			return 1 + nodeLevel(raizSubArvore.esquerda, valor);
		} else if (valor > raizSubArvore.dado) {
			return 1 + nodeLevel(raizSubArvore.direita, valor);
		} else {
			return 0;
		}
	}

	private No searchNode(No raizSubArvore, int valor) throws Exception{
		if (raiz == null) {
			throw new Exception("Arvore vazia");
		} else if (valor < raizSubArvore.dado) {
			return searchNode(raizSubArvore.esquerda, valor);
		} else if (valor > raizSubArvore.dado) {
			return searchNode(raizSubArvore.direita, valor);
		} else {
			return raizSubArvore;
		}
	}

//========================== Remove um elemento que você insere ============================
	@Override
	public void removeChild(int valor) throws Exception {
		remove(raiz, valor);
	}

	private No remove(No raizSubArvore, int valor) throws Exception {
		if (raiz == null) {
			throw new Exception("Arvore vazia");
		} else if (valor < raizSubArvore.dado) {
			raizSubArvore.esquerda = remove(raizSubArvore.esquerda, valor);
		} else if (valor > raizSubArvore.dado) {
			raizSubArvore.direita = remove(raizSubArvore.direita, valor);
		} else {
			if (raizSubArvore.esquerda == null && raizSubArvore.direita == null) {
				raizSubArvore = null;
			} else if (raizSubArvore.esquerda == null) {
				raizSubArvore = raizSubArvore.direita;
			} else if (raizSubArvore.direita == null) {
				raizSubArvore = raizSubArvore.esquerda;
			} else {
				No no = raizSubArvore.esquerda;
				while (no.direita != null) {
					no = no.direita;
				}
				raizSubArvore.dado = no.dado;
				no.dado = valor;
				raizSubArvore.esquerda = remove(raizSubArvore.esquerda, valor);
			}
		}
		return raizSubArvore;
	}

//=================================== Atravessamentos ========================================

//====================================== Prefixo =============================================
	@Override
	public void prefixSearch() throws Exception {
		prefix(raiz);
	}

	private void prefix(No raizSubArvore) throws Exception {
		if (raiz == null) {
			throw new Exception("Arvore vazia");
		} else {
			System.out.print(raizSubArvore.dado);
			System.out.print(" ");
			if (raizSubArvore.esquerda != null) {
				prefix(raizSubArvore.esquerda);
			}
			if (raizSubArvore.direita != null) {
				prefix(raizSubArvore.direita);
			}
		}
	}

//====================================== Infixo =============================================
	@Override
	public void infixSearch() throws Exception {
		infix(raiz);
	}

	private void infix(No raizSubArvore) throws Exception {
		if (raiz == null) {
			throw new Exception("Arvore vazia");
		} else {
			if (raizSubArvore.esquerda != null) {
				infix(raizSubArvore.esquerda);
			}
			System.out.print(raizSubArvore.dado);
			System.out.print(" ");
			if (raizSubArvore.direita != null) {
				infix(raizSubArvore.direita);
			}
		}
	}

//====================================== Posfixo =============================================
	@Override
	public void postfixSearch() throws Exception {
		postfix(raiz);
	}

	private void postfix(No raizSubArvore) throws Exception {
		if (raiz == null) {
			throw new Exception("Arvore vazia");
		} else {
			if (raizSubArvore.esquerda != null) {
				postfix(raizSubArvore.esquerda);
			}
			if (raizSubArvore.direita != null) {
				postfix(raizSubArvore.direita);
			}
			System.out.print(raizSubArvore.dado);
			System.out.print(" ");
		}
	}
	
	
}
