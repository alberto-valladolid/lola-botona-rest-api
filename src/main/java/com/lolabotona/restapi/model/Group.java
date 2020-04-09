package com.lolabotona.restapi.model;


import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
//import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lolabotona.restapi.repository.UserRepository;
import com.lolabotona.restapi.service.UserDetailsImpl;


//import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(	name = "groups", 
uniqueConstraints = { 
	@UniqueConstraint(columnNames = {"dayofweek","timeofday"})
})

public class Group {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
    
	@JsonManagedReference(value="group")
    @OneToMany(mappedBy = "group")
    private Set<UserGroup> userSet;
	

    private int capacity;
	
    @NotBlank    
    private String description; 
    
//    @NotBlank 
//    private int orderShown;
	
    @NotBlank    
    private String timeofday; //morning or afternoon. Es posible que no sea necesario 

    private int dayofweek;

    @Column(nullable = false)
    private boolean active;
    
    
	public Group() {
	}

	public Group(int capacity, String description,/* int orderShown,*/ String timeofday, int dayofweek,boolean active) {
		this.capacity = capacity;
		this.description = description;
		//this.orderShown = orderShown;
		this.timeofday = timeofday;
		this.dayofweek = dayofweek;
		this.active = active; 	

	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public Set<UserGroup> getUserSet() {
        return userSet;
    }
	
	public void setUserSet(Set<UserGroup> userSet) {
        this.userSet = userSet;
    } 	
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
		
//	public int getOrderShown() {
//		return orderShown;
//	}
//
//	public void setOrderShown(int orderShown) {
//		this.orderShown = orderShown;
//	}
	
	public String gettimeofday() {
		return timeofday;
	}
	
	public void settimeofday(String timeofday) {
		this.timeofday = timeofday;
	}
	
	public int getdayofweek() {
		return dayofweek;
	}

	public void setdayofweek(int dayofweek) {
		this.dayofweek = dayofweek;
	}
	
	
	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}	
	
	@Override
	public String toString() {
		return "Group [id=" + id + ", capacity=" + capacity + ", description=" + description + /*", orderShown=" + orderShown +*/ " , timeofday=" + timeofday +" , dayofweek=" + dayofweek +" , active=" + active + "]";
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserGroup)) return false;
        Group that = (Group) o;
        return Objects.equals(id, that.id)  ;
    }
}
