package takensix.card;

/**
 * The Class Card. A Card has a unique number and a score used to calculate
 * Players score.
 * 
 */
public class Card {

	/** The number. */
	private int number;

	/** The score. */
	private int score;

	/**
	 * Instantiates a new card.
	 *
	 * @param number
	 *            the number
	 * @param score
	 *            the score
	 */
	public Card(int number, int score) {
		super();
		this.number = number;
		this.score = score;
	}

	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 *
	 * @param number
	 *            the new number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets the score.
	 *
	 * @param score
	 *            the new score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "[N�" + number + " (" + score + "p)]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		result = prime * result + score;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (number != other.number)
			return false;
		if (score != other.score)
			return false;
		return true;
	}

}
/*
La classe Card représente une carte de jeu avec deux attributs principaux : un numéro unique et un score.

Voici ce que font les différentes méthodes de cette classe :

Constructeur Card(int number, int score) : Ce constructeur crée une nouvelle instance de Card avec un numéro et un score spécifiés.

getNumber() et setNumber(int number) : Ces méthodes sont des getters et des setters pour l'attribut number de la carte.

getScore() et setScore(int score) : Ces méthodes sont des getters et des setters pour l'attribut score de la carte.

toString() : Cette méthode surcharge la méthode toString de la classe Object pour fournir une représentation sous forme de chaîne de caractères de l'objet Card. La chaîne retournée contient le numéro de la carte et son score.

hashCode() : Cette méthode surcharge la méthode hashCode de la classe Object pour retourner un code de hachage pour l'objet Card. Ce code de hachage est utilisé lors de l'utilisation de Card dans des collections basées sur des hachages comme HashMap.

equals(Object obj) : Cette méthode surcharge la méthode equals de la classe Object pour déterminer si deux objets Card sont égaux. Deux cartes sont considérées comme égales si leurs numéros et leurs scores sont identiques.

En résumé, cette classe est utilisée pour représenter et manipuler une carte de jeu individuelle dans le cadre du jeu.*/