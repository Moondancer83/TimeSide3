package hu.kalee.timeside.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.kalee.timeside.controller.dto.TimeDto;
import hu.kalee.timeside.controller.rest.TimeController;
import hu.kalee.timeside.facade.TimeSessionFacade;

/**
 * HistoryController.
 *
 * @author mkalinovits
 * @since 2017. 12. 29.
 */
@Controller
@RequestMapping(value = "/history")
public class HistoryController {
    @Autowired
    private TimeSessionFacade facade;
    @Autowired
    private TimeController timeController;

    @RequestMapping
    public String history() {
        return "history";
    }

    @ModelAttribute("sessions")
    public List<TimeDto> messages() {
        return facade.getAllForCurrentUser();
    }

    @ModelAttribute("hasActive")
    public boolean hasActive() {
        TimeDto last = facade.getOpenForCurrentUser();
        return last != null;
    }

    @RequestMapping(value = "toogle")
    public String toogle() {
        timeController.toogleSession();
        return "redirect:/history";
    }

}
