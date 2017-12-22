package hu.kalee.timeside.data;

/**
 * TimeSessionRepository.
 *
 * @author mkalinovits
 * @since 2017. 12. 22.
 */

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TimeSessionRepository extends PagingAndSortingRepository<TimeSession, Long> {
    TimeSession findByOpen(boolean open);
}
