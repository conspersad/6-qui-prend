package takensix.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import takensix.utils.Randomizer;
import takensix.utils.Constants;

/**
 * The Class CardGame which contains all the cards of the game. Each Card is
 * unique. When a Card distributed to a Player or a Stack, it is remove from
 * this set.
 */
public class CardGame {

	/** All the cards. */
	private List<Card> cards;

	/**
	 * Instantiates a new card game and shuffles it.
	 *
	 * @param cardScoreMode
	 *            the card score mode which determine how to associate a score
	 *            to a card
	 * @param numberOfCards
	 *            the number of cards to generate
	 */
	public CardGame(CardScoreMode cardScoreMode, int numberOfCards) {
		this.cards = new ArrayList<>();
		this.populate(cardScoreMode, numberOfCards);
		this.shuffle();
	}

	/**
	 * Shuffles the set of cards.
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}

	/**
	 * Generates the cards according to the card score mode.
	 *
	 * @param cardScoreMode
	 *            the card score mode which determine how to associate a score
	 * @param numberOfCards
	 *            the number of cards
	 */
	private void populate(CardScoreMode cardScoreMode, int numberOfCards) {
		for (int i = 1; i <= numberOfCards; i++) {
			int cardScore = getScore(i, cardScoreMode);
			this.cards.add(new Card(i, cardScore));
		}
	}

	/**
	 * Gets one card from the set and remove it.
	 *
	 * @return the one card
	 */
	public Card getOneCard() {
		return this.cards.remove(0);
	}

	/**
	 * Gets a score to assign to a card.
	 *
	 * @param cardScoreMode
	 *            the card score mode which determine how to associate a score
	 * @return the score
	 */
	private int getScore(int cardNumber, CardScoreMode cardScoreMode) {
		if (cardScoreMode == CardScoreMode.RANDOM_MODE)
			return Randomizer.nextInt(Constants.MIN_CARD_SCORE, Constants.MAX_CARD_SCORE);
		else if (cardScoreMode == CardScoreMode.REAL_SCORE_MODE)
			return 0;

		return 0;
	}
}/*La classe CardGame représente un ensemble de cartes du jeu. Chaque carte est unique et lorsqu'elle est distribuée à un joueur ou à une pile, elle est retirée de cet ensemble.

Voici ce que font les différentes méthodes de cette classe :

Constructeur CardGame(CardScoreMode cardScoreMode, int numberOfCards) : Ce constructeur crée une nouvelle instance de CardGame, génère un ensemble de cartes selon le mode de score de carte spécifié et le nombre de cartes, puis mélange l'ensemble de cartes.

shuffle() : Cette méthode mélange l'ensemble de cartes.

populate(CardScoreMode cardScoreMode, int numberOfCards) : Cette méthode privée génère un ensemble de cartes en fonction du mode de score de carte spécifié et du nombre de cartes. Pour chaque carte, un score est attribué en fonction du mode de score de carte.

getOneCard() : Cette méthode renvoie une carte de l'ensemble de cartes et la retire de cet ensemble.

getScore(int cardNumber, CardScoreMode cardScoreMode) : Cette méthode privée renvoie un score à attribuer à une carte. Le score est généré en fonction du mode de score de carte. Si le mode de score de carte est RANDOM_MODE, un score aléatoire est généré. Si le mode de score de carte est REAL_SCORE_MODE, le score est zéro.

En résumé, cette classe est utilisée pour représenter et manipuler un ensemble de cartes dans le cadre du jeu. Elle fournit des fonctionnalités pour générer l'ensemble de cartes, mélanger l'ensemble de cartes, et distribuer une carte de l'ensemble.*/
