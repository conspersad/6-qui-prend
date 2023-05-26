package takensix.card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import takensix.player.Player;

public class PlayedCardCollection extends HashMap<String, List<Card>>{

	private static final long serialVersionUID = 1L;

	public PlayedCardCollection(PlayedCardCollection playedCardCollection){
		for (Entry<String, List<Card>> entry : playedCardCollection.entrySet()){
			List<Card> cards = new ArrayList<>();
			
			for (Card c : entry.getValue())
				cards.add(new Card(c.getNumber(), c.getScore()));
			
			this.put(entry.getKey(), cards);			
		}
	}
	
	public PlayedCardCollection(){
		super();
	}
	
	public void updatePlayedCardsHistory(Entry<Player, Card> playedCard) {
		String playerName = playedCard.getKey().getName();
		Card c = playedCard.getValue();
		
		List<Card> cards = null;
		if (!this.containsKey(playerName))
			cards = new ArrayList<>();
		else
			cards = this.get(playerName);
		
		cards.add(c);
		this.put(playerName, cards);
	}
}
/*La classe PlayedCardCollection est une extension de la classe HashMap en Java, avec String comme type de clé et List<Card> comme type de valeur. Elle est utilisée pour stocker une collection de cartes jouées par différents joueurs dans un jeu.

Voici ce que font les différentes méthodes :

Le constructeur PlayedCardCollection(PlayedCardCollection playedCardCollection): Ce constructeur crée une nouvelle instance de PlayedCardCollection en copiant les cartes de playedCardCollection donnée en argument. Chaque Card est clonée et ajoutée à la nouvelle collection.

Le constructeur PlayedCardCollection(): Ce constructeur crée une nouvelle instance vide de PlayedCardCollection.

La méthode updatePlayedCardsHistory(Entry<Player, Card> playedCard) : Cette méthode met à jour l'historique des cartes jouées. Elle prend en argument une carte jouée par un joueur (représentée par une entrée de Map avec Player comme clé et Card comme valeur). Si le joueur (représenté par son nom) n'est pas déjà dans la collection, une nouvelle liste de cartes est créée. Sinon, la liste de cartes existante du joueur est récupérée. Ensuite, la carte jouée est ajoutée à la liste de cartes du joueur, et cette liste est mise à jour dans la collection.

En résumé, cette classe fournit un moyen d'enregistrer et de suivre les cartes que chaque joueur a jouées dans un jeu.




*/