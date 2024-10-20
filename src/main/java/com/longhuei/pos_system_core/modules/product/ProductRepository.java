package com.longhuei.pos_system_core.modules.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.longhuei.pos_system_core.modules.product.dto.ProductResponse;

public interface ProductRepository extends JpaRepository<Product, String> {
   @Query(
    " SELECT new com.longhuei.pos_system_core.modules.product.dto.ProductResponse( " + 
    "  p.productId, p.productName, p.modelType, p.colorType, p.packageQuantity, p.barCode, p.status, p.stopDate, p.specialCode, " + 
    "  l.code, l.nameEN, l.nameCHT, " +
    "  m.code, m.nameEN, m.nameCHT, " +
    "  ct.code, ct.nameEN, ct.nameCHT, " +
    "  cl.code, cl.nameEN, cl.nameCHT, " +
    "  s.code, s.nameEN, s.nameCHT, " +
    "  g.code, g.nameEN, g.nameCHT, " +
    "  p.remark " + 
    " ) " +
    " FROM Product p " +
    " LEFT JOIN p.labelCode l " +
    " LEFT JOIN p.modelCode m " +
    " LEFT JOIN p.coatingCode ct " +
    " LEFT JOIN p.colorCode cl " +
    " LEFT JOIN p.sizeCode s " +
    " LEFT JOIN p.graphicCode g " +
    " WHERE p.isDeleted = false " +
    " AND ( :keyword IS NULL OR " +
    "  LOWER(p.productId) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
    "  OR LOWER(p.productName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
    "  OR LOWER(p.modelType) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
    "  OR LOWER(p.colorType) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
    " ) "
   )
    Page<ProductResponse> search(@Param("keyword") String keyword, Pageable pageable);
}
