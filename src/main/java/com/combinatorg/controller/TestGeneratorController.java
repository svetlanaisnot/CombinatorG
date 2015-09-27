package com.combinatorg.controller;

import com.combinatorg.model.old.social.DownloadRequest;
import com.combinatorg.model.old.social.DownloadResponse;
import com.combinatorg.model.test.TestQuestion;
import com.combinatorg.service.test.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by svetlana on 27/09/15.
 */
@Controller
public class TestGeneratorController {

    private static final Logger LOGGER =  LoggerFactory.getLogger(TestGeneratorController.class);

    @Autowired
    TestService testService;

    @RequestMapping(value = "/generatetest", method = RequestMethod.GET)
    public @ResponseBody
    List<TestQuestion> startDownload() {
        return testService.getTestContent();
    }
}
