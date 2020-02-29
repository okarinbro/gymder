package com.white_wolf.threeeyedcrows.repository;

import com.white_wolf.threeeyedcrows.model.DailyReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyReportRepository extends JpaRepository<DailyReport, Long> {
}
