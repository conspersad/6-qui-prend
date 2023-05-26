package takensix.utils;

import java.util.Random;

public class Randomizer {
	static Random random;
	
	static {
		random = new Random();
	}
	
	public static int nextInt(int minIncluded, int maxIncluded) {
		return random.nextInt(maxIncluded - minIncluded + 1) + minIncluded;
	}
	
	public static int nextInt(int maxExcluded) {
		return random.nextInt(maxExcluded);
	}
}
/*
La classe Randomizer est une classe utilitaire qui encapsule l'objet java.util.Random pour générer des nombres aléatoires. Elle fournit deux méthodes statiques pour obtenir des nombres aléatoires, facilitant ainsi leur utilisation dans d'autres parties du code.

Voici ce que font les méthodes:

nextInt(int minIncluded, int maxIncluded): Cette méthode renvoie un nombre entier aléatoire qui est inclus entre minIncluded et maxIncluded. Par exemple, nextInt(1, 3) peut renvoyer 1, 2 ou 3.

nextInt(int maxExcluded): Cette méthode renvoie un nombre entier aléatoire qui est inférieur à maxExcluded. Par exemple, nextInt(3) peut renvoyer 0, 1 ou 2.

Ces méthodes sont utiles pour générer des nombres aléatoires dans une certaine plage, ce qui peut être nécessaire pour diverses fonctionnalités dans un jeu, comme choisir un joueur ou une carte au hasard.*/