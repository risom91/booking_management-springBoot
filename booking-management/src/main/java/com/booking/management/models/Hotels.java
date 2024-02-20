package com.booking.management.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Hotels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int roomCount;

    public Hotels() {}

    public Hotels(String name, int roomCount) {
        this.name = name;
        this.roomCount = roomCount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public int getRoomCount() {
        return roomCount;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setroomCount(int roomCount) {
        this.roomCount = roomCount;
    }
    
    public static HotelsBuilder builder() {
        return new HotelsBuilder();
    }
    
    public static class HotelsBuilder {
        private Hotels Hotels;

        private HotelsBuilder() {
            Hotels = new Hotels();
        }

        public HotelsBuilder id(Long id) {
            Hotels.id = id;
            return this;
        }

        public HotelsBuilder name(String name) {
            Hotels.name = name;
            return this;
        }

        public HotelsBuilder roomCount(int roomCount) {
            Hotels.roomCount = roomCount;
            return this;
        }

        public Hotels build() {
            return Hotels;
        }
    }
}

