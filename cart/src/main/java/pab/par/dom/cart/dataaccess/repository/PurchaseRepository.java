package pab.par.dom.cart.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pab.par.dom.cart.dataaccess.entity.Purchase;

/**
 * Spring Data repository for Purchases
 *
 */
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
