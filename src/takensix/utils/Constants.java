package takensix.utils;

/**
 * The Class Constants.
 */
public abstract class Constants {
	
	/** The Constant MIN_CARD_SCORE. */
	public final static int MIN_CARD_SCORE = 1;
	
	/** The Constant MAX_CARD_SCORE. */
	public final static int MAX_CARD_SCORE = 7;
	
	/** The Constant MAX_CARD_PER_STACK. */
	public final static int MAX_CARD_PER_STACK = 5;
	
	/** The Constant HUMAN_TIMEOUT. */
	public final static int NO_TIMEOUT = Integer.MAX_VALUE;
	
	/** The Constant IA_TIMEOUT. */
	public final static int IA_TIMEOUT = 10;
}/*MIN_CARD_SCORE : Cette constante représente le score minimum que peut avoir une carte dans le jeu. La valeur est définie à 1.

MAX_CARD_SCORE : Cette constante représente le score maximum qu'une carte peut avoir dans le jeu. La valeur est définie à 7.

		MAX_CARD_PER_STACK : Cette constante représente le nombre maximum de cartes qu'une pile peut contenir dans le jeu. La valeur est définie à 5.

		NO_TIMEOUT : Cette constante semble être utilisée pour représenter une absence de délai d'attente (timeout). La valeur est définie à Integer.MAX_VALUE, ce qui est essentiellement le plus grand nombre entier que vous pouvez représenter en Java.

		IA_TIMEOUT : Cette constante représente le délai d'attente (en secondes, probablement) pour une action d'une intelligence artificielle (IA) dans le jeu. La valeur est définie à 10.

		Chacune de ces constantes définit une règle ou une contrainte qui est probablement utilisée dans le jeu. Par exemple, MAX_CARD_PER_STACK pourrait être utilisée pour vérifier si une pile de cartes a atteint sa taille maximale et ne peut plus accepter de nouvelles cartes.*/
