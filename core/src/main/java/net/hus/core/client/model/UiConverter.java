package net.hus.core.client.model;

import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.shared.model.Alert_;
import net.hus.core.shared.model.Badge_;
import net.hus.core.shared.model.CheckBox_;
import net.hus.core.shared.model.Column_;
import net.hus.core.shared.model.Container_;
import net.hus.core.shared.model.FieldSet_;
import net.hus.core.shared.model.FormGroup_;
import net.hus.core.shared.model.FormLabel_;
import net.hus.core.shared.model.Icon_;
import net.hus.core.shared.model.Input_;
import net.hus.core.shared.model.ListBox_;
import net.hus.core.shared.model.Row_;
import net.hus.core.shared.model.TextBox_;

public interface UiConverter
{
  IsWidget convert(Column_ inUiO);

  IsWidget convert(Alert_ inUiO);

  IsWidget convert(Badge_ inUiO);

  IsWidget convert(CheckBox_ inUiO);

  IsWidget convert(Container_ inUiO);

  IsWidget convert(FieldSet_ inUiO);

  IsWidget convert(FormGroup_ inUiO);

  IsWidget convert(FormLabel_ inUiO);

  IsWidget convert(Input_ inUiO);

  IsWidget convert(ListBox_ inUiO);

  IsWidget convert(Row_ inUiO);

  IsWidget convert(TextBox_ inUiO);

  IsWidget convert(Icon_ inUiO);
}