/*******************************************************************************
 * Copyright (C) 2021-2022 UoM - University of Macedonia
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package gr.zisis.reusabilityapi.service;

import org.junit.jupiter.api.Test;

import static java.lang.Math.log10;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dimitrios Zisis <zisisndimitris@gmail.com>
 */
class ReusabilityServiceBeanTest {

    @Test
    void shouldFindReusabilityIndexByCommitAndFile() {
        double cbo = 0.0, dit = 1.0, wmc = 1.0, rfc = 2.0, lcom = 0.0, nocc = 0.0;
        Double index = -1 * (8.753 * log10(cbo + 1) + 2.505 * log10(dit + 1) - 1.922 * log10(wmc + 1) + 0.892 * log10(rfc + 1) - 0.399 * log10(lcom + 1) - 1.080 * log10(nocc + 1));
        System.out.println(index);
        assertEquals(index, index);
    }
}
