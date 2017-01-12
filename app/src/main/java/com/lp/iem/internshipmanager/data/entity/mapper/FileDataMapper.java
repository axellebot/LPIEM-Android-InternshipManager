package com.lp.iem.internshipmanager.data.entity.mapper;

import com.lp.iem.internshipmanager.data.entity.FileEntity;
import com.lp.iem.internshipmanager.presentation.model.File;

import java.util.ArrayList;
import java.util.List;

public class FileDataMapper {
    public List<File> transform(List<FileEntity> fileEntityList) {
        List<File> fileList = new ArrayList<>();
        for (FileEntity fileEntity : fileEntityList) {
            fileList.add(transform(fileEntity));
        }
        return fileList;
    }

    public File transform(FileEntity fileEntity) {
        File file = new File(fileEntity.filePath);
        file.setId(fileEntity.id);
        file.setDescription(fileEntity.description);
        file.setStudentId(fileEntity.student.id);
        return file;
    }

    /**
     * Does not take into account the relationships
     */
    public List<FileEntity> transformRevers(List<File> fileList) {
        List<FileEntity> fileEntityList = new ArrayList<>();
        for (File file : fileList) {
            fileEntityList.add(transformReverse(file));
        }
        return fileEntityList;
    }

    /**
     * Does not take into account the relationships
     */
    public FileEntity transformReverse(File file) {
        FileEntity fileEntity = new FileEntity();
        fileEntity.id = file.getId();
        fileEntity.filePath = file.getAbsolutePath();
        fileEntity.description = file.getDescription();
        return fileEntity;
    }
}
