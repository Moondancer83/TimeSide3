package hu.kalee.timeside.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hu.kalee.timeside.controller.dto.TimeDto;
import hu.kalee.timeside.facade.TimeSessionFacade;

/**
 * TimeController.
 *
 * @author mkalinovits
 * @since 2017. 12. 22.
 */
@RestController
public class TimeController {
    @Autowired
    private TimeSessionFacade facade;

    @RequestMapping(value = "time", method = RequestMethod.GET)
    public List<TimeDto> getTimeSessions() {
        return facade.getAll();
    }

    @RequestMapping(value = "time", method = RequestMethod.POST)
    public TimeDto startTimeSession() {
        return facade.start();
    }

    @RequestMapping(value = "time/open")
    public TimeDto getOpenTimeSession() {
        return facade.getOpen();
    }

    @RequestMapping(value = "time/{id}", method = RequestMethod.GET)
    public TimeDto getTimeSession(@PathVariable Long id) {
        return facade.get(id);
    }

    @RequestMapping(value = "time/{id}", method = RequestMethod.PATCH)
    public TimeDto stopTimeSession(@PathVariable Long id) {
        return facade.stop(id);
    }

    @RequestMapping(value = "time/{id}/split")
    public Long getSplitTime(@PathVariable Long id) {
        return facade.split(id);
    }

    @RequestMapping(value = "time/close", method = RequestMethod.PATCH)
    public TimeDto closeActiveSession() {
        TimeDto active = facade.getOpen();
        if(active == null) {
            throw new IllegalStateException("There is no astive session to close");
        }
        return stopTimeSession(active.getId());
    }

    @RequestMapping(value = "time/toogle", method = RequestMethod.POST)
    public TimeDto toogleSession() {
        TimeDto active = facade.getOpenForCurrentUser();
        if (active == null) {
            active = facade.start();
        } else {
            active = facade.stop(active.getId());
        }

        return active;
    }

}
