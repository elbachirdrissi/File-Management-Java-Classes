import java.io.*;

public class TestFichier {

	private File fichier;
	
	public TestFichier() {
		this.fichier = null;
	}
	public TestFichier(String adrr) {
		this.fichier = new File(adrr);
	}
	
	public File getFichier() {
		return this.fichier;
	}
	public void setFichier(File fichier) {
		this.fichier = fichier;
	}
	
	public void modifier(String txt) {
		if(this.fichier != null) {
			try{
				Writer file = new FileWriter(this.fichier, true);
				file.write(txt);
				file.close();
				
				/*Writer file_writer = new FileWriter(this.fichier, true);
				BufferedWriter file_bufferedwriter = new BufferedWriter(file_writer);
				file_bufferedwriter.write(txt);
				file_bufferedwriter.close();*/
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Le chemain est invalide !");
		}
	}
	
	public void afficher() {
		if(this.fichier != null) {
			try {
				Reader file_reader = new FileReader(this.fichier);
				BufferedReader file_bufferedreader = new BufferedReader(file_reader);
				String ligne = file_bufferedreader.readLine();
				while(ligne != null) {
					System.out.println(ligne);
					ligne = file_bufferedreader.readLine();
				}
				file_bufferedreader.close();
			}catch(IOException a) {
				a.printStackTrace();
			}
		}
		else {
			System.out.println("Le chemain est invalide !");
		}
	}
	
	public void copierColler(String adresse) {
		if(this.fichier != null) {
			File destination = new File(adresse);
			try {
				Reader file_reader = new FileReader(this.fichier);
				BufferedReader file_bufferedreader = new BufferedReader(file_reader);
				Writer file_writer = new FileWriter(destination);
				BufferedWriter file_bufferedWriter = new BufferedWriter(file_writer);
				String ligne = file_bufferedreader.readLine();
				while(ligne != null) {
					file_bufferedWriter.write(ligne);
					ligne = file_bufferedreader.readLine();
				}
				file_bufferedWriter.close();
				file_bufferedreader.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Le chemain est invalide !");
		}
	}
		
	public static void main(String[] args) {
		TestFichier file;
		file = new TestFichier("F:\\Etude\\S3 Cycle d'ing\\Java\\mes_traveaux_pratiques\\elbachir.txt");
		file.modifier("Ajouté ce texte au fichier");
		file.afficher();
		file.copierColler("F:\\Etude\\S3 Cycle d'ing\\Java\\elbachir.txt");
	}
}