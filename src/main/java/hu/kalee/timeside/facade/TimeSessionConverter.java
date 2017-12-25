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
        TimeDto result = null;
        if (source != null) {
            result = new TimeDto();
            result.setId(source.getId());
            result.setStart(getNullsafeDate(source.getStart()));
            result.setEnd(getNullsafeDate(source.getEnd()));
            result.setOpen(source.getOpen());
        }
        return result;
    }

    private Date getNullsafeDate(final Long value) {
        return value != null ? new Date(value) : null;
    }
}
