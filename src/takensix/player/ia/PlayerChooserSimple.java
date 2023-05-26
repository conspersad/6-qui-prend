
package takensix.player.ia;

import java.util.List;
import java.util.Map.Entry;

import takensix.card.Card;
import takensix.context.PlayContext;
import takensix.player.PlayerChooser;
import takensix.utils.Simulator;
import takensix.utils.StringMaker;

public class PlayerChooserSimple implements PlayerChooser {

	@Override
	public Card chooseCard(PlayContext playContext) {
		Card bestCard = null;
		double bestScore = Double.MAX_VALUE;
		
		this.println(playContext, StringMaker.stacks(playContext.getStacks()));
		this.println(playContext, StringMaker.playedCards(playContext.getPlayedCardHistory()));

		this.println(playContext, "Let me evaluate my situation");
		
		// Get card with the best evaluation
		for (Card c : playContext.getMyPlayableCards()) {
			double score = eval(new PlayContext(playContext), c);
						
			if (score < bestScore) {
				bestCard = c;
				bestScore = score;
			}
		}

		this.print(playContext, "So I will play " + bestCard);
		
		return bestCard;
	}

	@Override
	public int chooseStack(PlayContext playContext) {
		int bestKey = -1;
		int bestValue = Integer.MAX_VALUE;
		
		// Get the stack with the lowest amount of point
		for (Entry<Integer, List<Card>> e : playContext.getStacks().entrySet()) {
			int score = 0;
			for (Card c : e.getValue())
				score += c.getScore();

			if (bestKey < 0 || score < bestValue) {
				bestValue = score;
				bestKey = e.getKey();
			}
		}
		
		return bestKey;
	}

	private double eval(PlayContext playContext, Card c) {
		
		// Evaluation score for the move. The lower this score is, the better the move is.
		double evalScore = 0;
		
		double scoreDiff;
		double distance;
		
		// The more I play closer to the destination stack's card, the less I can be bypassed by another player
		distance = (double) Simulator.computeDistance(playContext, c);
		
		// Compute the difference between my score before and after having played the card
		scoreDiff = -playContext.getMyScore();
		PlayContext playContextAfter = Simulator.simulate(playContext, c);
		scoreDiff += playContextAfter.getMyScore();

		// If I get a stack 
		if (scoreDiff > 0)
			evalScore += 100;
		
		evalScore += distance;
		
		this.print(playContext, "If I play " + c + ", I evaluate a score of " + evalScore);
	
		return evalScore;
	}
}
/*Cette classe en Java, appelée "PlayerChooserSimple", implémente l'interface "PlayerChooser". Elle représente une stratégie simple de choix de carte pour un joueur IA dans le jeu TakenSix.

Voici un aperçu des principales fonctionnalités de cette classe :

La méthode "chooseCard" permet à l'IA de choisir une carte à jouer en fonction du contexte de jeu donné (objet "PlayContext"). Elle évalue chaque carte jouable en utilisant la méthode "eval" et choisit celle ayant le meilleur score d'évaluation (le score le plus bas est considéré comme le meilleur). Avant de prendre une décision, elle affiche le contexte de jeu, les piles de cartes et les cartes jouées jusqu'à présent.
La méthode "chooseStack" permet à l'IA de choisir une pile dans laquelle placer la carte sélectionnée précédemment. Elle évalue chaque pile en calculant la somme des scores des cartes qu'elle contient, puis choisit la pile avec le score le plus bas. Elle retourne l'index de la pile choisie.
La méthode "eval" est utilisée pour évaluer une carte donnée en fonction du contexte de jeu. Elle calcule un score d'évaluation pour la carte, en tenant compte de facteurs tels que la distance entre la carte et la pile de destination, la différence de score avant et après avoir joué la carte, et si la carte permet d'obtenir une pile. Plus le score d'évaluation est bas, meilleure est la carte.
La classe utilise également les méthodes auxiliaires "print" et "println" pour afficher des informations de débogage.

En résumé, cette classe représente une stratégie simple de choix de carte pour un joueur IA dans le jeu TakenSix. Elle évalue les cartes jouables en fonction de différents critères et choisit la carte et la pile qui sont considérées comme les meilleures selon ces critères d'évaluation.*/