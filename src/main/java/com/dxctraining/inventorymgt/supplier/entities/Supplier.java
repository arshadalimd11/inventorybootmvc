package com.dxctraining.inventorymgt.supplier.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dxctraining.inventorymgt.item.entities.Computer;
import com.dxctraining.inventorymgt.item.entities.Phone;

@Entity
@Table(name = "suppliers_information")
public class Supplier {
	@Id
	@GeneratedValue
	private int id;
	private String sname;
	private String password;

	@OneToMany(mappedBy = "supplier")
	private Set<Computer> computer;

	@OneToMany(mappedBy = "supplier")
	private Set<Phone> phone;

	public Set<Computer> getComputer() {
		return computer;
	}

	public Supplier() {

	}

	public void setItems(Set<Computer> computer) {
		this.computer = computer;
	}

	public Supplier(String sname, String password) {
		this.sname = sname;
		this.password = password;
	}

	public Set<Phone> getPhone() {
		return phone;
	}

	public void setPhone(Set<Phone> phone) {
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return sname;
	}
	public void setName(String sname) {
		this.sname = sname;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		
		Supplier that = (Supplier) o;
		return id == that.id;

	}
}
