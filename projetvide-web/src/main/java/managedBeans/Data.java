package managedBeans ;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import model.TypeCategory;
import model.TypeClient;
import model.MessageType;


@ManagedBean
@ApplicationScoped
public class Data {

	
	
	public TypeCategory[] getTypeCategory() {
        return TypeCategory.values();
    }
	public MessageType[] getMessageType() {
        return MessageType.values();
    }
	
	public TypeClient[] getTypeClient() {
        return TypeClient.values();
    }
	

	@PostConstruct
	public void init()
	{
		category = TypeCategory.Private;
		category = TypeCategory.Public;
		clientType = TypeClient.Current_type;
		clientType = TypeClient.New_Client;
		clientType = TypeClient.Finished_Contract;
		messageType= MessageType.Complaint;
		messageType=MessageType.Satisfaction;
		messageType=MessageType.Technical_Problem;
	}
	
	private TypeCategory category;
	private TypeClient clientType;
	private MessageType messageType;
	public TypeClient getClientType() {
		return clientType;
	}


	public void setClientType(TypeClient clientType) {
		this.clientType = clientType;
	}


	public TypeCategory getCategory() {
		return category;
	}


	public void setCategory(TypeCategory category) {
		this.category = category;
	}
	
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
	public MessageType getMessageT() {
		return messageType;
	}
	
	


	 
	 
	 
	
}
