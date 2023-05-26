package takensix.output;

import takensix.utils.StringMaker;

public class OutputConsole implements Output {
	
	/**
	 * Write.
	 *
	 * @param s the s
	 */
	public void write(String s){
		if (s.trim().endsWith(StringMaker.CONSOLE_INPUT_SYMBOL))
			System.out.print(s);
		else
			System.out.println(s);
	}

	@Override
	public void close() {
	}
}
/*
Cette classe en Java, nommée "OutputConsole", semble implémenter une interface appelée "Output". Elle fournit une méthode publique "write" qui prend une chaîne de caractères en paramètre et l'affiche dans la console. Si la chaîne de caractères se termine par le symbole "CONSOLE_INPUT_SYMBOL" défini dans la classe "StringMaker", la méthode utilise "System.out.print" pour afficher la chaîne sans saut de ligne. Sinon, la méthode utilise "System.out.println" pour afficher la chaîne avec un saut de ligne.

La méthode "close" est également présente, mais elle ne contient pas de code. Cela pourrait indiquer qu'elle est destinée à être utilisée pour effectuer des opérations de nettoyage ou de fermeture, mais dans cette implémentation spécifique, elle ne fait rien.*/