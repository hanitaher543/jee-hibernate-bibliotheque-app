package tn.essat.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.mindrot.jbcrypt.BCrypt;

import tn.essat.model.Categorie;
import tn.essat.model.Emprunt;
import tn.essat.model.Livre;
import tn.essat.model.Utilisateur;

public class GestionImp implements IGestion{
Session session;

public GestionImp() {
	
	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	Metadata metadata =  new MetadataSources(serviceRegistry).getMetadataBuilder().build();
	SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();	
	session=sessionFactory.openSession();

}

@Override
public List<Categorie> getAllCats() {
	Query<Categorie> req=session.createQuery("select c from Categorie c");
	return req.getResultList();
	
}

@Override
public List<Livre> getAllLivrebyCatId(int id) {

	Query<Livre> req = session.createQuery("select lv from Livre lv where lv.cat.id=:x ");
	req.setParameter("x", id);
	return req.getResultList();
	}
			
			


@Override
public void addLivre(Livre lv) {
	session.getTransaction().begin();//acces lil base mil hibernate 
	
	session.save(lv);
	session.getTransaction().commit();
	
}

@Override
public void deleteLivre(int id) {//tsuprimi objet
	Livre lv=session.find(Livre.class,id);
	session.getTransaction().begin();
	session.delete(lv);
	session.getTransaction().commit();

}
	

@Override
public void addUser(Utilisateur user) {
	session.getTransaction().begin();//base tbadlet
	
	session.save(user);
	session.getTransaction().commit();
	
}
	


@Override
public Categorie getCatById(int id) {
	
	return session.find(Categorie.class, id);
}

@Override
public Livre getLivreById(int id) {
	
	return session.find(Livre.class, id);
	}


@Override
public Utilisateur GetUser(String login, String password) {
	Query<Utilisateur> req = session.createQuery("select u from Utilisateur u where u.login=:x");
	req.setParameter("x", login);

	List<Utilisateur> liste = req.getResultList();

	for(Utilisateur u:liste) {
	if (BCrypt.checkpw(password, u.getPassword())) {//mot pass cryptée
	return u;
	}
	}

	return null;

	
}

public List<Emprunt> getEmpruntByUser(int id) {
Query<Emprunt> req=session.createQuery("select e from Emprunt e where e.user.id=:x");//e.user.id mta3 securité	
	
req.setParameter("x",id);
return req.getResultList();
}

@Override
public List<Emprunt> getAllEmprunt() {
	Query<Emprunt> req=session.createQuery("select e from Emprunt e ");	

return req.getResultList();
}


@Override
public void addEmprunt(Emprunt emp) {
	
session.getTransaction().begin();//base tbadlet
	
	session.save(emp);
	session.getTransaction().commit();
	
	
}

@Override
public List<Livre> getAllLivre() {
	
	Query<Livre> req=session.createQuery("select l from Livre l");
	return req.getResultList();
}

}