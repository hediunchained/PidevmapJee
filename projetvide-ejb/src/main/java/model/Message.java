package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;


/**
 * The persistent class for the Messages database table.
 * 
 */
@Entity
@Table(name="Messages")
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MessageID")
	private int messageID;

	@Column(name="Content")
	private String content;
	
	@Column(name="Date")
	@JsonProperty("Date")
	@JsonDeserialize(using=CustomerDateAndTimeDeserialize.class)
	private Date date;

	@Column(name="MessageType")
	private String messageType;

	@Column(name="Object")
	private String Object;
	
	@Column(name="Sendername")
	private String sendername;

	@Column(name="Read")
	private boolean read;

	@Column(name="ReceiverId")
	private int receiverId;

	@Column(name="SenderId")
	private int senderId;

	@Column(name="Target")
	private String target;

	public Message() {
	}

	public int getMessageID() {
		return this.messageID;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessageType() {
		return this.messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getObject() {
		return this.Object;
	}

	public void setObject(String Object) {
		this.Object = Object;
	}

	public boolean getRead() {
		return this.read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public int getReceiverId() {
		return this.receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public int getSenderId() {
		return this.senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getSendername() {
		return sendername;
	}

	public void setSendername(String sendername) {
		this.sendername = sendername;
	}
	

}