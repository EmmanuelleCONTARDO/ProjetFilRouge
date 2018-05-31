package co.projetFilrougeCrud.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "FOODSGROUP")
public class FoodsGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_generator")
	@SequenceGenerator(name = "group_generator", sequenceName = "group_sequence", allocationSize = 1)

	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	public FoodsGroup() {
	}

	public FoodsGroup(Long id) {
		this.id = id;
	}

	public FoodsGroup(String name) {
		this.name = name;
	}

	public FoodsGroup(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	@OneToMany//(mappedBy = "foodsgroup", cascade = CascadeType.ALL)
	@JoinTable(name = "FOODS_FOODSGROUP", joinColumns = {
	@JoinColumn(name = "ID", referencedColumnName = "ID") }, inverseJoinColumns = {
	@JoinColumn(name = "GROUP_ID", referencedColumnName = "ID") })
	private Set<Foods> f = new HashSet<Foods>();	


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

	@Override
	public String toString() {
		return "FoodsGroup [id=" + id + ", name=" + name + ", lg=" + f.size() + "]";
	}

	
	
}
