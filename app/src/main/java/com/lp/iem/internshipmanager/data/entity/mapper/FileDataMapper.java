package com.lp.iem.internshipmanager.data.entity.mapper;

import com.lp.iem.internshipmanager.data.entity.FileEntity;
import com.lp.iem.internshipmanager.presentation.model.File;

import java.util.ArrayList;
import java.util.List;

public class FileDataMapper {
    public List<File> transform(List<FileEntity> fileEntityList){
        List<File> fileList = new ArrayList<>();
        for(FileEntity fileEntity : fileEntityList){
            fileList.add(transform(fileEntity));
        }
        return fileList;
    }
    public File transform(FileEntity fileEntity){
        File file = new File(fileEntity.filePath);
        file.setId(fileEntity.id);
        file.setDescription(fileEntity.description);
        return file;
    }
}
