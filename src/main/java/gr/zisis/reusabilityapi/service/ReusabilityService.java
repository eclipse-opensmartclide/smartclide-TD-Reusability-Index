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

import java.util.Collection;

import gr.zisis.reusabilityapi.controller.response.entity.*;


/**
 * @author Dimitrios Zisis <zisisndimitris@gmail.com>
 *
 */
public interface ReusabilityService {

	Collection<FileReusabilityIndex> findReusabilityIndexByCommit(String url, String sha, Integer limit);

	Collection<FileReusabilityIndex> findReusabilityIndexByCommitAndFile(String url, String sha, String filePath);

	Collection<ProjectReusabilityIndex> findProjectReusabilityIndexByCommit(String url, String sha);

	Collection<ProjectReusabilityIndex> findProjectReusabilityIndexPerCommit(String url, Integer limit);

}
