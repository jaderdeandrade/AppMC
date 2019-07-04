package com.jda.appmc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jda.appmc.domain.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
