package takensix.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import takensix.utils.Clock;
import takensix.utils.StringMaker;

public class OutputFile implements Output {
	private final String FILE_PATH = "log";
	private final String FILE_NAME = "log.txt";
	
	private FileWriter file;
	
	public OutputFile() {
		String date = Clock.getFormattedDateNow().replaceAll(":", "-");
		try {
			File folder = new File(FILE_PATH);
			
			if(!folder.exists())
				folder.mkdir();
			
			File f = new File(FILE_PATH + "/" + date + "_" + FILE_NAME);
			
			if (!f.exists())
				f.createNewFile();
			
			this.file = new FileWriter(f, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Write.
	 *
	 * @param s the s
	 */
	public void write(String s){
		String date = "[" + Clock.getFormattedDateNow() + "] ";
		
		s = date + s.trim();
		s = s.replace("\n", "\n"+date);
		s = StringMaker.removeLast(s, "\n"+date);
		s += "\n";
		
		try {
			file.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		try {
			this.file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/*
Cette classe en Java, appelée "OutputFile", implémente également l'interface "Output". Elle est utilisée pour écrire du texte dans un fichier.

Lorsqu'une instance de la classe est créée, elle vérifie d'abord si le répertoire de destination du fichier existe. Si ce n'est pas le cas, elle crée le répertoire à l'aide de la classe File. Ensuite, elle vérifie si le fichier de destination existe. Si le fichier n'existe pas, elle crée un nouveau fichier avec un nom basé sur la date et l'heure actuelles.

La classe utilise un objet FileWriter pour écrire dans le fichier. Lorsque la méthode "write" est appelée avec une chaîne de caractères en paramètre, la méthode ajoute la date et l'heure actuelles au début de la chaîne, puis écrit la chaîne dans le fichier. La chaîne est également formatée de manière à ce que chaque nouvelle ligne soit précédée de la date et de l'heure. Enfin, la méthode "close" ferme le FileWriter pour libérer les ressources associées.

En résumé, cette classe permet d'écrire du texte dans un fichier de journal (log). Chaque ligne écrite est préfixée avec la date et l'heure actuelles. Cela peut être utilisé pour enregistrer des informations, des messages ou des journaux d'événements dans un fichier texte.*/