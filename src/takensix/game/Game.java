package takensix.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import takensix.card.Card;
import takensix.card.CardGame;
import takensix.card.PlayedCardCollection;
import takensix.context.GameContext;
import takensix.player.Player;
import takensix.stack.StackManager;

/**
 * The Class Game which represents a TakenSix game. This object is manipulated
 * by the GameManager.
 */
public class Game {

	/** The players. */
	private List<Player> players;

	/** The cards game. */
	private CardGame cards;

	/** The stack manager which contains and handles the stacks. */
	private StackManager stackManager;

	/**
	 * The played card list corresponding to the card played by players at a
	 * certain time.
	 */
	private Map<Player, Card> playedCardList;

	/** The played cards history. */
	private PlayedCardCollection playedCardsHistory;

	/**
	 * Instantiates a new game.
	 *
	 * @param context
	 *            the context containing various parameters for the game.
	 */
	public Game(GameContext context) {
		this.players = new ArrayList<>();
		this.stackManager = new StackManager(context.numberOfStacks);
		this.cards = new CardGame(context.cardScoreMode, context.numberOfCards);
		this.playedCardList = new HashMap<>();
		this.playedCardsHistory = new PlayedCardCollection();
	}

	/**
	 * Gets the lower played card according to the card's number and remove it
	 * from played cards list.
	 *
	 * @return the lower played card
	 */
	public Entry<Player, Card> getLowerPlayedCard() {
		Entry<Player, Card> minimumCard = null;
		for (Entry<Player, Card> entry : this.playedCardList.entrySet()) {
			if (minimumCard == null || minimumCard.getValue().getNumber() > entry.getValue().getNumber())
				minimumCard = entry;
		}
		
		this.playedCardsHistory.updatePlayedCardsHistory(minimumCard);
		playedCardList.remove(minimumCard.getKey());
		return minimumCard;
	}

	/**
	 * Gets the cards.
	 *
	 * @return the cards
	 */
	public CardGame getCards() {
		return cards;
	}

	/**
	 * Sets the cards.
	 *
	 * @param cards
	 *            the new cards
	 */
	public void setCards(CardGame cards) {
		this.cards = cards;
	}

	/**
	 * Gets the played card list.
	 *
	 * @return the played card list
	 */
	public Map<Player, Card> getPlayedCardList() {
		return playedCardList;
	}

	/**
	 * Adds the player.
	 *
	 * @param p
	 *            the p
	 */
	public void addPlayer(Player p) {
		this.players.add(p);
	}

	/**
	 * Gets the players.
	 *
	 * @return the players
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * Sets the players.
	 *
	 * @param players
	 *            the new players
	 */
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	/**
	 * Gets the stack manager.
	 *
	 * @return the stack manager
	 */
	public StackManager getStackManager() {
		return stackManager;
	}

	/**
	 * Sets the stack manager.
	 *
	 * @param stackManager
	 *            the new stack manager
	 */
	public void setStackManager(StackManager stackManager) {
		this.stackManager = stackManager;
	}

	/**
	 * Adds the played card.
	 *
	 * @param player
	 *            the player
	 * @param card
	 *            the card
	 */
	public void addPlayedCard(Player player, Card card) {
		this.playedCardList.put(player, card);
	}
	
	/**
	 * Gets the played cards history.
	 *
	 * @return the played cards history
	 */
	public PlayedCardCollection getPlayedCardsHistory() {
		return playedCardsHistory;
	}

	/**
	 * Sets the played cards history.
	 *
	 * @param playedCardsHistory the new played cards history
	 */
	public void setPlayedCardsHistory(PlayedCardCollection playedCardsHistory) {
		this.playedCardsHistory = playedCardsHistory;
	}

}
/*Cette classe en Java, appelée "Game", représente un jeu TakenSix. Elle est manipulée par la classe "GameManager".

Voici un aperçu des principales fonctionnalités de cette classe :

Elle contient une liste de joueurs (attribut "players") représentant les joueurs du jeu.
Elle gère une instance de "CardGame" (attribut "cards") qui représente le jeu de cartes utilisé dans le jeu TakenSix.
Elle gère un gestionnaire de piles (attribut "stackManager") qui contient et gère les piles utilisées dans le jeu.
Elle a une liste de cartes jouées (attribut "playedCardList") associée à chaque joueur, qui représente les cartes jouées par les joueurs à un moment donné.
Elle gère un historique des cartes jouées (attribut "playedCardsHistory") qui enregistre les cartes jouées précédemment.
Les principales méthodes de la classe incluent :

"getLowerPlayedCard": Cette méthode permet d'obtenir la carte jouée la plus basse (avec la plus petite valeur de numéro de carte) parmi les cartes jouées par les joueurs. Elle supprime également cette carte de la liste des cartes jouées.
"getCards" et "setCards": Ces méthodes permettent d'obtenir et de définir l'instance de "CardGame" utilisée dans le jeu.
"getPlayedCardList": Cette méthode permet d'obtenir la liste des cartes jouées associée à chaque joueur.
"addPlayer", "getPlayers" et "setPlayers": Ces méthodes permettent d'ajouter des joueurs à la liste des joueurs, d'obtenir la liste des joueurs et de définir la liste des joueurs.
"getStackManager" et "setStackManager": Ces méthodes permettent d'obtenir et de définir l'instance de "StackManager" utilisée dans le jeu.
"addPlayedCard": Cette méthode permet d'ajouter une carte jouée par un joueur à la liste des cartes jouées.
"getPlayedCardsHistory" et "setPlayedCardsHistory": Ces méthodes permettent d'obtenir et de définir l'historique des cartes jouées.
En résumé, cette classe représente un jeu TakenSix avec ses joueurs, ses cartes, son gestionnaire de piles et son historique des cartes jouées. Elle fournit des méthodes pour manipuler et gérer ces éléments dans le cadre du jeu TakenSix.*/