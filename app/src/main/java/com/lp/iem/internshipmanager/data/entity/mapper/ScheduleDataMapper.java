package com.lp.iem.internshipmanager.data.entity.mapper;

import com.lp.iem.internshipmanager.data.entity.ScheduleEntity;
import com.lp.iem.internshipmanager.presentation.model.Schedule;

import java.util.ArrayList;
import java.util.List;

public class ScheduleDataMapper {
    public List<Schedule> transform(List<ScheduleEntity> scheduleEntityList){
        List<Schedule> schedulesList = new ArrayList<>();
        for(ScheduleEntity scheduleEntity : scheduleEntityList){
            schedulesList.add(transform(scheduleEntity));
        }
        return schedulesList;
    }
    public Schedule transform(ScheduleEntity scheduleEntity){
        Schedule schedule = new Schedule();
        return schedule;
    }
}
