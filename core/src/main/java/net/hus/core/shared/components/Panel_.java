package net.hus.core.shared.components;

import java.util.ArrayList;
import java.util.List;

import org.gwtbootstrap3.client.ui.constants.PanelType;

public class Panel_ extends UIObject_
{
  private static final long serialVersionUID = 8558694859904920002L;

  private PanelType mType;

  private List<UIObject_> mCollection = new ArrayList<>();

  public List<UIObject_> getCollection()
  {
    return mCollection;
  }

  public void add(UIObject_ inUiObject)
  {
    mCollection.add(inUiObject);
  }

  public PanelType getType()
  {
    return mType;
  }

  public void setType(PanelType inType)
  {
    mType = inType;
  }
}