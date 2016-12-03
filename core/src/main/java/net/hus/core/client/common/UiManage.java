package net.hus.core.client.common;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.UIObject_;
import net.hus.core.shared.model.Value;

public interface UiManage
{
  void update(List<Value> inValues, FieldTKG inFieldTKG);

  void makeSavable(String inKey);

  void addField(String inKey, String inLabel, FieldTKG inTKG, Field inField, int inPos);

  IsWidget match(UIObject_ inUiObject);
}