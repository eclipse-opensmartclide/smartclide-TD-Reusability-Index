/*******************************************************************************
 * Copyright (C) 2021-2022 UoM - University of Macedonia
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package gr.zisis.reusabilityapi.controller;

import java.util.Collection;
import java.util.Objects;

import gr.zisis.reusabilityapi.controller.response.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import gr.zisis.reusabilityapi.service.ReusabilityService;

@RestController
@RequestMapping(value = "/api")
public class ReusabilityController {

    @Autowired
    private ReusabilityService reusabilityService;

    @GetMapping(value = "/reusabilityIndexByCommit")
    Collection<FileReusabilityIndex> getReusabilityIndexByCommit(@RequestParam(required = true) String url, @RequestParam(required = true) String sha, @RequestParam(required = false) Integer limit) {
        return Objects.nonNull(limit) ? reusabilityService.findReusabilityIndexByCommit(url, sha, limit) : reusabilityService.findReusabilityIndexByCommit(url, sha, null);
    }

    @GetMapping(value = "/reusabilityIndexByCommitAndFile")
    Collection<FileReusabilityIndex> getReusabilityIndexByCommitAndFile(@RequestParam(required = true) String url, @RequestParam(required = true) String sha, @RequestParam(required = true) String filePath) {
        return reusabilityService.findReusabilityIndexByCommitAndFile(url, sha, filePath);
    }

    @GetMapping(value = "/projectReusabilityIndexByCommit")
    Collection<ProjectReusabilityIndex> getProjectReusabilityIndexByCommit(@RequestParam(required = true) String url, @RequestParam(required = true) String sha) {
        return reusabilityService.findProjectReusabilityIndexByCommit(url, sha);
    }

    @GetMapping(value = "/projectReusabilityIndexPerCommit")
    Collection<ProjectReusabilityIndex> getProjectReusabilityIndexPerCommit(@RequestParam(required = true) String url, @RequestParam(required = false) Integer limit) {
        return reusabilityService.findProjectReusabilityIndexPerCommit(url, limit);
    }

}
