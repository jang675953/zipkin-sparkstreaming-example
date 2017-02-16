/**
 * Copyright 2017 The OpenZipkin Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package zipkin.sparkstreaming.adjuster.zipkin;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zipkin.sparkstreaming.Adjuster;
import zipkin.sparkstreaming.adjuster.BinaryAnnotationTrimAdjuster;
import zipkin.sparkstreaming.adjuster.BinaryAnnotationTrimAdjusterConfiguration;
import zipkin.sparkstreaming.autoconfigure.adjuster.finagle.ZipkinFinagleAdjusterAutoConfiguration;

public class BinaryAnnotationTrimAdjusterPropertiesTest {

  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

  @Test
  public void providesAdjuster() {
    context.register(BinaryAnnotationTrimAdjusterConfiguration.class,
        ZipkinFinagleAdjusterAutoConfiguration.class);
    context.refresh();

    Adjuster adjuster = context.getBean(Adjuster.class);
    assertThat(adjuster).isInstanceOf(BinaryAnnotationTrimAdjuster.class);
  }
}
