package model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class Poll {
    private String title;
    @Setter(AccessLevel.NONE)
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String description;
}
