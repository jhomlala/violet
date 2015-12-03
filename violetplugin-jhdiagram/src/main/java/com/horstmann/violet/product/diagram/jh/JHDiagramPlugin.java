package com.horstmann.violet.product.diagram.jh;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.horstmann.violet.framework.plugin.IDiagramPlugin;
import com.horstmann.violet.framework.plugin.extensionpoint.Violet016FileFilterExtensionPoint;
import com.horstmann.violet.product.diagram.abstracts.IGraph;

/**
 * Describes state diagram graph type
 * 
 * @author Alexandre de Pellegrin
 * 
 */
public class JHDiagramPlugin implements IDiagramPlugin, Violet016FileFilterExtensionPoint
{

    @Override
    public String getDescription()
    {
        return "JH UML diagram";
    }

    @Override
    public String getProvider()
    {
        return "Alexandre de Pellegrin / Cays S. Horstmann";
    }

    @Override
    public String getVersion()
    {
        return "1.0.0";
    }

    @Override
    public String getName()
    {
        return "5.JH Diagram";
    }

    @Override
    public String getCategory()
    {
        return "2.Dynamic view";
    }

    @Override
    public String getFileExtension()
    {
        return this.rs.getString("files.jh.extension");
    }

    @Override
    public String getFileExtensionName()
    {
        return this.rs.getString("files.jh.name");
    }

    @Override
    public String getSampleFilePath()
    {
        return this.rs.getString("sample.file.path");
    }

    @Override
    public Class<? extends IGraph> getGraphClass()
    {
        return JHDiagramGraph.class;
        
    }

    public Map<String, String> getMappingToKeepViolet016Compatibility()
    {
        Map<String, String> replaceMap = new HashMap<String, String>();
        replaceMap.put("com.horstmann.violet.CircularStateNode", CircularInitialStateNode.class.getName());
        replaceMap.put("com.horstmann.violet.JHDiagramGraph", JHDiagramGraph.class.getName());
        replaceMap.put("com.horstmann.violet.StateNode", StateNode.class.getName());
        replaceMap.put("com.horstmann.violet.StateTransitionEdge", StateTransitionEdge.class.getName());
        return replaceMap;
    }

    private ResourceBundle rs = ResourceBundle.getBundle(StateDiagramConstant.STATE_DIAGRAM_STRINGS, Locale.getDefault());

}
