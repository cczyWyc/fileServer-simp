package com.cczywyc.fileserver.fileservice;

import java.io.File;
import java.util.List;

/**
 * file service
 *
 * @author wangyc
 */
public interface FileService {

    /**
     * get file list in the folder
     *
     * @param path folder location
     * @return file list in the folder
     */
    List<File> getFileList(String path);

    /**
     * upload file to the file server
     *
     * @param file file
     */
    void uploadFile(final File file);

    /**
     * download file from the file server
     *
     * @param file file
     * @return download the file
     */
    File downloadFile(final File file);
}
