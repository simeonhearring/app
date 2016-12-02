package net.hus.core.client.common;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.shared.model.Components.Type;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.FieldTKG;
import net.hus.core.shared.model.Value;

public interface UiManage
{
  IsWidget create(String inKey, int inPos, Type inCType);

  void update(List<Value> inValues, FieldTKG inFieldTKG);

  void makeSavable(String inKey);

  void addField(String inKey, String inLabel, FieldTKG inTKG, Field inField, int inPos);
}