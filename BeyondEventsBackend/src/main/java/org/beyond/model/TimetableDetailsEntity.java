package org.beyond.model;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "timetable_table_details_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TimetableDetailsEntity {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, columnDefinition = "timestamp with time zone")
    private OffsetDateTime createdAt;

    @Column(name = "timetable", columnDefinition = "jsonb")
    private JsonNode timetable;

    @Column(name = "event_length")
    private String eventLength;

    @Column(name = "time_slots")
    private Integer timeSlots;

    @Column(name = "events_per_slot")
    private Integer eventsPerSlot;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private EventEntity event;

    @Column(name = "rooms")
    private List<LocationEntity> rooms;

}
