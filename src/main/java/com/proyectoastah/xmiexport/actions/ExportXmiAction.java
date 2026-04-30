package com.proyectoastah.xmiexport.actions;

import java.io.File;

import javax.swing.JOptionPane;

import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.project.ProjectAccessor;
import com.change_vision.jude.api.inf.ui.IPluginActionDelegate;
import com.change_vision.jude.api.inf.ui.IWindow;
import com.proyectoastah.xmiexport.export.ExportMode;
import com.proyectoastah.xmiexport.export.XmiExportService;
import com.proyectoastah.xmiexport.ui.FileSelection;

public class ExportXmiAction implements IPluginActionDelegate {
    private final XmiExportService exportService = new XmiExportService();

    @Override
    public Object run(IWindow window) throws UnExpectedException {
        try {
            ProjectAccessor projectAccessor = AstahAPI.getAstahAPI().getProjectAccessor();
            if (!projectAccessor.hasProject()) {
                JOptionPane.showMessageDialog(window.getParent(), "No hay un proyecto Astah abierto para exportar.",
                        "XMI Exporter", JOptionPane.WARNING_MESSAGE);
                return null;
            }

            File outputFile = FileSelection.selectXmiOutputFile(window.getParent());
            if (outputFile == null) {
                return null;
            }

            exportService.export(projectAccessor, outputFile, ExportMode.AUTO);
            JOptionPane.showMessageDialog(window.getParent(), "XMI exportado correctamente:\n" + outputFile.getAbsolutePath(),
                    "XMI Exporter", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(window.getParent(), "Error al exportar XMI:\n" + e.getMessage(),
                    "XMI Exporter", JOptionPane.ERROR_MESSAGE);
            throw new UnExpectedException();
        }

        return null;
    }
}
