package takensix.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import takensix.card.Card;
import takensix.context.PlayContext;
import takensix.player.Player;
import takensix.utils.Constants;
import takensix.utils.StringMaker;

/**
 * The Class StackManager. It handles the game's stacks.
 */
public class StackManager {

	/** The stacks. */
	private Stacks stacks;

	/** The number of stacks. */
	int numberOfStacks;

	/**
	 * The number of initialized stacks. A stack is initialized with one card.
	 */
	int numberOfInitializedStacks;

	/**
	 * Instantiates a new stack manager.
	 *
	 * @param numberOfStacks
	 *            the number of stacks
	 */
	public StackManager(int numberOfStacks) {
		this.numberOfStacks = numberOfStacks;
		this.init();
	}

	/**
	 * Instantiates a new stack manager with existing stacks.
	 *
	 * @param stacks
	 *            the stacks
	 */
	public StackManager(Stacks stacks) {
		this.stacks = stacks;
	}

	/**
	 * Determines the stack on which the played card needs to be put and compute
	 * the move's score.
	 *
	 * @param card
	 *            the played card
	 * @param playContext
	 *            the play context
	 * @return the move's score
	 */
	public int receiveCard(Card card, PlayContext playContext) {
		int destinationStackIndex;
		int penalty = 0;

		// First received cards are for initialization (one card per stack)
		// Others will be place on the right stack
		if (numberOfInitializedStacks < numberOfStacks) {
			destinationStackIndex = getStackIndexToInitialize();
			numberOfInitializedStacks++;
		} else {
			destinationStackIndex = getStackIndexForCard(card);
		}

		// Asks the player to clean a stack if the played card can't be stacked
		if (destinationStackIndex < 0) {
			destinationStackIndex = playContext.getPlayer().chooseStack(playContext);

			playContext.getGameContext().outputs
					.print(StringMaker.choosesStack(playContext.getPlayer(), destinationStackIndex));

			penalty += cleanStack(this.stacks.get(destinationStackIndex));
		}

		// Process move and compute score
		penalty += this.addCardToStack(card, destinationStackIndex);
		return penalty;
	}

	/**
	 * Simulate a move and return the PlayContext after move process. It is used
	 * by the Simulator.
	 *
	 * @param playContext
	 *            the play context
	 * @param card
	 *            the card played
	 * @return the play context after move
	 */
	public PlayContext simulate(PlayContext playContext, Card card) {
		int penalty = 0;
		int destinationStackIndex = getStackIndexForCard(card);

		if (destinationStackIndex < 0) {
			destinationStackIndex = playContext.getPlayer().chooseStack(playContext);
			penalty += cleanStack(this.stacks.get(destinationStackIndex));
		}

		penalty += this.addCardToStack(card, destinationStackIndex);

		Player player = playContext.getPlayer();
		player.addScore(penalty);
		player.getCards().remove(card);

		return playContext;
	}

	/**
	 * Adds the card to stack and return the move's score.
	 *
	 * @param card
	 *            the card played
	 * @param destinationStackIndex
	 *            the destination stack index
	 * @return the move's score
	 */
	private int addCardToStack(Card card, int destinationStackIndex) {
		if (destinationStackIndex < 0)
			return 0;

		List<Card> stack = this.stacks.get(destinationStackIndex);

		int returnedScore = 0;

		if (stack.size() >= Constants.MAX_CARD_PER_STACK)
			returnedScore = cleanStack(stack);

		stack.add(card);
		this.stacks.put(destinationStackIndex, stack);

		return returnedScore;
	}

	/**
	 * Cleans a stack and return total stack's score.
	 *
	 * @param stack
	 *            the stack to clean
	 * @return the stack's total score
	 */
	private int cleanStack(List<Card> stack) {
		int totalScore = 0;

		for (Card c : stack)
			totalScore += c.getScore();

		stack.clear();

		return totalScore;
	}

	/**
	 * Gets the stack index to initialize.
	 *
	 * @return the stack index to initialize
	 */
	private int getStackIndexToInitialize() {
		for (Entry<Integer, List<Card>> stack : stacks.entrySet()) {
			if (stack.getValue().isEmpty())
				return stack.getKey();
		}

		return -1;
	}

	/**
	 * Determines the stack which will receive the played card.
	 *
	 * @param card
	 *            the card played
	 * @return the stack index
	 */
	public int getStackIndexForCard(Card card) {
		int bestStackIndex = -1;
		int bestStackCardNumber = -100;

		int cardNumber = card.getNumber();

		for (Entry<Integer, List<Card>> entry : stacks.entrySet()) {
			List<Card> stack = entry.getValue();
			int maxStackNumber = stack.get(stack.size() - 1).getNumber();

			if (cardNumber < maxStackNumber)
				continue;

			if (maxStackNumber > bestStackCardNumber) {
				bestStackIndex = entry.getKey();
				bestStackCardNumber = maxStackNumber;
			}
		}

		return bestStackIndex;
	}

	/**
	 * Prepare the stacks.
	 */
	private void init() {
		this.numberOfInitializedStacks = 0;

		this.stacks = new Stacks();
		for (int i = 1; i <= numberOfStacks; i++) {
			this.stacks.put(i, new ArrayList<Card>());
		}
	}

	/**
	 * Gets the stacks.
	 *
	 * @return the stacks
	 */
	public Stacks getStacks() {
		return stacks;
	}

	/**
	 * Sets the stacks.
	 *
	 * @param stacks
	 *            the new stacks
	 */
	public void setStacks(Stacks stacks) {
		this.stacks = stacks;
	}
}
/*Cette classe, nommée StackManager, gère les piles de cartes (Stacks) dans le jeu. Elle est capable d'initialiser, ajouter des cartes et nettoyer des piles. Elle possède plusieurs méthodes pour manipuler et interagir avec les piles de cartes du jeu.

Voici une description plus détaillée des responsabilités et des méthodes de cette classe :

Constructeurs: La classe StackManager a deux constructeurs. L'un prend un nombre de piles (numberOfStacks) comme argument et initialise le StackManager avec ce nombre de piles vides. L'autre prend un objet Stacks existant comme argument et initialise le StackManager avec ces piles.

receiveCard: Cette méthode reçoit une carte (Card) et un contexte de jeu (PlayContext) en arguments. Elle détermine sur quelle pile la carte doit être placée et calcule le score de ce mouvement.

simulate: Cette méthode est utilisée pour simuler un mouvement. Elle prend un PlayContext et une Card comme arguments, simule le mouvement et renvoie le PlayContext après le traitement du mouvement. Cette méthode est probablement utilisée pour aider l'intelligence artificielle du jeu à décider quel mouvement effectuer.

addCardToStack: Cette méthode privée ajoute une carte à une pile spécifiée et renvoie le score du mouvement.

cleanStack: Cette méthode privée nettoie une pile spécifiée (enlève toutes les cartes de la pile) et renvoie le score total de la pile.

getStackIndexToInitialize et getStackIndexForCard: Ces méthodes déterminent l'indice de la pile à initialiser ou celle qui recevra une carte jouée.

init: Cette méthode prépare les piles.

getStacks et setStacks: Ces méthodes sont des getters et des setters pour l'attribut Stacks de la classe.

L'ensemble de ces méthodes permet de gérer les piles de cartes du jeu, que ce soit pour ajouter des cartes, les retirer ou même les nettoyer. Cette classe est donc un élément central pour le déroulement du jeu.




*/