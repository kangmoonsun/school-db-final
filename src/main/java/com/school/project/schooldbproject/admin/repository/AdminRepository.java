package com.school.project.schooldbproject.admin.repository;

import com.school.project.schooldbproject.admin.dto.SalesDto.BranchSalesDto;
import com.school.project.schooldbproject.admin.dto.SalesDto.CatalogueSalesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class AdminRepository {
    private final EntityManager em;

    @Autowired
    public AdminRepository(EntityManager em) {
        this.em = em;
    }


    public Optional<List<CatalogueSalesDto>> getCataloguesSales(Date begin, Date end) {
        String nativeQuery =
                "SELECT ca.name, SUM(od.total_price) as totalSales " +
                        "FROM payments as pa " +
                        "INNER JOIN order_details as od ON pa.payment_id = od.payment_id " +
                        "INNER JOIN catalogues as ca ON od.catalogue_id = ca.catalogue_id " +
                        "WHERE pa.created_at >= ? " +
                        "AND pa.created_at <= ? " +
                        "GROUP BY od.catalogue_id;";
        // Local H2
//                "WHERE pa.created_at >= PARSEDATETIME ( ? ,'yyyy-MM-dd hh:mm:ss') " +
//                "AND pa.created_at <= PARSEDATETIME ( ? ,'yyyy-MM-dd hh:mm:ss') " +

        List<CatalogueSalesDto> catalogueSalesDtos = em.createNativeQuery(nativeQuery, "CataloguesSalesMapping")
                .setParameter(1, begin)
                .setParameter(2, end)
                .getResultList();

        return Optional.ofNullable(catalogueSalesDtos);

        /**
         * Todo: 네이티브 쿼리 수정 예정
         * */
//        em.createQuery("select pa from Payment pa " +
//                        "inner join OrderDetail od on pa.id = od.payment.id " +
//                        "inner join Catalogue ca on od.catalogue.id = ca.id " +
//                        "where pa.createdAt between :begin and :end " +
//                        "group by od.catalogue.id"
//                )
//                .setParameter("begin", begin)
//                .setParameter("end", end)
//                .getResultList();

    }

    public Optional<List<BranchSalesDto>> getBranchesSales(Date begin, Date end) {
        String nativeQuery =
                "SELECT br.name, SUM(pa.total_price) as totalSales " +
                        "FROM payments as pa " +
                        "INNER JOIN branches br ON pa.branch_id = br.branch_id " +
                        "WHERE pa.created_at >= ? " +
                        "AND pa.created_at <= ? " +
                        "group by pa.branch_id;";
        // Local H2
//                "WHERE pa.created_at >= PARSEDATETIME ( ? ,'yyyy-MM-dd hh:mm:ss') " +
//                "AND pa.created_at <= PARSEDATETIME ( ? ,'yyyy-MM-dd hh:mm:ss') " +

        List<BranchSalesDto> branchSalesDtos = em.createNativeQuery(nativeQuery, "BranchesSalesMapping")
                .setParameter(1, begin)
                .setParameter(2, end)
                .getResultList();

        return Optional.ofNullable(branchSalesDtos);

        /**
         * Todo: 네이티브 쿼리 수정 예정
         * */
//        List resultList = em.createQuery("select br.name as name, sum(pa.totalPrice) as totalSales from Payment pa " +
//                        "inner join Branch br on pa.branch.id = br.id " +
//                        "where pa.createdAt between :begin AND :end " +
//                        "group by pa.branch.id")
//                .setParameter("begin", begin)
//                .setParameter("end", end)
//                .getResultList();

    }

}
