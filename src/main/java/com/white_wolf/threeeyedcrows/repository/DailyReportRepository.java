package com.white_wolf.threeeyedcrows.repository;

import com.white_wolf.threeeyedcrows.model.DailyReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyReportRepository extends JpaRepository<DailyReport, Long> {

    @Query("From DailyReport as dailyReport where dailyReport.user.id = :id")
    List<DailyReport> findAllById(@Param("id") long id);
}
