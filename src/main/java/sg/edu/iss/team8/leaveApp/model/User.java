package sg.edu.iss.team8.leaveApp.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

/*@Entity
@Data
@NoArgsConstructor
@Table(name="user")
public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	public Integer userId;
	private String name;
	private String username;
	private String password;
	private String role;
	private boolean enabled;
	

}*/

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role", discriminatorType = DiscriminatorType.STRING)
public class User{
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	public Integer userId;
	private String name;
	private String username;
	private String password;
	private boolean enabled;

	public User(String name) {
		this.name = name;
	}

	public User(String name, String username, String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
	}

	
	@Transient
	public String getDiscriminatorValue(){
	    DiscriminatorValue val = this.getClass().getAnnotation( DiscriminatorValue.class );

	    return val.value();
	}
	
	

	
}
