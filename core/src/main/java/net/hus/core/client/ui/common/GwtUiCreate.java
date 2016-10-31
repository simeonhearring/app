package net.hus.core.client.ui.common;

import org.gwtbootstrap3.client.ui.Alert;
import org.gwtbootstrap3.client.ui.Badge;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.CheckBox;
import org.gwtbootstrap3.client.ui.Column;
import org.gwtbootstrap3.client.ui.Container;
import org.gwtbootstrap3.client.ui.FieldSet;
import org.gwtbootstrap3.client.ui.FormGroup;
import org.gwtbootstrap3.client.ui.FormLabel;
import org.gwtbootstrap3.client.ui.Heading;
import org.gwtbootstrap3.client.ui.Icon;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.Row;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.constants.ColumnSize;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;

import com.google.gwt.user.client.ui.FlexTable;

import net.hus.core.client.common.UiCreate;

public class GwtUiCreate implements UiCreate
{
  @Override
  public Button newButton()
  {
    return new Button();
  }

  @Override
  public FlexTable newFlexTable()
  {
    return new FlexTable();
  }

  @Override
  public Heading newHeading(HeadingSize inSize, String inText)
  {
    return new Heading(inSize, inText);
  }

  @Override
  public Icon newIcon()
  {
    return new Icon();
  }

  @Override
  public Column newColumn(ColumnSize inSize)
  {
    return new Column(inSize);
  }

  @Override
  public Row newRow()
  {
    return new Row();
  }

  @Override
  public Container newContainer()
  {
    return new Container();
  }

  @Override
  public CheckBox newCheckBox()
  {
    return new CheckBox();
  }

  @Override
  public ListBox newListBox()
  {
    return new ListBox();
  }

  @Override
  public TextBox newTextBox()
  {
    return new TextBox();
  }

  @Override
  public FormLabel newFormLabel()
  {
    return new FormLabel();
  }

  @Override
  public FormGroup newFormGroup()
  {
    return new FormGroup();
  }

  @Override
  public FieldSet newFieldSet()
  {
    return new FieldSet();
  }

  @Override
  public Input newInput()
  {
    return new Input();
  }

  @Override
  public Badge newBadge()
  {
    return new Badge();
  }

  @Override
  public Alert newAlert()
  {
    return new Alert();
  }
}