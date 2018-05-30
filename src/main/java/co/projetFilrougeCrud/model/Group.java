package co.projetFilrougeCrud.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "GROUP")
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_generator")
	@SequenceGenerator(name = "group_generator", sequenceName = "group_sequence", allocationSize = 1)

	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="group_id")
	private Set<Foods> f;

	public Group() {
	}

	public Group(Long id) {
		this.id = id;
	}

	public Group(String name) {
		this.name = name;
	}

	public Group(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	

}
