package pab.par.dom.cart.logic.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import pab.par.dom.cart.dataaccess.entity.Purchase;
import pab.par.dom.cart.logic.dto.PurchaseDto;

/**
 * Mapper for Purchase - PurchaseDto
 *
 */
@Mapper(componentModel = "spring")
public interface PurchaseMapper {

  PurchaseDto toDto(Purchase purchase);

  List<PurchaseDto> toDtos(List<Purchase> purchaseList);

  List<Purchase> toEntities(List<PurchaseDto> dtoList);
}
