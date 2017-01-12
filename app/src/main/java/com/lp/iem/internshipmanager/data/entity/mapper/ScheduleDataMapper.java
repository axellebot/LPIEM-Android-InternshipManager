package com.lp.iem.internshipmanager.data.entity.mapper;

import com.lp.iem.internshipmanager.data.entity.ScheduleEntity;
import com.lp.iem.internshipmanager.presentation.model.Schedule;

import java.util.ArrayList;
import java.util.List;

public class ScheduleDataMapper {
    public List<Schedule> transform(List<ScheduleEntity> scheduleEntityList) {
        List<Schedule> schedulesList = new ArrayList<>();
        for (ScheduleEntity scheduleEntity : scheduleEntityList) {
            schedulesList.add(transform(scheduleEntity));
        }
        return schedulesList;
    }

    public Schedule transform(ScheduleEntity scheduleEntity) {
        Schedule schedule = new Schedule();
        schedule.setId(scheduleEntity.id);
        schedule.setLabel(scheduleEntity.label);
        schedule.setDescription(scheduleEntity.description);
        schedule.setDate(scheduleEntity.date);
        schedule.setStudentId(scheduleEntity.student.id);
        return schedule;
    }

    /**
     * Does not take into account the relationships
     */
    public List<ScheduleEntity> transformReverse(List<Schedule> scheduleList) {
        List<ScheduleEntity> scheduleEntityList = new ArrayList<>();
        for (Schedule schedule : scheduleList) {
            scheduleEntityList.add(transformReverse(schedule));
        }
        return scheduleEntityList;
    }

    /**
     * Does not take into account the relationships
     */
    public ScheduleEntity transformReverse(Schedule schedule) {
        ScheduleEntity scheduleEntity = new ScheduleEntity();
        scheduleEntity.id = schedule.getId();
        scheduleEntity.label = schedule.getLabel();
        scheduleEntity.description = schedule.getDescription();
        scheduleEntity.date = schedule.getDate();
        return scheduleEntity;
    }
}
