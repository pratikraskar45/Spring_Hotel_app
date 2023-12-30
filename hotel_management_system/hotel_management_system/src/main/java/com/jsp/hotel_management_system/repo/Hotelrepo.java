package com.jsp.hotel_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hotel_management_system.dto.Hotel;

public interface Hotelrepo extends JpaRepository<Hotel, Integer> {

}
