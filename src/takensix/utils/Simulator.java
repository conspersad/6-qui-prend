package takensix.utils;

import java.util.List;

import takensix.card.Card;
import takensix.context.PlayContext;
import takensix.stack.StackManager;
import takensix.stack.Stacks;

/**
 * The Class Simulator. Enables to simulates moves. Useful for IA.
 */
public abstract class Simulator {

	/**
	 * Simulation of a move for a specified context.
	 *
	 * @param playContext
	 *            the play context
	 * @param card
	 *            the card played
	 * @return the new play context
	 */
	public static PlayContext simulate(PlayContext playContext, Card card) {
		return new StackManager(new Stacks(playContext.getStacks())).simulate(new PlayContext(playContext), card);
	}

	
	/**
	 * Computes distance between the played card and the last stack played card.
	 * Example : if a card n�80 is meant to go on a stack where the last stacked card is n�73,
	 * this distance is 7 (=80-73).
	 *
	 * @param playContext the play context
	 * @param card the card
	 * @return the distance
	 */
	public static int computeDistance(PlayContext playContext, Card card) {
		int stackIndex = new StackManager(new Stacks(playContext.getStacks())).getStackIndexForCard(card);

		if (stackIndex < 0)
			return -1;

		List<Card> stack = playContext.getStacks().get(stackIndex);
		Card lastCard = stack.get(stack.size() - 1);
		return card.getNumber() - lastCard.getNumber();
	}
/*La classe Simulator est une classe utilitaire conçue pour aider à simuler des mouvements dans le cadre du jeu "TakeSix". Cette simulation peut être utile pour l'intelligence artificielle (IA) pour évaluer les mouvements possibles et prendre une décision sur le meilleur mouvement à jouer. La classe contient deux méthodes statiques :

simulate(PlayContext playContext, Card card): Cette méthode prend en paramètres un objet PlayContext qui représente l'état actuel du jeu et une Card qui est la carte que l'on souhaite jouer. Elle crée une nouvelle instance de StackManager basée sur l'état actuel des piles de cartes dans le contexte de jeu, puis utilise cette instance pour simuler le jeu de la carte donnée. La méthode renvoie un nouvel objet PlayContext qui représente l'état du jeu après le mouvement simulé.

computeDistance(PlayContext playContext, Card card): Cette méthode calcule la "distance" entre la carte que l'on souhaite jouer et la dernière carte de la pile sur laquelle elle sera jouée. Cette "distance" est la différence entre le numéro de la carte à jouer et le numéro de la dernière carte sur la pile. Cette information peut être utilisée par l'IA pour évaluer si un mouvement est bon ou non (par exemple, une petite distance peut indiquer un bon mouvement car la carte à jouer est proche en valeur de la dernière carte sur la pile). La méthode renvoie -1 si la carte à jouer ne peut pas être placée sur une pile.

Ces deux méthodes peuvent aider l'IA à comprendre l'impact de jouer une certaine carte avant de faire réellement le mouvement, et à choisir le meilleur mouvement possible.*/
}
