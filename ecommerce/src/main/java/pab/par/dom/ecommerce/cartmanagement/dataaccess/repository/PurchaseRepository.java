package pab.par.dom.ecommerce.cartmanagement.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pab.par.dom.ecommerce.cartmanagement.dataaccess.entity.Purchase;

/**
 * Spring Data repository for Purchases
 *
 */
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
