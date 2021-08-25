package gr.zisis.reusabilityapi.service;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import gr.zisis.reusabilityapi.controller.response.entity.*;
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
            List<FileReusabilityIndex> fileReusabilityIndexList = new ArrayList<>();
            for (ReusabilityMetrics m : metrics) {
                Double index = -1 * (8.753 * log10(m.getCbo().doubleValue() + 1) + 2.505 * log10(m.getDit() + 1) - 1.922 * log10(m.getWmc().doubleValue() + 1) + 0.892 * log10(m.getRfc().doubleValue() + 1) - 0.399 * log10(m.getLcom().doubleValue() == -1 ? 0 : m.getLcom().doubleValue() + 1) - 1.080 * log10(m.getNocc() + 1));
                fileReusabilityIndexList.add(new FileReusabilityIndex(m.getSha(), m.getRevisionCount(), m.getFilePath(), index));
            }
            Collections.sort(fileReusabilityIndexList);
            return fileReusabilityIndexList;
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<FileReusabilityIndex> findReusabilityIndexByCommitAndFile(String url, String sha, String filePath) {
        HttpResponse<JsonNode> httpResponse;
        Unirest.setTimeouts(0, 0);
        try {
            httpResponse = Unirest.get("http://195.251.210.147:3990/api/reusabilityMetricsByCommitAndFile?url=" + url + "&sha=" + sha + "&filePath=" + filePath).asJson();
            List<ReusabilityMetrics> metrics = Arrays.asList(new Gson().fromJson(httpResponse.getBody().toString(), ReusabilityMetrics[].class));
            List<FileReusabilityIndex> fileReusabilityIndexList = new ArrayList<>();
            for (ReusabilityMetrics m : metrics) {
                Double index = -1 * (8.753 * log10(m.getCbo().doubleValue() + 1) + 2.505 * log10(m.getDit() + 1) - 1.922 * log10(m.getWmc().doubleValue() + 1) + 0.892 * log10(m.getRfc().doubleValue() + 1) - 0.399 * log10(m.getLcom().doubleValue() == -1 ? 0 : m.getLcom().doubleValue() + 1) - 1.080 * log10(m.getNocc() + 1));
                fileReusabilityIndexList.add(new FileReusabilityIndex(m.getSha(), m.getRevisionCount(), filePath, index));
            }
            return fileReusabilityIndexList;
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

}
