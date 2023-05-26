package takensix.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import takensix.card.Card;

/**
 * The Class Stacks. It represents the stacks used to play the game. Each stack
 * is a set of cards played by players. This objects is handled by a
 * StackManager.
 */
public class Stacks extends HashMap<Integer, List<Card>> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Clones stacks.
	 *
	 * @param stacks
	 *            the stacks to clone
	 */
	public Stacks(Stacks stacks) {
		for (Entry<Integer, List<Card>> e : stacks.entrySet()) {
			List<Card> cards = new ArrayList<>();
			for (Card c : e.getValue())
				cards.add(new Card(c.getNumber(), c.getScore()));

			this.put(e.getKey(), cards);
		}
	}

	/**
	 * Instantiates new stacks.
	 */
	public Stacks() {
		super();
	}

	@Override
	public String toString() {
		String str = "";
		for (java.util.Map.Entry<Integer, List<Card>> e : this.entrySet()) {
			str += "{" + e.getKey().toString() + "} ";
			List<Card> value = e.getValue();
			str += value.get(value.size() - 1).toString() + " (" + value.size() + " card(s) - total : "
					+ countScore(value) + "pt(s))";
			str += "\n";
		}
		return str;
	}

	/**
	 * Count score. TODO: move this in a ScoreCounter in utils package.
	 *
	 * @param cards
	 *            the cards
	 * @return the int
	 */
	private int countScore(List<Card> cards) {
		int res = 0;
		for (Card c : cards)
			res += c.getScore();
		return res;
	}
/*
La classe Stacks est une extension de HashMap<Integer, List<Card>>, ce qui signifie qu'elle représente un ensemble de piles de cartes, où chaque pile est une liste de cartes (Card) et chaque pile est associée à un numéro entier unique.

Voici ce que font les différentes méthodes et constructeurs de cette classe :

Constructeur Stacks(Stacks stacks) : Ce constructeur crée une nouvelle instance de Stacks qui est une copie des Stacks passées en paramètre. Il copie chaque pile de cartes une par une, en créant de nouvelles instances de chaque Card.

Constructeur Stacks() : Ce constructeur crée une nouvelle instance de Stacks sans aucune pile de cartes.

toString() : Cette méthode surcharge la méthode toString de Object pour fournir une représentation sous forme de chaîne de caractères de l'objet Stacks. La chaîne retournée contient le numéro de chaque pile, la dernière carte ajoutée à chaque pile, le nombre total de cartes dans la pile et le score total de la pile.

countScore(List<Card> cards) : Cette méthode privée compte le score total d'une liste de cartes en additionnant le score de chaque carte.

En bref, cette classe est utilisée pour représenter et manipuler l'ensemble des piles de cartes dans le jeu.*/
}
