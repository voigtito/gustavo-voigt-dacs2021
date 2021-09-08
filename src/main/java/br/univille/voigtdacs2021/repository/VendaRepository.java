package br.univille.voigtdacs2021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.voigtdacs2021.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda,Long>{
    
}
