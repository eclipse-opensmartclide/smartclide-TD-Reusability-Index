package gr.zisis.reusabilityapi.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

/*
 *
 *  * Copyright (C) 2021 UoM - University of Macedonia
 *  *
 *  * This program and the accompanying materials are made available under the
 *  * terms of the Eclipse Public License 2.0 which is available at
 *  * https://www.eclipse.org/legal/epl-2.0/
 *  *
 *  * SPDX-License-Identifier: EPL-2.0
 *
 */

public class ReusabilityMetrics {
    private String sha;
    private Long revisionCount;
    private String filePath;
    private BigDecimal cbo;
    private Integer dit;
    private BigDecimal wmc;
    private BigDecimal rfc;
    private BigInteger lcom;
    private Integer nocc;

    public ReusabilityMetrics() { }

    public ReusabilityMetrics(String sha, Long revisionCount, String filePath, BigDecimal cbo, Integer dit, BigDecimal wmc, BigDecimal rfc, BigInteger lcom, Integer nocc) {
        this.sha = sha;
        this.revisionCount = revisionCount;
        this.filePath = filePath;
        this.cbo = cbo;
        this.dit = dit;
        this.wmc = wmc;
        this.rfc = rfc;
        this.lcom = lcom;
        this.nocc = nocc;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public Long getRevisionCount() {
        return revisionCount;
    }

    public void setRevisionCount(Long revisionCount) {
        this.revisionCount = revisionCount;
    }

    public BigDecimal getCbo() {
        return cbo;
    }

    public void setCbo(BigDecimal cbo) {
        this.cbo = cbo;
    }

    public Integer getDit() {
        return dit;
    }

    public void setDit(Integer dit) {
        this.dit = dit;
    }

    public BigDecimal getWmc() {
        return wmc;
    }

    public void setWmc(BigDecimal wmc) {
        this.wmc = wmc;
    }

    public BigDecimal getRfc() {
        return rfc;
    }

    public void setRfc(BigDecimal rfc) {
        this.rfc = rfc;
    }

    public BigInteger getLcom() {
        return lcom;
    }

    public void setLcom(BigInteger lcom) {
        this.lcom = lcom;
    }

    public Integer getNocc() {
        return nocc;
    }

    public void setNocc(Integer nocc) {
        this.nocc = nocc;
    }
}
