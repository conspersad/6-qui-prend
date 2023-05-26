package takensix.player;

import takensix.card.Card;
import takensix.context.PlayContext;

/**
 * The Interface PlayerChooser. This is the brain of the Players. You need to
 * implement this interface if you want to create your own IA.
 */
public interface PlayerChooser {

	/**
	 * Chooses a card to play. This method is called each turn of the party.
	 * The cards to play are contained by the Player object in the PlayContext.
	 * Don't forget to use the Simulator. ;)
	 * 
	 * @param playContext
	 *            the play context
	 * @return the card selected
	 */
	Card chooseCard(PlayContext playContext);

	/**
	 * Chooses a stack when the played card is lower than the every last stacked card. 
	 * This method is called each time the player plays a card which can't be stacked on a stack.
	 * 
	 * Example : 
	 * The stacks are filled as follow :
	 * {1} [N�12 (6p)] (1 card(s) - total : 6pt(s))
	 * {2} [N�18 (7p)] (4 card(s) - total : 25pt(s))
	 * {3} [N�98 (4p)] (5 card(s) - total : 18pt(s))
	 * {4} [N�73 (3p)] (1 card(s) - total : 3pt(s))
	 * {5} [N�44 (6p)] (5 card(s) - total : 14pt(s))
	 * 
	 * I played [N�9 (2p)]. 
	 * This card can't be stacked on any stack because 9 is lower than 12, 18, 98, 73 and 44.
	 * I need to clean one of the stacks in order to play my card. 
	 * For example, I will select the stack {4}, get 3 points 
	 * (because the sum of the score of the cards contained b the stack is 3)
	 * and the stacks will be as follow :
	 * {1} [N�12 (6p)] (1 card(s) - total : 6pt(s))
	 * {2} [N�18 (7p)] (4 card(s) - total : 25pt(s))
	 * {3} [N�98 (4p)] (5 card(s) - total : 18pt(s))
	 * {4} [N�9 (2p)] (1 card(s) - total : 2pt(s))
	 * {5} [N�44 (6p)] (5 card(s) - total : 14pt(s))
	 *
	 * @param playContext
	 *            the play context
	 * @return the stack index to get (begins at 1)
	 */
	int chooseStack(PlayContext playContext);
	
	/**
	 * Write a string into outputs.
	 * @param playContext
	 * @param s
	 */
	default void print(PlayContext playContext, String s){
		String template = "[" + playContext.getPlayer().getName() + "] ";
		s = s.trim().replaceAll("\n", "\n"+template);
		playContext.getGameContext().outputs.printDebug(template + s);
	}
	
	/**
	 * Write a line into outputs.
	 * @param playContext
	 * @param s
	 */
	default void println(PlayContext playContext, String s){
		String template = "[" + playContext.getPlayer().getName() + "] ";
		s = s.trim().replaceAll("\n", "\n"+template);
		playContext.getGameContext().outputs.printlnDebug(template + s);
	}
}
/*L'interface PlayerChooser sert à définir les comportements essentiels d'un joueur dans le jeu. Elle spécifie les opérations que chaque joueur doit pouvoir effectuer, notamment le choix d'une carte à jouer et le choix d'une pile à prendre lorsque la carte jouée ne peut être empilée sur aucune pile existante.

Si vous souhaitez créer votre propre intelligence artificielle (IA) pour ce jeu, vous devez implémenter cette interface. Voici ce que chaque méthode de cette interface fait:

Card chooseCard(PlayContext playContext): Cette méthode est appelée à chaque tour de la partie et sert à choisir une carte à jouer. Les cartes à jouer sont contenues dans l'objet Player du PlayContext.

int chooseStack(PlayContext playContext): Cette méthode est appelée chaque fois que le joueur joue une carte qui ne peut être empilée sur aucune pile. Elle sert à choisir une pile à prendre lorsque la carte jouée est inférieure à toutes les dernières cartes empilées.

void print(PlayContext playContext, String s) et void println(PlayContext playContext, String s): Ces deux méthodes permettent d'écrire une chaîne de caractères dans les sorties du jeu, avec le nom du joueur en préfixe. println ajoute également un saut de ligne à la fin.

En somme, l'interface PlayerChooser définit le comportement des joueurs dans le jeu. Les méthodes de cette interface sont utilisées pour choisir une carte à jouer, choisir une pile à prendre, et écrire dans les sorties du jeu.*/