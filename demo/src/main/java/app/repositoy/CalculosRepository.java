package app.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Resultado;

public interface CalculosRepository extends JpaRepository<Resultado, Long>  {

}