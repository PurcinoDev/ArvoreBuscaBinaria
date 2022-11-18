package view;

import model.Arvore;

public class Principal {
	 
	public static void main(String[] args) {
		Arvore arvore = new Arvore();
		arvore.insertLeaf(7);
		arvore.insertLeaf(13);
		arvore.insertLeaf(20);
		arvore.insertLeaf(4);
		arvore.insertLeaf(1);
		arvore.insertLeaf(18);
		arvore.insertLeaf(5);
		arvore.insertLeaf(11);
		
		try {
			arvore.prefixSearch();
			System.out.println("");
			System.out.println("=============================");
			arvore.infixSearch();
			System.out.println("");
			System.out.println("=============================");
			arvore.postfixSearch();
			
			arvore.search(18);
			arvore.removeChild(13);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
