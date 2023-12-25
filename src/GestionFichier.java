import java.io.File;
import java.text.SimpleDateFormat;

public class GestionFichier {
	private String adress;
	
	public GestionFichier() {
		this.adress = "D:\\";
	}
	public GestionFichier(String adress) {
		this.adress = adress;
	}
	
	public String getAdress() {
		return this.adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public void creeFichier(String nomFichier) {
		File adr = new File(this.adress);
		if(adr.exists()) {
			if(adr.isDirectory()) {
				try {
					File fichier = new File(this.adress+"\\"+nomFichier);
					fichier.createNewFile();
					System.out.println("Fichier créer avec succés :)");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				//ou bien catch(IOException e){ e.printStackTrace(); }
			}
			else
				System.out.print("Impossible, car "+this.adress+" est un fichier !");
		}
		else
			System.out.println("L'adresse n'existe pas");		
	}
	
	public void creeDosier(String nomDossier) {
		File adr = new File(this.adress);
		if(adr.exists()) {
			if(adr.isDirectory()) {
				File doss = new File(this.adress+"\\"+nomDossier);
				doss.mkdir();
				System.out.println("Dossier créer avec succes :)");
			}
			else
				System.out.println("Impossible, car "+this.adress+" est un fichier !");
		}
		else
			System.out.println("L'adresse n'existe pas");
	}
	
	public void supprimer(String str) {
		File adr = new File(str);
		if(adr.exists()) {
			adr.delete();
			System.out.println("Le fichier est supprimé avec succés :)");
		}
		else
			System.out.println("L'adresse n'existe pas");
	}
	
	public void lst() {
		File adr = new File(this.adress);
		if(adr.exists()) {
			if(adr.isDirectory()) {
				File[] contenu = adr.listFiles();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
				for(File el:contenu) {
					System.out.print(el.getName()+"\t");
					if(el.isDirectory())
						System.out.print("<DOSS> \t");
					if(el.isFile())
						System.out.print("<FICH> \t");
					System.out.print(sdf.format(el.lastModified())+"\t");
					System.out.println(el.length()/1024+"Ko");
				}
			}
			else
				System.out.println("Impossible, car "+this.adress+" est un fichier !");
		}
		else
			System.out.println("L'adresse n'existe pas");
	}
		
	
	public static void main(String[] args) {
		GestionFichier file;
		file = new GestionFichier("F:\\Etude\\S3 Cycle d'ing\\Java\\mes_traveaux_pratiques");
		file.creeFichier("mustapha.txt");
		file.creeDosier("elbachir");
		file.supprimer("F:\\Etude\\S3 Cycle d'ing\\Java\\mes_traveaux_pratiques\\mustapha.txt");
		file.lst();
	}

}
