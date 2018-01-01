package hu.kalee.timeside.facade;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import hu.kalee.timeside.controller.dto.TimeDto;
import hu.kalee.timeside.converter.TimeSessionConverter;
import hu.kalee.timeside.data.entity.TimeSession;
import hu.kalee.timeside.data.TimeSessionRepository;
import hu.kalee.timeside.data.entity.User;
import hu.kalee.timeside.data.UserRepository;

/**
 * TimeSessionFacade.
 *
 * @author mkalinovits
 * @since 2017. 12. 22.
 */
@Component
public class TimeSessionFacade {
    @Autowired
    private TimeSessionRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TimeSessionConverter converter;

    public List<TimeDto> getAll() {
        return Lists.transform((List<TimeSession>)repository.findAll(), converter::convert);
    }

    public TimeDto getOpen() {
        return converter.convert(repository.findByOpen(true));
    }

    public TimeDto start() {
        final TimeSession entity = new TimeSession();
        entity.setStart(new Date());
        entity.setOpen(true);
        entity.setUser(getCurrentUser());
        return converter.convert(repository.save(entity));
    }

    public TimeDto stop(final Long id) {
        TimeSession entity = repository.findOne(id);
        if (entity == null) {
            throw new IllegalStateException();
        }
        entity.setEnd(new Date());
        entity.setOpen(false);

        return converter.convert(repository.save(entity));
    }

    public Long split(final Long id) {
        TimeSession entity = repository.findOne(id);
        if (entity == null) {
            throw new IllegalStateException();
        }

        return new Date().getTime() - entity.getStart().getTime();
    }

    public TimeDto get(final Long id) {
        return converter.convert(repository.findOne(id));
    }

    //    --------------------------------------------------------------------------------------------------------//

    public List<TimeDto> getAllForCurrentUser() {
        User user = getCurrentUser();
        return Lists.transform((List<TimeSession>)repository.findAllByUserId(user.getId()), converter::convert);
    }

    public TimeDto getOpenForCurrentUser() {
        User user = getCurrentUser();
        return converter.convert(repository.findByOpenAndUserId(true, user.getId()));
    }

    private User getCurrentUser() {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(userEmail);
    }
}
