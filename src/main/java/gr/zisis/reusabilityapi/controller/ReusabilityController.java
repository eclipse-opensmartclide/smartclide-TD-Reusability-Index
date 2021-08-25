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

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/reusabilityIndexByCommit")
    Collection<FileReusabilityIndex> getReusabilityIndexByCommit(@RequestParam(required = true) String url, @RequestParam(required = true) String sha, @RequestParam(required = false) Integer limit) {
        return Objects.nonNull(limit) ? reusabilityService.findReusabilityIndexByCommit(url, sha, limit) : reusabilityService.findReusabilityIndexByCommit(url, sha, null);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/reusabilityIndexByCommitAndFile")
    Collection<FileReusabilityIndex> getReusabilityIndexByCommitAndFile(@RequestParam(required = true) String url, @RequestParam(required = true) String sha, @RequestParam(required = true) String filePath) {
        return reusabilityService.findReusabilityIndexByCommitAndFile(url, sha, filePath);
    }

}
