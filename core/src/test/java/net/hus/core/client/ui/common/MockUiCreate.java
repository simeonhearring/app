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
import org.gwtbootstrap3.client.ui.Panel;
import org.gwtbootstrap3.client.ui.PanelBody;
import org.gwtbootstrap3.client.ui.PanelFooter;
import org.gwtbootstrap3.client.ui.PanelHeader;
import org.gwtbootstrap3.client.ui.Row;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.constants.ColumnSize;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.FlexTable;

import net.hus.core.client.common.UiCreate;

public class MockUiCreate implements UiCreate
{
  @Override
  public Button newButton()
  {
    return GWT.create(Button.class);
  }

  @Override
  public FlexTable newFlexTable()
  {
    return GWT.create(FlexTable.class);
  }

  @Override
  public Heading newHeading(HeadingSize inSize, String inText)
  {
    return GWT.create(Heading.class);
  }

  @Override
  public Icon newIcon()
  {
    return GWT.create(Icon.class);
  }

  @Override
  public Column newColumn(ColumnSize inSize)
  {
    return GWT.create(Column.class);
  }

  @Override
  public Row newRow()
  {
    return GWT.create(Row.class);
  }

  @Override
  public Container newContainer()
  {
    return GWT.create(Container.class);
  }

  @Override
  public CheckBox newCheckBox()
  {
    return GWT.create(CheckBox.class);
  }

  @Override
  public ListBox newListBox()
  {
    return GWT.create(ListBox.class);
  }

  @Override
  public TextBox newTextBox()
  {
    return GWT.create(TextBox.class);
  }

  @Override
  public FormLabel newFormLabel()
  {
    return GWT.create(FormLabel.class);
  }

  @Override
  public FormGroup newFormGroup()
  {
    return GWT.create(FormGroup.class);
  }

  @Override
  public FieldSet newFieldSet()
  {
    return GWT.create(FieldSet.class);
  }

  @Override
  public Input newInput()
  {
    return GWT.create(Input.class);
  }

  @Override
  public Badge newBadge()
  {
    return GWT.create(Badge.class);
  }

  @Override
  public Alert newAlert()
  {
    return GWT.create(Alert.class);
  }

  @Override
  public Panel newPanel()
  {
    return GWT.create(Panel.class);
  }

  @Override
  public PanelHeader newPanelHeader()
  {
    return GWT.create(PanelHeader.class);
  }

  @Override
  public PanelBody newPanelBody()
  {
    return GWT.create(PanelBody.class);
  }

  @Override
  public PanelFooter newPanelFooter()
  {
    return GWT.create(PanelFooter.class);
  }
}
