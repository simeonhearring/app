package net.hus.core.client.model.admin;

import java.util.List;

import org.gwtbootstrap3.client.ui.constants.ValidationState;

import net.hus.core.client.common.Display;
import net.hus.core.shared.model.Components;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Field.DataType;
import net.hus.core.shared.model.Lookup;

public interface FieldDisplay extends Display
{
  public interface Action
  {
    void saveField();

    void refreshFields();

    ValidationState addField(String inName, String inType);

    void select(Long inFieldId);

    void update(DataType inType, Object inValue);

    String arrayLabel(int inPos);

    Long fieldId(int inPos);

    void updateArray(String[] inLabels);

    void updateTable(Long[] inTableFields);

    List<Lookup> getFields();

    boolean isTable();

    Components.Type cType(int inPos);

    void updateCTypes(Components.Type[] inCTypes);

    List<Lookup> getFvt();
  }

  void setAction(Action inAction);

  void addFields(String inType, List<Lookup> inFields);

  void refreshFields();

  void clearFields();

  void set(Field inField);

  void addLookup(List<Lookup> inLookupGroups);
}