package gr.zisis.reusabilityapi.service;

import java.util.Collection;

import gr.zisis.reusabilityapi.controller.response.entity.*;

/**
 * @author George Digkas <digasgeo@gmail.com>
 *
 */
public interface ReusabilityService {

	Collection<FileReusabilityIndex> findReusabilityIndexByCommit(String url, String sha, Integer limit);

	Collection<FileReusabilityIndex> findReusabilityIndexByCommitAndFile(String url, String sha, String filePath);

}
