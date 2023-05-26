package takensix.context;

import takensix.card.CardScoreMode;
import takensix.output.OutputMode;

/**
 * The Class BasicContext.
 * The real TakenSix context :
 * * 10 cards given to players
 * * 5 stacks to play with
 * * 104 unique cards
 * * 66 is the end of party score
 */
public class BasicContext extends GameContext {
	
	/**
	 * Instantiates a new basic context.
	 */
	public BasicContext(int numberOfParty, OutputMode outputMode) {
		super(10, 5, 104, 66, numberOfParty, CardScoreMode.RANDOM_MODE, outputMode);
	}
}/*La classe BasicContext étend la classe GameContext et représente un contexte de jeu spécifique pour le jeu "TakenSix". C'est la configuration de base du jeu qui détermine les paramètres de base du jeu, tels que le nombre de cartes distribuées aux joueurs, le nombre de piles avec lesquelles jouer, le nombre total de cartes uniques dans le jeu, et le score à atteindre pour terminer une partie.

La classe possède un unique constructeur BasicContext(int numberOfParty, OutputMode outputMode). Ce constructeur initialise un nouveau contexte de jeu "de base" avec les valeurs prédéfinies comme suit :

Le nombre de cartes distribuées aux joueurs est 10 (super argument 1).
Le nombre de piles pour jouer est 5 (super argument 2).
Le nombre total de cartes uniques dans le jeu est 104 (super argument 3).
Le score de fin de partie est 66 (super argument 4).
Le mode de score des cartes est défini comme aléatoire (CardScoreMode.RANDOM_MODE).
Il prend deux arguments numberOfParty et outputMode :

numberOfParty : le nombre de parties à jouer. Il est passé au constructeur de la classe mère GameContext.
outputMode : le mode de sortie à utiliser pour l'affichage des résultats du jeu. Il est aussi passé au constructeur de la classe mère GameContext.
En résumé, cette classe définit un contexte de base pour le jeu "TakenSix".*/
