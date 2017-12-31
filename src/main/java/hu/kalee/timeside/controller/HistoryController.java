package hu.kalee.timeside.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return facade.getAll();
    }

    @ModelAttribute("hasActive")
    public boolean hasActive() {
        TimeDto last = facade.getOpen();
        return last != null;
    }

    @RequestMapping(value = "toogle")
    public String toogle() {
        timeController.toogleSession();
        return "redirect:/history";
    }

}
