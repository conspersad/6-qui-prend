package takensix.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
	static BufferedReader scan;
	
	static {
		scan = new BufferedReader(new InputStreamReader(System.in));	
	}
	
	public static final int nextInt(){
		int selected = -1;
		try {
			selected = Integer.parseInt(scan.readLine());
		} catch (NumberFormatException | IOException e) {
		}
		return selected;
	}
	
	public static final void enter() {
		StringMaker.pressEnter();
		try {
			scan.readLine();
		} catch (IOException e) {
		}
	}
}/*
La classe Reader est une classe utilitaire conçue pour lire les entrées de l'utilisateur à partir de la console.

Voici ce que font les méthodes:

nextInt(): Cette méthode tente de lire une ligne de l'entrée standard (c'est-à-dire la console) et de la convertir en un int. Si la conversion réussit, elle renvoie l'entier. Sinon, elle renvoie -1. Notez que si une exception est levée pendant la lecture ou la conversion, elle est ignorée (c'est-à-dire qu'elle est attrapée mais aucune action n'est prise).

enter(): Cette méthode affiche un message pour indiquer à l'utilisateur d'appuyer sur la touche Entrée (via l'appel à StringMaker.pressEnter()), puis tente de lire une ligne de l'entrée standard. Encore une fois, si une exception est levée pendant la lecture, elle est ignorée.

Ces méthodes sont utiles pour interagir avec l'utilisateur via la console, par exemple pour lui demander de choisir une option ou de confirmer une action.*/
