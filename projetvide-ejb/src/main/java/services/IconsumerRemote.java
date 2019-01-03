package services;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ejb.Remote;
import javax.ws.rs.client.Client;

import model.Message;
import model.Projet;
import model.User;

@Remote
public interface IconsumerRemote {
	public List <Projet> testConsume() throws Exception;
//	public int ajouterClients(model.Client c) ;
	public int DeleteCLient(int id);
	public Message Details(String id);
	int updateProject(int idm, Message p);

//	public List dash();
//	public List <Projet> MyGETRequest() throws IOException;
//	public List<Projet> sendGet(InputStream in) throws Exception;
//	 public List<Projet> doInBackground(String... strings) throws Exception ;

}
