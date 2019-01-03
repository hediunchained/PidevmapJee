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

//import model.Client;
import model.*;
import model.MessageType;
import model.Projet;
import model.Request;
import model.TypeCategory;
import model.TypeClient;
import model.User;
import services.ProjectConsum;



@ManagedBean(name="RequestBean")
@SessionScoped
public class RequestBean implements Serializable{


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
	private int requestID;
	private int clientId;
	private String deposit_Date;
	private String deposit_hour;
	private String education;
	private String mandateFinish_date;
	private String mandatestart_date;
	private int price;
	private String requirements;
	private int yearsExperience;
	private String projectname;
	private String clientname;
	private String projectId;
	
	
	
	

	public String getProjectname() {
		return projectname;
	}


	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}


	public String getClientname() {
		return clientname;
	}


	public void setClientname(String clientname) {
		this.clientname = clientname;
	}


	public String getProjectId() {
		return projectId;
	}


	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}


	public int getRequestID() {
		return requestID;
	}


	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}


	public int getClientId() {
		return clientId;
	}


	public void setClientId(int clientId) {
		this.clientId = clientId;
	}


	

	public String getEducation() {
		return education;
	}


	public void setEducation(String education) {
		this.education = education;
	}


	

	public String getDeposit_Date() {
		return deposit_Date;
	}


	public void setDeposit_Date(String deposit_Date) {
		this.deposit_Date = deposit_Date;
	}


	public String getDeposit_hour() {
		return deposit_hour;
	}


	public void setDeposit_hour(String deposit_hour) {
		this.deposit_hour = deposit_hour;
	}


	public String getMandateFinish_date() {
		return mandateFinish_date;
	}


	public void setMandateFinish_date(String mandateFinish_date) {
		this.mandateFinish_date = mandateFinish_date;
	}


	public String getMandatestart_date() {
		return mandatestart_date;
	}


	public void setMandatestart_date(String mandatestart_date) {
		this.mandatestart_date = mandatestart_date;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getRequirements() {
		return requirements;
	}


	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}


	public int getYearsExperience() {
		return yearsExperience;
	}


	public void setYearsExperience(int yearsExperience) {
		this.yearsExperience = yearsExperience;
	}


	@EJB
	 ProjectConsum projectConsum;

	public RequestBean() {
		super();
		
	}
	
	
//	public void deleteCLient(Client c)
//    {
//    	int response= projectConsum.DeleteCLient(c.getClientId());
//	}
	 
	 public List<Request>getRessourcesList2s(){ 

	    	clientSk sk = new clientSk(2);
	        ArrayList<Request> listeUsers= new  ArrayList<>();

	    try {
	                JSONArray json = clientSk.readJsonFromUrl("http://localhost:22033/Request/IndexJson");
	                for (int i = 0, count = json.length(); i < count; i++) {
	                	Request s = new  Request();
	                JSONObject obj = (JSONObject)json.get(i);
	               s.setRequestID(((obj.getInt("RequestID"))));
	               s.setClientId(((obj.getInt("ClientId"))));
	               s.setRequirements(obj.get("Requirements").toString());
	               s.setPrice(((obj.getInt("Price"))));
	               s.setYearsExperience(obj.getInt("YearsExperience"));
	               s.setEducation(obj.get("Education").toString());
	               s.setDeposit_date(obj.get("Deposit_Date").toString());
	               s.setDeposit_hour(obj.get("Deposit_hour").toString());
	               s.setMandatestart_Date(obj.get("Mandatestart_date").toString());
	               s.setMandateFinish_date(obj.get("MandateFinish_date").toString());
	               s.setClientname(obj.get("ClientName").toString());
	               s.setProjectId(obj.get("ProjetID").toString());
	               s.setProjectname(obj.get("ProjectName").toString());
	              
	               
	               
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

	 public void deleteComp(Request c)
	    {
	    	int response= projectConsum.DeleteCompetance(c.getRequestID());
		}

	 
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
