package tn.essat.dao;

import java.util.List;

import tn.essat.model.Categorie;
import tn.essat.model.Emprunt;
import tn.essat.model.Livre;
import tn.essat.model.Utilisateur;

public interface IGestion {

	public List<Categorie> getAllCats();
	public List<Livre> getAllLivrebyCatId(int id);
	public void addLivre(Livre lv);
	public void deleteLivre(int id);
	public void addUser(Utilisateur user);
	public Categorie getCatById(int id);
	public Livre getLivreById(int id);
	public Utilisateur GetUser(String login,String password);
	public List<Emprunt>getEmpruntByUser(int id);
	public List<Emprunt>getAllEmprunt();
	public void addEmprunt(Emprunt emp);
	public List<Livre> getAllLivre();
	
}
