package hu.kalee.timeside.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import hu.kalee.timeside.facade.TimeSessionFacade;

/**
 * TimeControllerTest.
 *
 * @author mkalinovits
 * @since 2017. 12. 26.
 */
@RunWith(MockitoJUnitRunner.class)
public class TimeControllerTest {
    @InjectMocks
    private TimeController underTest;
    @Mock
    private TimeSessionFacade facade;

    @Test
    public void testGetTimeSessionsShouldCallGetAllFromFacade() {
        // GIVEN
        // WHEN
        underTest.getTimeSessions();
        // THEN
        Mockito.verify(facade).getAll();
    }

    @Test
    public void testStartTimeSessionShouldCallStartFromFacade() {
        // GIVEN
        // WHEN
        underTest.startTimeSession();
        // THEN
        Mockito.verify(facade).start();
    }
}