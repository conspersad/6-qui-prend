package takensix.output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Interface Output.
 */
public class OutputCollection {
	
	/** The outputs. */
	private List<Output> outputs;

	/**
	 * Instantiates a new output collection.
	 */
	public OutputCollection() {
		this.outputs = new ArrayList<>();
	}

	public void add(Output... outputs) {
		this.outputs.addAll(Arrays.asList(outputs));
	}
	
	public void close(){
		for (Output o : outputs)
			o.close();
	}
	
	/**
	 * Prints the string.
	 *
	 * @param s the s
	 */
	public void print(String s){
		for (Output o : outputs)
			o.write(s);
	}
	
	/**
	 * Println the line.
	 *
	 * @param s the s
	 */
	public void println(String s){
		for (Output o : outputs)
			o.write(s + "\n");
	}

	/**
	 * Prints only into console.
	 *
	 * @param s the s
	 */
	public void printDebug(String s) {
		for (Output o : outputs)
			if (o instanceof OutputConsole)
				o.write(s);
	}
	
	/**
	 * Prints line only into console.
	 *
	 * @param s the s
	 */
	public void printlnDebug(String s) {
		for (Output o : outputs)
			if (o instanceof OutputConsole)
				o.write(s + "\n");
	}
}
/*a classe OutputCollection est une classe de gestion des sorties dans le système. Elle permet de gérer plusieurs instances de la classe Output, qui peuvent être utilisées pour écrire des informations dans différentes sorties.

Voici ce que fait chaque méthode dans cette classe :

OutputCollection(): C'est le constructeur de la classe. Il initialise une nouvelle liste d'objets Output.

void add(Output... outputs): Cette méthode permet d'ajouter une ou plusieurs instances d'Output à la collection.

void close(): Cette méthode ferme toutes les sorties en appelant leur méthode close.

void print(String s): Cette méthode écrit la même chaîne s dans toutes les sorties en appelant leur méthode write.

void println(String s): Cette méthode écrit la même chaîne s suivie d'un saut de ligne dans toutes les sorties.

void printDebug(String s): Cette méthode écrit la chaîne s seulement dans les sorties qui sont une instance de OutputConsole.

void printlnDebug(String s): Cette méthode écrit la chaîne s suivie d'un saut de ligne seulement dans les sorties qui sont une instance de OutputConsole.

En somme, cette classe fournit un moyen d'écrire dans plusieurs sorties à la fois et offre également la possibilité de filtrer certaines sorties en fonction de leur type.*/