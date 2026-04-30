package com.proyectoastah.xmiexport.export;

import java.io.File;

import com.change_vision.jude.api.inf.project.ProjectAccessor;

public class XmiExportService {
    private final XmiExporter nativeExporter = new NativeAstahXmiExporter();
    private final XmiExporter customExporter = new CustomXmiExporter();

    public void export(ProjectAccessor projectAccessor, File outputFile, ExportMode mode) throws Exception {
        projectAccessor.getProject();

        if (mode == ExportMode.CUSTOM) {
            customExporter.export(projectAccessor, outputFile);
            return;
        }

        nativeExporter.export(projectAccessor, outputFile);
    }
}
