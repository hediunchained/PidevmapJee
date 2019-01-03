package managedBeans;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import model.CustomerDateAndTimeDeserialize;
//import model.Client;
import model.Message;
import model.MessageType;
import model.Projet;
import model.Request;
import model.TypeCategory;
import model.TypeClient;
import model.User;
import services.ProjectConsum;
import java.text.SimpleDateFormat;  
import java.util.Date;  


@ManagedBean(name="MessageBean")
@SessionScoped
public class MessageBean implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


//	private String adresse;
//	private int clientId;
//	private Date end_Date;
//	private int levio_ressource_nb;
//	private String name;
//	private String pictureURL;
//	private Date start_Date;
//	private int total_Ressource_nb;
//	private String logoURL;
//	private UploadedFile image;
//	private int indice;	
	private int messageID;
	private String content;
	@JsonProperty("Date")
	@JsonDeserialize(using=CustomerDateAndTimeDeserialize.class)
	private Date date;
	@Enumerated(EnumType.STRING)
	private String messageType;
	private String Object;
	private boolean read;
	private int receiverId;
	private int senderId;
	private String target;
	private String sendername;
	
	
	
	
	public String getSendername() {
		return sendername;
	}


	public void setSendername(String sendername) {
		this.sendername = sendername;
	}


	public int getMessageID() {
		return messageID;
	}


	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	
	public String getMessageType() {
		return messageType;
	}


	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}


	public String getObject() {
		return Object;
	}


	public void setObject(String object) {
		Object = object;
	}


	public boolean isRead() {
		return read;
	}


	public void setRead(boolean read) {
		this.read = read;
	}


	public int getReceiverId() {
		return receiverId;
	}


	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}


	public int getSenderId() {
		return senderId;
	}


	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}


	public String getTarget() {
		return target;
	}


	public void setTarget(String target) {
		this.target = target;
	}

	@EJB
	 ProjectConsum projectConsum;

	public MessageBean() {
		super();
		
	}
	
	
//	public void deleteCLient(Client c)
//    {
//    	int response= projectConsum.DeleteCLient(c.getClientId());
//	}
	 
	 public List<Message>getRessourcesList2s(){ 

	    	clientSk sk = new clientSk(2);
	        ArrayList<Message> listeUsers= new  ArrayList<>();

	    try {
	                JSONArray json = clientSk.readJsonFromUrl("http://localhost:22033/Message/IndexJson");
	                for (int i = 0, count = json.length(); i < count; i++) {
	                	Message s = new  Message();
	                JSONObject obj = (JSONObject)json.get(i);
	               s.setMessageID(((obj.getInt("MessageID"))));
	               s.setMessageType(obj.get("MessageType").toString());
	               System.out.println(obj.get("Date").toString());
//	               s.setDate((Date)obj.get("Date"));
	               s.setContent(obj.get("Content").toString());
	               s.setObject(obj.get("Object").toString());
	               s.setRead(read);
	               s.setReceiverId(((obj.getInt("ReceiverId"))));
	               s.setSenderId(((obj.getInt("SenderId"))));
	               s.setTarget(obj.get("Target").toString());
	               s.setSendername(obj.get("Sendername").toString());
	              
	               
	               
                  listeUsers.add(s);

	             }
	                System.out.println(listeUsers);

	            } catch (IOException e) {
	                e.printStackTrace();
	            } catch (JSONException e) {
	                e.printStackTrace();
	            }
		return (listeUsers);
	    }	
	 
//	 public List<Message>getDetailsmessage(int Mid){ 
//
//	    	clientSk sk = new clientSk(2);
//	        ArrayList<Message> listeUsers= new  ArrayList<>();
//
//	    try {
//	                JSONArray json = clientSk.readJsonFromUrl("http://localhost:22033/Message/DetailsJson/"+Mid);
//	                for (int i = 0, count = json.length(); i < count; i++) {
//	                	Message s = new  Message();
//	                JSONObject obj = (JSONObject)json.get(i);
//	               s.setMessageID(((obj.getInt("MessageID"))));
//	               s.setMessageType(obj.get("MessageType").toString());
//	               s.setDate(obj.get("Date").toString());
//	               s.setContent(obj.get("Content").toString());
//	               s.setObject(obj.get("Object").toString());
//	               s.setRead(read);
//	               s.setReceiverId(((obj.getInt("ReceiverId"))));
//	               s.setSenderId(((obj.getInt("SenderId"))));
//	               s.setTarget(obj.get("Target").toString());
//	               s.setSendername(obj.get("Sendername").toString());
//	              
//	               
//	               
//               listeUsers.add(s);
//
//	             }
//	                System.out.println(listeUsers);
//
//	            } catch (IOException e) {
//	                e.printStackTrace();
//	            } catch (JSONException e) {
//	                e.printStackTrace();
//	            }
//		return (listeUsers);
//	    }	

//	 public List<Projet> getRessourcesList() throws ParseException{ 
//	 
//	    	clientSk sk = new clientSk(2);
//	        ArrayList<Projet> listeUsers= new  ArrayList<>();
//
//	    try {
//	                JSONArray json = clientSk.readJsonFromUrl("http://localhost:22033/Project/IndexAPI");
//	                for (int i = 0, count = json.length(); i < count; i++) {
//	                	Request s = new  Request();
//	                JSONObject obj = (JSONObject)json.get(i);
//	                
//	               s.setName(obj.get("Name").toString());
//	               s.setAdresse(obj.get("Adresse").toString());
////	               s.setStart_Date((Date) obj.get("Start_Date"));
////	               s.setEnd_Date((Date)obj.get("End_Date"));
//	               s.setTotal_Ressource_nb(obj.getInt("Total_Ressource_nb"));
//	               s.setLevio_ressource_nb(obj.getInt("Levio_ressource_nb"));
//	               s.setPictureURL(obj.get("PictureURL").toString());
//	               s.setProjetID(obj.getInt("ProjetID"));
//	               s.setClientId(obj.getInt("ClientId"));
//	              
//
//	                listeUsers.add(s);
//
//	             }
//	                System.out.println(listeUsers);
//
//	            } catch (IOException e) {
//	                e.printStackTrace();
//	            } catch (JSONException e) {
//	                e.printStackTrace();
//	            }
//		return (listeUsers);
//	    }	

	 
//	 public void addClient() throws ParseException {
//		 String navigateTo = "null";
//		    Client AddClient=new Client();
//	    	AddClient.setClientType(clientType);
//	    	AddClient.setCategory(category);
//	    	AddClient.setLogoURL(logoURL);
//	    	int response=projectConsum.ajouterClients(AddClient);
//	    	navigateTo = "/Afficher.xhtml?faces-redirect=true"; 
//	    	 }	 
//	 
//		public void imageFileUpload(FileUploadEvent e1) throws Exception{
//
//			this.image=e1.getFile();
//			image.write("C:\\Users\\Daboussi Yousri\\workspace\\projetvide\\projetvide\\projetvide-web\\src\\main\\webapp\\"+image.getFileName());
//			
//			//image.write("C:\\images\\"+image.getFileName());
//			
//			logoURL = image.getFileName();
//			System.out.println(logoURL);
//
//			}
//
//		 
//	public List<Projet> getListe() {
//		return FiltredProjet;
//	}
//
//	@PostConstruct
//	public void init() throws Exception{
//		FiltredProjet = projectConsum.testConsume();
//	}
//	
//	public void setFiltredProjet(List<Projet> filtredProjet) {
//		FiltredProjet = filtredProjet;
//	}
//
//	public List<Projet> getFiltredProjet() {
//		return FiltredProjet;
//	}

}
