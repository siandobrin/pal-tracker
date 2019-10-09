package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;


@RestController()
public class TimeEntryController {

    private TimeEntryRepository repository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.repository = timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry entryname = repository.create(timeEntryToCreate);

        return new ResponseEntity<TimeEntry>(entryname, HttpStatus.CREATED);
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable(value="id") long timeEntryId){

        TimeEntry entry = repository.find(timeEntryId);


        if( entry == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(entry, HttpStatus.OK);
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> result = repository.list();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

       @PutMapping("/time-entries/{id}")
        public ResponseEntity update(@PathVariable(value="id") long timeEntryId, @RequestBody TimeEntry expected) {

        TimeEntry entry = repository.update(timeEntryId, expected);

        if(entry == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(entry, HttpStatus.OK);
    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity delete(@PathVariable(value="id") long timeEntryId) {

        repository.delete(timeEntryId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}


//   TimeEntry expectedResult = new TimeEntry(timeEntryId, projectId, userId, LocalDate.parse("2017-01-08"), 8);