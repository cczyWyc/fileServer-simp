package com.cczywyc.fileserver.fileservice.impl;


import com.cczywyc.fileserver.fileservice.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * file service impl
 *
 * @author wangyc
 */
public class FileServiceImpl implements FileService {

    /** log object */
    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public List<File> getFileList(String path) {
        List<File> files = new ArrayList<>();
        try {
            Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    files.add(file.toFile());
                    return super.visitFile(file, attrs);
                }
            });
        } catch (IOException e) {
            logger.info(null, e);
        }
        return files;
    }

    @Override
    public void uploadFile(File file) {

    }

    @Override
    public File downloadFile(File file) {
        return null;
    }
}
