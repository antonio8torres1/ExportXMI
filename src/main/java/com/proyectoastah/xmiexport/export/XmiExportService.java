package com.proyectoastah.xmiexport.export;

import java.io.File;

import com.change_vision.jude.api.inf.project.ProjectAccessor;

public class XmiExportService {
    private final XmiExporter nativeExporter = new NativeAstahXmiExporter();
    private final XmiExporter customExporter = new CustomXmiExporter();

    public void export(ProjectAccessor projectAccessor, File outputFile, ExportMode mode) throws Exception {
        projectAccessor.getProject();

        switch (mode) {
        case CUSTOM:
            exportWith(customExporter, projectAccessor, outputFile);
            break;
        case AUTO:
        case NATIVE:
            exportWith(nativeExporter, projectAccessor, outputFile);
            break;
        default:
            throw new IllegalArgumentException("Modo de exportacion no soportado: " + mode);
        }
    }

    private void exportWith(XmiExporter exporter, ProjectAccessor projectAccessor, File outputFile) throws Exception {
        exporter.export(projectAccessor, outputFile);
        validateOutputFile(outputFile);
    }

    private void validateOutputFile(File outputFile) {
        if (!outputFile.isFile()) {
            throw new IllegalStateException("Astah no genero el archivo XMI de salida.");
        }
        if (outputFile.length() == 0) {
            throw new IllegalStateException("Astah genero un archivo XMI vacio.");
        }
    }
}
