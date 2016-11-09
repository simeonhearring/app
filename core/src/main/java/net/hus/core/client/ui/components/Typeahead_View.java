package net.hus.core.client.ui.components;

import java.util.List;

import org.gwtbootstrap3.extras.typeahead.client.events.TypeaheadSelectedEvent;
import org.gwtbootstrap3.extras.typeahead.client.events.TypeaheadSelectedHandler;
import org.gwtbootstrap3.extras.typeahead.client.ui.Typeahead;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

import net.hus.core.shared.model.TypeaheadOption;
import net.hus.core.shared.model.Value;

public class Typeahead_View extends AbstractComposite_View<Typeahead<TypeaheadOption>>
implements TypeaheadSelectedHandler<TypeaheadOption>
{
  private static final Binder BINDER = GWT.create(Binder.class);

  interface Binder extends UiBinder<Widget, Typeahead_View>
  {
  }

  @UiField
  Typeahead<TypeaheadOption> mComponent;

  private TypeaheadData mOptions = new TypeaheadData();

  public Typeahead_View()
  {
    initWidget(BINDER.createAndBindUi(this));
  }

  @Override
  public void addChangeHandler()
  {
    mComponent.addTypeaheadSelectedHandler(this);
    mComponent.addClickHandler(this);
  }

  @Override
  public Typeahead<TypeaheadOption> getComponent()
  {
    return mComponent;
  }

  @Override
  public void setValue(Value inValue)
  {
    mComponent.setValue(inValue.getValue());
  }

  @Override
  public void onSelected(TypeaheadSelectedEvent<TypeaheadOption> inEvent)
  {
    TypeaheadOption option = inEvent.getSuggestion().getData();
    save(option.option(), option.optionId(), option.option());
  }

  public void setOptions(List<TypeaheadOption> inOptions)
  {
    mComponent.setDatasets(new TypeaheadStaticDataset(mOptions, inOptions));
  }

  public void setLookupGroups(String[] inLookupGroups)
  {
    mComponent.setDatasets(new TypeaheadRpcDataset(mOptions, inLookupGroups));
  }
}