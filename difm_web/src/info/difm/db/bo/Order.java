package info.difm.db.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Order {
	private Long id;
	private Address from;
	private Address to;
	private Long fromNumber;
	private Long toNumber;
	private int weight; // in gram
	private int price;
	private int distance;
	private int deliveryUrgency;
	private int noItems;
	private String orderDescription;
	

	@Id
	@GeneratedValue
	@Column(name = "ORDER_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne (fetch = FetchType.EAGER)
	public Address getFrom() {
		return from;
	}

	public void setFrom(Address from) {
		this.from = from;
	}

	@OneToOne (fetch = FetchType.EAGER)	
	public Address getTo() {
		return to;
	}

	public void setTo(Address to) {
		this.to = to;
	}

	public Long getFromNumber() {
		return fromNumber;
	}

	public void setFromNumber(Long fromNumber) {
		this.fromNumber = fromNumber;
	}

	public Long getToNumber() {
		return toNumber;
	}

	public void setToNumber(Long toNumber) {
		this.toNumber = toNumber;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDeliveryUrgency() {
		return deliveryUrgency;
	}

	public void setDeliveryUrgency(int deliveryUrgency) {
		this.deliveryUrgency = deliveryUrgency;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getNoItems() {
		return noItems;
	}

	public void setNoItems(int noItems) {
		this.noItems = noItems;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

}
