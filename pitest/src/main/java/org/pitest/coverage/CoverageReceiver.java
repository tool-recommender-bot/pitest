package org.pitest.coverage;

import org.pitest.boot.InvokeReceiver;

public interface CoverageReceiver extends InvokeReceiver {

  public abstract void recordTest(int testIndex);

  public abstract void recordTestOutcome(boolean wasGreen, long executionTime);

}