package net.javaguides.springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springbootbackend.model.Center;


@Repository
public interface CenterRepository extends JpaRepository<Center, Long>  {

    


    
}
