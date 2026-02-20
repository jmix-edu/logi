package com.company.logi.app;

import io.jmix.core.security.SystemAuthenticator;
import io.jmix.reports.entity.ReportOutputType;
import io.jmix.reports.runner.ReportRunner;
import io.jmix.reports.yarg.reporting.ReportOutputDocument;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CompanyUnitReportGenerator implements Job {

    private static final Logger log = LoggerFactory.getLogger(CompanyUnitReportGenerator.class);
    private final ReportRunner reportRunner;
    private final SystemAuthenticator systemAuthenticator;

    public CompanyUnitReportGenerator(ReportRunner reportRunner, SystemAuthenticator systemAuthenticator) {
        this.reportRunner = reportRunner;
        this.systemAuthenticator = systemAuthenticator;
    }

    public void runReport() {

        final ReportOutputDocument document = reportRunner.byReportCode("cu-list")
                .withOutputType(ReportOutputType.XLSX)
                .withOutputNamePattern("cu-report.xlsx")
                .run();

        final byte[] reportContent = document.getContent();
        final String reportName = document.getDocumentName();

        log.info("File content length: " + reportContent.length);
    }

    @Override
    public void execute(JobExecutionContext context) {
        systemAuthenticator.runWithSystem(this::runReport);
    }
}