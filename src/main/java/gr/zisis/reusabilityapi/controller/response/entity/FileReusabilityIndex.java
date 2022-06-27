package gr.zisis.reusabilityapi.controller.response.entity;

import java.math.BigDecimal;
import java.util.Objects;

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

public class FileReusabilityIndex implements Comparable<FileReusabilityIndex>{
    private String sha;
    private Long revisionCount;
    private String filePath;
    private Double index;

    public FileReusabilityIndex() { }

    public FileReusabilityIndex(String sha, Long revisionCount, String filePath, Double index) {
        this.sha = sha;
        this.revisionCount = revisionCount;
        this.filePath = filePath;
        this.index = index;
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

    public Double getIndex() {
        return index;
    }

    public void setIndex(Double index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileReusabilityIndex that = (FileReusabilityIndex) o;
        return Objects.equals(sha, that.sha) && Objects.equals(revisionCount, that.revisionCount) && Objects.equals(filePath, that.filePath) && Objects.equals(index, that.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sha, revisionCount, filePath, index);
    }

    @Override
    public int compareTo(FileReusabilityIndex o) {
        if (this.index - o.index < 0)
            return -1;
        else if (this.index - o.index > 0)
            return 1;
        else
            return 0;
    }
}
