package com.formation.apptracking.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import static com.formation.apptracking.controller.ApptrackingBaseController.BASE_PATH_STRING;

@RequestMapping(BASE_PATH_STRING)
public abstract class ApptrackingBaseController {
    public static final String BASE_PATH_STRING = "/appTracking";
}
