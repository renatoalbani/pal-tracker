package io.pivotal.pal.tracker;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private final Map<Long, TimeEntry> entries = new HashMap<>();
    private final AtomicLong entryKey = new AtomicLong();


    @Override
    public TimeEntry create(TimeEntry any) {
        long key = entryKey.incrementAndGet();
        TimeEntry entry = new TimeEntry(key, any.getProjectId(), any.getUserId(), any.getDate(), any.getHours());
        entries.put(key, entry);
        return entry;
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        if(!entries.containsKey(timeEntryId))
            return null;
        return entries.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(entries.values());
    }

    @Override
    public TimeEntry update(long eq, TimeEntry any) {
        if(!entries.containsKey(eq))
            return null;
        TimeEntry timeEntry = entries.get(eq);
        timeEntry.setProjectId(any.getProjectId());
        timeEntry.setUserId(any.getUserId());
        timeEntry.setDate(any.getDate());
        timeEntry.setHours(any.getHours());
        return entries.put(eq, timeEntry);
    }

    @Override
    public void delete(long timeEntryId) {
        entries.remove(timeEntryId);
    }
}
