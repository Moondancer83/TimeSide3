package hu.kalee.timeside.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import hu.kalee.timeside.controller.dto.TimeDto;
import hu.kalee.timeside.data.entity.TimeSession;

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
            result.setStart(source.getStart());
            result.setEnd(source.getEnd());
            result.setOpen(source.isOpen());
        }
        return result;
    }
}
