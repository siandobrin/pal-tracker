package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {

    public TimeEntry find(Long id);

    public TimeEntry create(TimeEntry timeEntry);

    public List<TimeEntry> list() ;

    public TimeEntry update(Long id, TimeEntry timeEntry);

    public void delete(Long id);


}


