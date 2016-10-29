package net.hus.core.client.model;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.client.ui.common.Views;
import net.hus.core.model.TableKey;
import net.hus.core.model.Value;

public interface UiManager extends UiConverter
{
  void add(String inKey, IsWidget inUiO);

  Views<?> get(String... inKey);

  void update(List<Value> inValues, TableKey inTk);
}