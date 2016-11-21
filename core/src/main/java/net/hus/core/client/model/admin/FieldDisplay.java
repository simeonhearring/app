package net.hus.core.client.model.admin;

import java.util.List;

import org.gwtbootstrap3.client.ui.constants.ValidationState;

import net.hus.core.client.common.PageDisplay;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Field.DataType;
import net.hus.core.shared.model.Lookup;

public interface FieldDisplay extends PageDisplay
{
  public interface Action
  {
    void saveField();

    void refreshFields();

    ValidationState addField(String inName, String inType);

    void select(Long inFieldId);

    void update(DataType inType, String inValue);

    String arrayLabel(int inPos);

    void updateArray(String[] inLabels);
  }

  void setAction(Action inAction);

  void addFields(String inType, List<Lookup> inFields);

  void refreshFields();

  void clearFields();

  void set(Field inField);

  void addLookup(List<Lookup> inLookupGroups);
}