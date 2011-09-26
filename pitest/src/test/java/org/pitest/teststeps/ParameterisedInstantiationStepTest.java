/*
 * Copyright 2010 Henry Coles
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package org.pitest.teststeps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.pitest.internal.IsolationUtils;

public class ParameterisedInstantiationStepTest {

  public static class Parameterised {
    public int a;
    public int b;

    public Parameterised(final int a, final int b) {
      this.a = a;
      this.b = b;
    }
  }

  @Test
  public void shouldConstructObjectUsingSuppliedParameters() {
    final ParameterisedInstantiationStep testee = new ParameterisedInstantiationStep(
        Parameterised.class, new Object[] { 1, 2 });
    final Parameterised actual = (Parameterised) testee.execute(this.getClass()
        .getClassLoader(), null, null);
    assertEquals(1, actual.a);
    assertEquals(2, actual.b);
  }

  @Test
  public void shouldCloneByXStreamWithoutError() throws Exception {
    try {
      final ParameterisedInstantiationStep testee = new ParameterisedInstantiationStep(
          Parameterised.class, new Object[] { 1, 2 });
      IsolationUtils.clone(testee);
    } catch (final Throwable t) {
      fail();
    }
  }

}
