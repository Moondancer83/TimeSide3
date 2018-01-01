package hu.kalee.timeside.data;

import org.springframework.data.repository.PagingAndSortingRepository;

import hu.kalee.timeside.data.entity.TimeSession;

/**
 * TimeSessionRepository.
 *
 * @author mkalinovits
 * @since 2017. 12. 22.
 */
public interface TimeSessionRepository extends PagingAndSortingRepository<TimeSession, Long> {
    TimeSession findByOpen(boolean open);

    TimeSession findByOpenAndUserId(boolean open, int id);

    Iterable<TimeSession> findAllByUserId(int id);
}
