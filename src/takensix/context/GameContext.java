package takensix.context;

import takensix.card.CardScoreMode;
import takensix.output.OutputCollection;
import takensix.output.OutputConsole;
import takensix.output.OutputFile;
import takensix.output.OutputMode;

/**
 * The Class GameContext. It contains various parameters for game instantiation.
 */
public class GameContext {

	/** The number of players given cards. */
	public int numberOfGivenCards;

	/** The number of stacks. */
	public int numberOfStacks;

	/** The number of cards for the card game. */
	public int numberOfCards;

	/** The score limit which ends a party. */
	public int partyEndScore;

	/** The number of party. */
	public int numberOfParty;
	
	/** The number of players. */
	public int numberOfPlayers;
	
	/** The card score mode which determines how to associate score to cards. */
	public CardScoreMode cardScoreMode;

	/** The outputs. */
	public OutputCollection outputs;
	
	/**
	 * Instantiates a new game context.
	 *
	 * @param numberOfGivenCards
	 *            the number of given cards
	 * @param numberOfStacks
	 *            the number of stacks
	 * @param numberOfCard
	 *            the number of card
	 * @param partyEndScore
	 *            the party end score
	 * @param cardScoreMode
	 *            the card score mode
	 * @param outputs 
	 */
	public GameContext(int numberOfGivenCards, int numberOfStacks, int numberOfCard, int partyEndScore, int numberOfParty,
			CardScoreMode cardScoreMode, OutputMode outputMode) {
		this.numberOfGivenCards = numberOfGivenCards;
		this.numberOfStacks = numberOfStacks;
		this.numberOfCards = numberOfCard;
		this.partyEndScore = partyEndScore;
		this.numberOfParty = numberOfParty;
		this.cardScoreMode = cardScoreMode;
		
		this.initOutputs(outputMode);
	}
	
	public GameContext(GameContext gameContext) {
		this.numberOfGivenCards = gameContext.numberOfGivenCards;
		this.numberOfStacks = gameContext.numberOfStacks;
		this.numberOfCards = gameContext.numberOfCards;
		this.partyEndScore = gameContext.partyEndScore;
		this.numberOfParty = gameContext.numberOfParty;
		this.cardScoreMode = gameContext.cardScoreMode;
		this.numberOfPlayers = gameContext.numberOfPlayers;
		this.outputs = gameContext.outputs;
	}

	private void initOutputs(OutputMode outputMode){
		outputs = new OutputCollection();
		if (outputMode == OutputMode.CONSOLE || outputMode == OutputMode.CONSOLE_AND_FILE)
			outputs.add(new OutputConsole());
		if (outputMode == OutputMode.FILE || outputMode == OutputMode.CONSOLE_AND_FILE)
			outputs.add(new OutputFile());
	}
}
/*
La classe GameContext fournit le contexte général pour une instance de jeu. Elle contient divers paramètres pour l'instanciation d'un jeu, y compris :

numberOfGivenCards: le nombre de cartes distribuées aux joueurs.
numberOfStacks: le nombre de piles dans le jeu.
numberOfCards: le nombre total de cartes dans le jeu.
partyEndScore: le score qui met fin à une partie.
numberOfParty: le nombre de parties.
numberOfPlayers: le nombre de joueurs.
cardScoreMode: le mode de score des cartes qui détermine comment associer des scores aux cartes.
outputs: une collection d'objets Output qui seront utilisés pour afficher les résultats du jeu.
La classe possède deux constructeurs :

Le premier constructeur GameContext(int numberOfGivenCards, int numberOfStacks, int numberOfCard, int partyEndScore, int numberOfParty, CardScoreMode cardScoreMode, OutputMode outputMode) initialise un nouveau contexte de jeu avec les valeurs spécifiées pour les divers paramètres du jeu.

Le second constructeur GameContext(GameContext gameContext) est un constructeur de copie qui crée une nouvelle instance de GameContext à partir d'une instance existante de GameContext.

La méthode initOutputs(OutputMode outputMode) est utilisée pour initialiser la collection d'objets Output en fonction du mode de sortie (OutputMode) spécifié.

En résumé, cette classe définit le contexte de base pour une instance de jeu, y compris les paramètres du jeu et la manière dont les résultats du jeu sont affichés.*/