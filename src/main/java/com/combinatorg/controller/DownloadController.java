package com.combinatorg.controller;

import com.combinatorg.model.old.social.DownloadRequest;
import com.combinatorg.model.old.social.DownloadResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by svetlana on 08/01/15.
 */
@Controller
public class DownloadController {

    private static final Logger LOGGER =  LoggerFactory.getLogger(DownloadController.class);

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public @ResponseBody
    DownloadResponse startDownload(
            @RequestBody DownloadRequest request) {
        LOGGER.info("Request is {}", request);

        DownloadResponse response = new DownloadResponse();
        response.setMessage("Download for path " + request.getPath() + "/" + request.getTypeValue() + " started");
        return response;
    }

}
