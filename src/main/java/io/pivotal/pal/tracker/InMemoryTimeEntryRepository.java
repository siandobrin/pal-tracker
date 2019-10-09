package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    private Map<Long,TimeEntry>  store = new HashMap<>();
    private long nextId = 1L;

    public TimeEntry find(Long id) {
        return store.get(id);

    }

    public TimeEntry create(TimeEntry timeEntry) {


        TimeEntry timingEntry = new TimeEntry(nextId++,timeEntry.getProjectId(),timeEntry.getUserId(), timeEntry.getDate(),timeEntry.getHours());
        store.put(timingEntry.getId(), timingEntry);

        return timingEntry;

    }

    public List<TimeEntry> list() {

        return List.copyOf(store.values());
    }

    public TimeEntry update(Long id, TimeEntry timeEntry) {

        TimeEntry entry = store.get(id);

        if (entry != null) {
            entry.setProjectId(timeEntry.getProjectId());
            entry.setUserId(timeEntry.getUserId());
            entry.setDate(timeEntry.getDate());
            entry.setHours(timeEntry.getHours());
        }
        return entry;
    }

    public void delete(Long id) {
        store.remove(id);
    }
}


    //TimeEntry expected = new TimeEntry(timeEntryId, projectId, userId, LocalDate.parse("2017-01-08"), 8);