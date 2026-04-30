package com.proyectoastah.xmiexport.export;

import java.io.File;

import com.change_vision.jude.api.inf.project.ProjectAccessor;

public class CustomXmiExporter implements XmiExporter {
    @Override
    public void export(ProjectAccessor projectAccessor, File outputFile) {
        throw new UnsupportedOperationException("El exportador propio aun no esta implementado. Fase 1 usa exportacion nativa.");
    }
}
