package gr.zisis.reusabilityapi.domain;

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

public class AnalyzedCommits implements Comparable<AnalyzedCommits> {
    private String sha;
    private Long revisionCount;

    public AnalyzedCommits() { }

    public AnalyzedCommits(String sha, Long revisionCount) {
        this.sha = sha;
        this.revisionCount = revisionCount;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnalyzedCommits that = (AnalyzedCommits) o;
        return Objects.equals(sha, that.sha) && Objects.equals(revisionCount, that.revisionCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sha, revisionCount);
    }

    @Override
    public int compareTo(AnalyzedCommits o) {
        if (this.revisionCount - o.revisionCount < 0)
            return -1;
        else if (this.revisionCount - o.revisionCount > 0)
            return 1;
        else
            return 0;
    }
}
