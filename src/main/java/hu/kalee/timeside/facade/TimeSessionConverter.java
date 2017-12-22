package hu.kalee.timeside.facade;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import hu.kalee.timeside.controller.TimeDto;
import hu.kalee.timeside.data.TimeSession;

/**
 * TimeSessionConverter.
 *
 * @author mkalinovits
 * @since 2017. 12. 22.
 */
@Component
public class TimeSessionConverter implements Converter<TimeSession, TimeDto> {
    @Override
    public TimeDto convert(final TimeSession source) {
        TimeDto r = null;
        if (source != null) {
            r = new TimeDto();
            r.setId(source.getId());
            r.setStart(new Date(source.getStart()));
            r.setEnd(new Date(source.getEnd()));
            r.setOpen(source.getOpen());
        }
        return r;
    }
}
