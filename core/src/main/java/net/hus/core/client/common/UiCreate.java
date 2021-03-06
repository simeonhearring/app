package net.hus.core.client.common;

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
import org.gwtbootstrap3.client.ui.constants.InputType;
import org.gwtbootstrap3.client.ui.html.Br;
import org.gwtbootstrap3.client.ui.html.Hr;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.IsWidget;

import net.hus.core.shared.model.Components;

/**
 * Contract for creation of all UI Objects.
 *
 * @author simeonhearring
 * @since October 2016
 */
public interface UiCreate
{
  Button newButton();

  FlexTable newFlexTable();

  Heading newHeading(HeadingSize inSize, String inText);

  Icon newIcon();

  Column newColumn(ColumnSize inSize);

  Row newRow();

  Container newContainer();

  CheckBox newCheckBox();

  ListBox newListBox();

  TextBox newTextBox();

  FormLabel newFormLabel();

  FormGroup newFormGroup();

  FieldSet newFieldSet();

  Input newInput();

  Input newInput(InputType inType);

  Badge newBadge();

  Alert newAlert();

  Panel newPanel();

  PanelHeader newPanelHeader();

  Br newBr();

  Hr newHr();

  PanelBody newPanelBody();

  PanelFooter newPanelFooter();

  IsWidget create(Components.Type inCType);
}