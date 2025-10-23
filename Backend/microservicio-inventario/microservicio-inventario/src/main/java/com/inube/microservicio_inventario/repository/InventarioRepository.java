package com.inube.microservicio_inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inube.microservicio_inventario.model.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
}


