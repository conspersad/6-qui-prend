package takensix.context;

import java.util.List;

import takensix.card.Card;
import takensix.card.PlayedCardCollection;
import takensix.player.Player;
import takensix.stack.Stacks;

/**
 * The Class PlayContext. This context describes the state of the game at a
 * certain time. It is the given context given to players to help them
 * determining which move to play.
 */
public class PlayContext {

	/** The player who needs to play. */
	private Player player;

	/** The stacks statement for a certain turn. */
	private Stacks stacks;

	/** The game context. */
	private GameContext gameContext;
	
	/** The played card history. */
	private PlayedCardCollection playedCardHistory;

	/**
	 * Instantiates a new play context.
	 *
	 * @param player
	 *            the player who needs to play
	 * @param stacks
	 *            the stacks statement for a certain turn
	 * @param playedCardCollection
	 *            the number of players
	 */
	public PlayContext(GameContext gameContext, PlayedCardCollection playedCardCollection, Player player, Stacks stacks) {
		this.gameContext = new GameContext(gameContext);
		this.playedCardHistory = new PlayedCardCollection(playedCardCollection);
		this.player = new Player(player);
		this.stacks = new Stacks(stacks);		
	}

	/**
	 * Instantiates a new play context.
	 *
	 * @param playContext
	 *            the play context
	 */
	public PlayContext(PlayContext playContext) {
		this.gameContext = new GameContext(playContext.getGameContext());
		this.playedCardHistory = new PlayedCardCollection(playContext.getPlayedCardHistory());
		this.player = new Player(playContext.getPlayer());
		this.stacks = new Stacks(playContext.getStacks());
	}
	
	/**
	 * Gets the playable cards.
	 *
	 * @return the playable cards
	 */
	public List<Card> getMyPlayableCards() {
		return this.player.getCards();
	}
	
	/**
	 * Gets my score.
	 *
	 * @return my score
	 */
	public int getMyScore() {
		return this.player.getScore();
	}

	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Sets the player.
	 *
	 * @param player
	 *            the new player
	 */
	public void setPlayer(Player player) {
		this.player = player;
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

	public GameContext getGameContext() {
		return gameContext;
	}

	public void setGameContext(GameContext gameContext) {
		this.gameContext = gameContext;
	}

	public PlayedCardCollection getPlayedCardHistory() {
		return playedCardHistory;
	}

	public void setPlayedCardHistory(PlayedCardCollection playedCardHistory) {
		this.playedCardHistory = playedCardHistory;
	}
}/*
La classe PlayContext représente l'état du jeu à un moment précis. Elle fournit un contexte aux joueurs pour les aider à déterminer le coup à jouer. Voici ce que les attributs de cette classe représentent :

player: Le joueur qui doit jouer.
stacks: L'état des piles de cartes à un tour donné.
gameContext: Le contexte général du jeu.
playedCardHistory: L'historique des cartes jouées.
La classe a deux constructeurs :

Le premier PlayContext(GameContext gameContext, PlayedCardCollection playedCardCollection, Player player, Stacks stacks) crée un nouveau PlayContext en prenant le contexte de jeu, la collection des cartes jouées, le joueur et les piles de cartes.

Le second PlayContext(PlayContext playContext) est un constructeur de copie qui crée une nouvelle instance de PlayContext à partir d'une instance existante de PlayContext.

Il y a aussi plusieurs méthodes getter et setter pour récupérer et modifier les attributs de l'instance.

De plus, la méthode getMyPlayableCards() renvoie les cartes que le joueur actuel peut jouer, et la méthode getMyScore() renvoie le score actuel du joueur.

En résumé, cette classe sert à représenter l'état actuel du jeu à un moment précis, en gardant une trace du joueur, des piles de cartes, du contexte général du jeu, et de l'historique des cartes jouées.




*/