package com.proyectoastah.xmiexport.export;

import java.io.File;

import com.change_vision.jude.api.inf.project.ProjectAccessor;

public class NativeAstahXmiExporter implements XmiExporter {
    @Override
    public void export(ProjectAccessor projectAccessor, File outputFile) throws Exception {
        projectAccessor.exportXMI(outputFile.getAbsolutePath());
    }
}
