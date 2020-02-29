package com.white_wolf.threeeyedcrows.repository;

import com.white_wolf.threeeyedcrows.model.DailyReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface DailyReportRepository extends JpaRepository<DailyReport, Long> {
    @Query("FROM DailyReport as d where d.user.id = :userId")
    public List<DailyReport> getUsersDayReport(@Param("userId") Long userId);
}
