package hu.kalee.timeside.facade;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import hu.kalee.timeside.controller.TimeDto;
import hu.kalee.timeside.data.TimeSession;
import hu.kalee.timeside.data.TimeSessionRepository;

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
    private TimeSessionConverter converter;

    public List<TimeDto> getAll() {
        return Lists.transform((List<TimeSession>)repository.findAll(), converter::convert);
    }

    public TimeDto getOpen() {
        return converter.convert(repository.findByOpen(true));
    }

    public TimeDto start() {
        final TimeSession entity = new TimeSession();
        entity.setStart(new Date().getTime());
        entity.setOpen(true);
        return converter.convert(repository.save(entity));
    }

    public TimeDto stop(final Long id) {
        TimeSession entity = repository.findOne(id);
        if (entity == null) {
            throw new IllegalStateException();
        }
        entity.setEnd(new Date().getTime());
        entity.setOpen(false);

        return converter.convert(repository.save(entity));
    }

    public Long split(final Long id) {
        TimeSession entity = repository.findOne(id);
        if (entity == null) {
            throw new IllegalStateException();
        }

        return new Date().getTime() - entity.getStart();
    }

    public TimeDto get(final Long id) {
        return converter.convert(repository.findOne(id));
    }
}
