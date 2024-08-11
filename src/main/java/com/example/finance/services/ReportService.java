package com.example.finance.services;

import com.example.finance.models.Report;
import com.example.finance.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Report getReportById(Long id) {
        return reportRepository.findById(id).orElseThrow(() -> new RuntimeException("Report not found"));
    }

    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    public Report updateReport(Long id, Report report) {
        Report existingReport = reportRepository.findById(id).orElseThrow(() -> new RuntimeException("Report not found"));
        existingReport.setDate(report.getDate());
        existingReport.setDetails(report.getDetails());
        return reportRepository.save(existingReport);
    }

    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}

