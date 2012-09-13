package org.pitest.mutationtest;

import org.pitest.coverage.export.CoverageExporter;
import org.pitest.coverage.export.DefaultCoverageExporter;
import org.pitest.coverage.export.NullCoverageExporter;
import org.pitest.mutationtest.report.ResultOutputStrategy;

public class SettingsFactory {
  
  private final ReportOptions options;
  
  public SettingsFactory(ReportOptions options) {
    this.options = options;
  }
  
  public ResultOutputStrategy getOutputStrategy() {
    return options.getReportDirectoryStrategy();
  }
  
  public CoverageExporter createCoverageExporter() {
    if ( options.shouldExportLineCoverage() ) {
      return new DefaultCoverageExporter(getOutputStrategy());
    } else {
      return new NullCoverageExporter();
    }
  }
  
  
  

}
