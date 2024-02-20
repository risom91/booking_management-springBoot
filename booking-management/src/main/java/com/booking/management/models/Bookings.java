package com.booking.management.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Customers_id", referencedColumnName = "id")
    private Customers Customers;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotels hotels;

    @Column(name = "check_in_date")
    private Long checkInDate;

    @Column(name = "check_out_date")
    private Long checkOutDate;

    public Bookings() {}


    public Bookings(Customers Customers, Hotels hotels, Long checkInDate, Long checkOutDate) {
        this.Customers = Customers;
        this.hotels = hotels;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customers getCustomers() {
        return Customers;
    }

    public void setCustomers(Customers Customers) {
        this.Customers = Customers;
    }

    public Hotels getHotel() {
        return hotels;
    }

    public void setHotel(Hotels hotels) {
        this.hotels = hotels;
    }

    public Long getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Long checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Long getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Long checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    
    public static BookingsBuilder builder() {
        return new BookingsBuilder();
    }

    public static class BookingsBuilder {
        private Bookings Bookings;

        private BookingsBuilder() {
            Bookings = new Bookings();
        }

        public BookingsBuilder Customers(Customers Customers) {
            Bookings.Customers = Customers;
            return this;
        }

        public BookingsBuilder hotel(Hotels hotels) {
            Bookings.hotels = hotels;
            return this;
        }

        public BookingsBuilder checkInDate(Long checkInDate) {
            Bookings.checkInDate = checkInDate;
            return this;
        }

        public BookingsBuilder checkOutDate(Long checkOutDate) {
            Bookings.checkOutDate = checkOutDate;
            return this;
        }

        public Bookings build() {
            return Bookings;
        }
    }


}
