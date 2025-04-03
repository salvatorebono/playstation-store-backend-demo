package it.lipari.accademy.repository;

import it.lipari.accademy.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderRepository> findByUserId(Long userId);
}