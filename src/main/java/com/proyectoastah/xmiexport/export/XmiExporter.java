package com.proyectoastah.xmiexport.export;

import java.io.File;

import com.change_vision.jude.api.inf.project.ProjectAccessor;

public interface XmiExporter {
    void export(ProjectAccessor projectAccessor, File outputFile) throws Exception;
}
