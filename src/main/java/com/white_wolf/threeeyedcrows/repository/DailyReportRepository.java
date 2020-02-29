package com.white_wolf.threeeyedcrows.repository;

import com.white_wolf.threeeyedcrows.model.DailyReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyReportRepository extends JpaRepository<DailyReport, Long> {
}
