package com.booking.management.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    
    public Customers() {}
    
	public Customers( String email, String name) {
		super();
		this.email = email;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Customers [id=" + id + ", email=" + email + ", name=" + name + "]";
	}

	
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Customers customer;

        private Builder() {
            customer = new Customers();
        }

        public Builder name(String name) {
            customer.name = name;
            return this;
        }

        public Builder email(String email) {
            customer.email = email;
            return this;
        }

        public Builder id(Long id) {
            customer.id = id;
            return this;
        }

        public Customers build() {
            return customer;
        }
    }

}

