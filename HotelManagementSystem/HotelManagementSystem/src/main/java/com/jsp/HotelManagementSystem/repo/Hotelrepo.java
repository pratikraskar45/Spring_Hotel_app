package com.jsp.HotelManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.HotelManagementSystem.dto.Hotel;

public interface Hotelrepo extends JpaRepository<Hotel, Integer>{

}
