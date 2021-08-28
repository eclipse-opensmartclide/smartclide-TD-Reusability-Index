package gr.zisis.reusabilityapi.service;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import gr.zisis.reusabilityapi.controller.response.entity.*;
import gr.zisis.reusabilityapi.domain.AnalyzedCommits;
import gr.zisis.reusabilityapi.domain.ReusabilityMetrics;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.lang.Math.log10;

/**
 * @author George Digkas <digasgeo@gmail.com>
 */
@Service
public class ReusabilityServiceBean implements ReusabilityService {

    @Override
    public Collection<FileReusabilityIndex> findReusabilityIndexByCommit(String url, String sha, Integer limit) {
        HttpResponse<JsonNode> httpResponse;
        Unirest.setTimeouts(0, 0);
        try {
            if (Objects.nonNull(limit))
                httpResponse = Unirest.get("http://195.251.210.147:3990/api/reusabilityMetricsByCommit?url=" + url + "&sha=" + sha + "&limit=" + limit).asJson();
            else
                httpResponse = Unirest.get("http://195.251.210.147:3990/api/reusabilityMetricsByCommit?url=" + url + "&sha=" + sha).asJson();
            List<ReusabilityMetrics> metrics = Arrays.asList(new Gson().fromJson(httpResponse.getBody().toString(), ReusabilityMetrics[].class));
            if (metrics.isEmpty())
                return new ArrayList<>();
            List<FileReusabilityIndex> fileReusabilityIndexList = new ArrayList<>();
            for (ReusabilityMetrics m : metrics) {
                Double index = -1 * (8.753 * log10(m.getCbo().doubleValue() + 1) >= 0 ? log10(m.getCbo().doubleValue() + 1) : 0 + 2.505 * log10(m.getDit() + 1) >= 0 ? log10(m.getDit() + 1) : 0 - 1.922 * log10(m.getWmc().doubleValue() + 1) >= 0 ? log10(m.getWmc().doubleValue() + 1) : 0 + 0.892 * log10(m.getRfc().doubleValue() + 1) >= 0 ? log10(m.getRfc().doubleValue() + 1) : 0 - 0.399 * log10(m.getLcom().doubleValue() < 0 ? 0 : m.getLcom().doubleValue() + 1) >= 0 ? log10(m.getLcom().doubleValue() < 0 ? 0 : m.getLcom().doubleValue() + 1) : 0 - 1.080 * log10(m.getNocc() + 1) >= 0 ? log10(m.getNocc() + 1) : 0);
                fileReusabilityIndexList.add(new FileReusabilityIndex(m.getSha(), m.getRevisionCount(), m.getFilePath(), index));
            }
            Collections.sort(fileReusabilityIndexList);
            return fileReusabilityIndexList;
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public Collection<FileReusabilityIndex> findReusabilityIndexByCommitAndFile(String url, String sha, String filePath) {
        HttpResponse<JsonNode> httpResponse;
        Unirest.setTimeouts(0, 0);
        try {
            httpResponse = Unirest.get("http://195.251.210.147:3990/api/reusabilityMetricsByCommitAndFile?url=" + url + "&sha=" + sha + "&filePath=" + filePath).asJson();
            List<ReusabilityMetrics> metrics = Arrays.asList(new Gson().fromJson(httpResponse.getBody().toString(), ReusabilityMetrics[].class));
            if (metrics.isEmpty())
                return new ArrayList<>();
            List<FileReusabilityIndex> fileReusabilityIndexList = new ArrayList<>();
            for (ReusabilityMetrics m : metrics) {
                Double index = -1 * (8.753 * log10(m.getCbo().doubleValue() + 1) >= 0 ? log10(m.getCbo().doubleValue() + 1) : 0 + 2.505 * log10(m.getDit() + 1) >= 0 ? log10(m.getDit() + 1) : 0 - 1.922 * log10(m.getWmc().doubleValue() + 1) >= 0 ? log10(m.getWmc().doubleValue() + 1) : 0 + 0.892 * log10(m.getRfc().doubleValue() + 1) >= 0 ? log10(m.getRfc().doubleValue() + 1) : 0 - 0.399 * log10(m.getLcom().doubleValue() < 0 ? 0 : m.getLcom().doubleValue() + 1) >= 0 ? log10(m.getLcom().doubleValue() < 0 ? 0 : m.getLcom().doubleValue() + 1) : 0 - 1.080 * log10(m.getNocc() + 1) >= 0 ? log10(m.getNocc() + 1) : 0);
                fileReusabilityIndexList.add(new FileReusabilityIndex(m.getSha(), m.getRevisionCount(), filePath, index));
            }
            return fileReusabilityIndexList;
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public Collection<ProjectReusabilityIndex> findProjectReusabilityIndexByCommit(String url, String sha) {
        HttpResponse<JsonNode> httpResponse;
        Unirest.setTimeouts(0, 0);
        try {
            httpResponse = Unirest.get("http://195.251.210.147:3990/api/reusabilityMetricsByCommit?url=" + url + "&sha=" + sha).asJson();
            List<ReusabilityMetrics> metrics = Arrays.asList(new Gson().fromJson(httpResponse.getBody().toString(), ReusabilityMetrics[].class));
            if (metrics.isEmpty())
                return new ArrayList<>();
            double avgIndex = 0.0;
            for (ReusabilityMetrics m : metrics) {
                double index = -1 * (8.753 * log10(m.getCbo().doubleValue() + 1) >= 0 ? log10(m.getCbo().doubleValue() + 1) : 0 + 2.505 * log10(m.getDit() + 1) >= 0 ? log10(m.getDit() + 1) : 0 - 1.922 * log10(m.getWmc().doubleValue() + 1) >= 0 ? log10(m.getWmc().doubleValue() + 1) : 0 + 0.892 * log10(m.getRfc().doubleValue() + 1) >= 0 ? log10(m.getRfc().doubleValue() + 1) : 0 - 0.399 * log10(m.getLcom().doubleValue() < 0 ? 0 : m.getLcom().doubleValue() + 1) >= 0 ? log10(m.getLcom().doubleValue() < 0 ? 0 : m.getLcom().doubleValue() + 1) : 0 - 1.080 * log10(m.getNocc() + 1) >= 0 ? log10(m.getNocc() + 1) : 0);
                avgIndex += index;
            }
            avgIndex /= metrics.size();
            return Collections.singletonList(new ProjectReusabilityIndex(sha, metrics.get(0).getRevisionCount(), avgIndex));
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public Collection<ProjectReusabilityIndex> findProjectReusabilityIndexPerCommit(String url, Integer limit) {
        List<AnalyzedCommits> commits = getCommitIds(url, limit);
        if (Objects.isNull(commits) || commits.isEmpty())
            return new ArrayList<>();
        if (Objects.nonNull(limit))
            commits = commits.subList(0, limit);
        Collections.reverse(commits);
        List<ProjectReusabilityIndex> projectReusabilityIndexList = new ArrayList<>();
        for (AnalyzedCommits commit : commits) {
            HttpResponse<JsonNode> httpResponse;
            Unirest.setTimeouts(0, 0);
            try {
                httpResponse = Unirest.get("http://195.251.210.147:3990/api/reusabilityMetricsByCommit?url=" + url + "&sha=" + commit.getSha()).asJson();
                List<ReusabilityMetrics> metrics = Arrays.asList(new Gson().fromJson(httpResponse.getBody().toString(), ReusabilityMetrics[].class));
                if (metrics.isEmpty())
                    continue;
                double avgIndex = 0.0;
                for (ReusabilityMetrics m : metrics) {
                    double index = -1 * (8.753 * log10(m.getCbo().doubleValue() + 1) >= 0 ? log10(m.getCbo().doubleValue() + 1) : 0 + 2.505 * log10(m.getDit() + 1) >= 0 ? log10(m.getDit() + 1) : 0 - 1.922 * log10(m.getWmc().doubleValue() + 1) >= 0 ? log10(m.getWmc().doubleValue() + 1) : 0 + 0.892 * log10(m.getRfc().doubleValue() + 1) >= 0 ? log10(m.getRfc().doubleValue() + 1) : 0 - 0.399 * log10(m.getLcom().doubleValue() < 0 ? 0 : m.getLcom().doubleValue() + 1) >= 0 ? log10(m.getLcom().doubleValue() < 0 ? 0 : m.getLcom().doubleValue() + 1) : 0 - 1.080 * log10(m.getNocc() + 1) >= 0 ? log10(m.getNocc() + 1) : 0);
                    avgIndex += index;
                }
                avgIndex /= metrics.size();
                projectReusabilityIndexList.add(new ProjectReusabilityIndex(commit.getSha(), metrics.get(0).getRevisionCount(), avgIndex));
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }
        Collections.sort(projectReusabilityIndexList);
        return projectReusabilityIndexList;
    }

    /**
     * Gets all commit ids for a specific git repo.
     *
     * @param gitURL the url of git repository
     */
    private List<AnalyzedCommits> getCommitIds(String gitURL, Integer limit) {
        HttpResponse<JsonNode> httpResponse = null;
        Unirest.setTimeouts(0, 0);
        try {
            httpResponse = Unirest.get("http://195.251.210.147:3990/api/analyzedCommitIds?url=" + gitURL + "&limit=" + limit).asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return Objects.nonNull(httpResponse) ? Arrays.asList(new Gson().fromJson(httpResponse.getBody().toString(), AnalyzedCommits[].class)) : null;
    }

}
