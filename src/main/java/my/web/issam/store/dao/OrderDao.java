package my.web.issam.store.dao;

import java.util.List;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import my.web.issam.store.model.Order;

import org.springframework.data.jpa.repository.Query;

public interface OrderDao extends JpaRepository<Order, Integer>{

	@Query("select o from Order o where o.orderDate like :orderDate")
	List<Order> findByOrderDate(@Param("orderDate")Date orderDate);
}
