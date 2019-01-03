package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;

import model.*;


@Stateful
@LocalBean
public class ProjectConsum implements IconsumerRemote{

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Client client = ClientBuilder.newClient();
//		WebTarget target =client.target("http://localhost:22033/Project/IndexAPI");
//		Response reponse = target.request().get();
//		System.out.println(reponse.readEntity(String.class));
//	
//	}
	
	

	@PersistenceContext(unitName= "projetvide-ejb")
	   EntityManager em;

	public List <Projet> testConsume() throws Exception {	
		
		Client client = ClientBuilder.newClient();
		WebTarget target =client.target("http://localhost:22033/Project/IndexAPI");
		List<Projet> reponse = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Projet>>(){});
		 return reponse; 
		 
	}
	public int DeleteCompetance(int id) {
		Client client = ClientBuilder.newClient();
		WebTarget target =client.target("http://localhost:22033/Request/DeleteJson/"+id);
		Invocation.Builder invocationBuilder=target.request(MediaType.APPLICATION_JSON);
		//Response reponse = target.request().get();
		Response response =invocationBuilder.delete();
		System.out.println(response.readEntity(String.class));
		return 0;
	}

	 
	
//public void ajouterClient(model.Client client) {
//	em.persist(client);
//
//}
 
//public int ajouterClients(model.Client c) {
//	Client client = ClientBuilder.newClient();
//	WebTarget target =client.target("http://localhost:22033/API/AddClient");
//	Invocation.Builder invocationBuilder=target.request(MediaType.APPLICATION_JSON);
//	//Response reponse = target.request().get();
//	Response response =invocationBuilder.post(Entity.entity(c, MediaType.APPLICATION_JSON));
//	//System.out.println(response.readEntity(String.class));
//	return 0;
//}
public int DeleteCLient(int id) {
	Client client = ClientBuilder.newClient();
	WebTarget target =client.target("http://localhost:22033/API/Delete/"+id);
	Invocation.Builder invocationBuilder=target.request(MediaType.APPLICATION_JSON);
	//Response reponse = target.request().get();
	Response response =invocationBuilder.delete();
	//System.out.println(response.readEntity(String.class));
	return 0;
}
@Override
public int updateProject(int idm, Message p) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public Message Details(String id) {
	// TODO Auto-generated method stub
	return null;
}

//public List dash() {
//	Client client=ClientBuilder.newClient();
//	WebTarget target= client.target("http://localhost:22033/Home/DashJ");
//	Response response=target.request().get();
//	List res=response.readEntity(List.class);
//		  return res;
//	// TODO Auto-generated method stub
//
//}


//	    public void JSONParser(String url){
//	        this.serverUrl = url;
//	    }
//	    
//	    String url1 = "http://localhost:22033/Project/IndexAPI"; 
//	    new JSONParser(url).execute();
//	    
//	    protected String doInBackground(String... strings) {
//	    	
//	        URL url;
//	        HttpURLConnection urlConnection = null;
//
//	        try {
//	            url = new URL(serverUrl);
//	            urlConnection = (HttpURLConnection) url.openConnection();
//
//	            int responseCode = urlConnection.getResponseCode();
//
//	            if(responseCode == HttpURLConnection.HTTP_OK){
//	                server_response = readStream(urlConnection.getInputStream());
//	                
//	                return server_response;
//	            }
//
//	        } catch (MalformedURLException e) {
//	            e.printStackTrace();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//
//	        return server_response;
//	    }
//	    
//	
//	    private String readStream(InputStream in) {
//	        BufferedReader reader = null;
//	        StringBuffer response = new StringBuffer();
//	        try {
//	            reader = new BufferedReader(new InputStreamReader(in));
//	            String line = "";
//	            while ((line = reader.readLine()) != null) {
//	                response.append(line);
//	            }
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        } finally {
//	            if (reader != null) {
//	                try {
//	                    reader.close();
//	                } catch (IOException e) {
//	                    e.printStackTrace();
//	                }
//	            }
//	        }
//	        return response.toString();
//	    }
	
	
	

	
//	  public List<Projet> doInBackground(String... strings) throws Exception {
//	        URL url;
//	        HttpURLConnection urlConnection = null;
//
//	        try {
//	            url = new URL(serverUrl);
//	            urlConnection = (HttpURLConnection) url.openConnection();
//	            int responseCode = urlConnection.getResponseCode();
//	            if(responseCode == HttpURLConnection.HTTP_OK){
//	                server_response = sendGet(urlConnection.getInputStream());
//	               
//	                return server_response;
//	            }
//	            
//	        
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//
//	        return server_response;
//	    }
	

//	
//	public List<Projet> sendGet() throws Exception {
//		
//		String url = "http://localhost:22033/Project/IndexAPI";
//		
//		URL obj = new URL(url);
//		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//
//		// optional default is GET
//        con.setRequestMethod("GET");
//
//		//add request header
//		con.setRequestProperty("User-Agent", USER_AGENT);
//
//		int responseCode = con.getResponseCode();
//		System.out.println("\nSending 'GET' request to URL : " + url);
//		System.out.println("Response Code : " + responseCode);
//
//		BufferedReader in1 = new BufferedReader(
//		        new InputStreamReader(con.getInputStream()));
//		String inputLine;
//		StringBuffer response = new StringBuffer();
//
//		while ((inputLine = in1.readLine()) != null) {
//			response.append(inputLine);
//		}
//		in1.close();
//
//		//print result
//		System.out.println(response.toString());
//		
//		return response1;
//
//	}
	

	//public List <Projet> MyGETRequest() throws IOException {
//	    URL urlForGetRequest = new URL("http://localhost:22033/Project/IndexAPI");
//	    String readLine = null;
//	    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
//	    conection.setRequestMethod("GET");
//	    
//	    int responseCode = conection.getResponseCode();
//	    if (responseCode == HttpURLConnection.HTTP_OK) {
//	        BufferedReader in = new BufferedReader(
//	            new InputStreamReader(conection.getInputStream()));
//	        
//	        StringBuffer response = new StringBuffer();
//	        while ((readLine = in .readLine()) != null) {
//	            response.append(readLine);
//	        } in .close();
//	        // print result
//	        System.out.println("JSON String Result " + response.toString());
//	        //GetAndPost.POSTRequest(response.toString());
//	    } else {
//	        System.out.println("GET NOT WORKED");
//	    }
	 //   return null;
//	}
	

	
	
	
//	public List<Projet> getAllProjet(){
//		return em.createQuery("from Projet").getResultList();
//	}
	
//	
//	public static void main(String[] args) {
//	     try {
//	    	 ProjectConsum.call_me();
//	        } catch (Exception e) {
//	         e.printStackTrace();
//	       }
//		}
//	     public static void call_me() throws Exception {
//	         String url = "http://localhost:22033/Project/IndexAPI";
//	         URL obj = new URL(url);
//	         HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//	         // optional default is GET
//	         con.setRequestMethod("GET");
//	         //add request header
//	         con.setRequestProperty("User-Agent", "Mozilla/5.0");
//	         int responseCode = con.getResponseCode();
//	         System.out.println("\nSending 'GET' request to URL : " + url);
//	         System.out.println("Response Code : " + responseCode);
//	         BufferedReader in = new BufferedReader(
//	                 new InputStreamReader(con.getInputStream()));
//	         String inputLine;
//	         StringBuffer response = new StringBuffer();
//	         while ((inputLine = in.readLine()) != null) {
//	         	response.append(inputLine);
//	         }
//	         in.close();
//	         System.out.println(response.toString());
//	     }

}
