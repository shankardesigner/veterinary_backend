package com.shankardesigner.poudelveterinary.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FileStorageProperties {
    private String imageName;
    private String uploadDir;

    public FileStorageProperties(String originalFilename, String realPath) {
    }
}
