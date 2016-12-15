package net.hus.core.shared.components;

import java.util.ArrayList;
import java.util.List;

import net.hus.core.shared.model.Components.Type;
import net.hus.core.shared.model.Field;
import net.hus.core.shared.model.Field.Lookup.Location;
import net.hus.core.shared.model.Lookup;
import net.hus.core.shared.model.LookupOptions;
import net.hus.core.shared.model.UIObject_;

public class ListBox_ extends FocusWidget_ implements LookupOptions
{
  private static final long serialVersionUID = -5860079083731912915L;

  private Field.Lookup mLookup;
  private Boolean mMultipleSelect;
  private List<Item> mItems;

  @Override
  public Type cType()
  {
    return Type.LIST_BOX;
  }

  public Boolean getMultipleSelect()
  {
    return mMultipleSelect;
  }

  public void setMultipleSelect(Boolean inMultipleSelect)
  {
    mMultipleSelect = inMultipleSelect;
  }

  public List<Item> getItems()
  {
    return mItems;
  }

  public void clearItems()
  {
    if (mItems == null)
    {
      mItems = new ArrayList<>();
    }
    mItems.clear();
  }

  @Override
  public void init()
  {
    if (mItems == null)
    {
      mItems = new ArrayList<>();
    }
  }

  @Override
  public void add(Lookup inLookup)
  {
    add(inLookup.getName(), inLookup.getId());
  }

  public void add(String inText)
  {
    mItems.add(new Item(inText));
  }

  public void add(String inText, Long inValue)
  {
    mItems.add(new Item(inText, inValue));
  }

  public void add(boolean inSelected, String inText, Long inValueId)
  {
    mItems.add(new Item(inSelected, inText, inValueId));
  }

  public Field.Lookup getLookup()
  {
    return mLookup;
  }

  public void setLookup(Field.Lookup inLookup)
  {
    mLookup = inLookup;
  }

  public static class Item extends UIObject_
  {
    private static final long serialVersionUID = 227896791340387813L;

    private boolean mSelected;
    private String mText;
    private Long mValueId;

    public Item()
    {
    }

    public Item(String inText)
    {
      this();
      mText = inText;
    }

    public Item(String inText, Long inValueId)
    {
      this(inText);
      mValueId = inValueId;
    }

    public Item(boolean inSelected, String inText, Long inValueId)
    {
      this(inText, inValueId);
      mSelected = inSelected;
    }

    @Override
    public Type cType()
    {
      return Type.ITEM;
    }

    public boolean isSelected()
    {
      return mSelected;
    }

    public void setSelected(boolean inSelected)
    {
      mSelected = inSelected;
    }

    public String getText()
    {
      return mText;
    }

    public void setText(String inText)
    {
      mText = inText;
    }

    public Long getValueId()
    {
      return mValueId;
    }

    public void setValueId(Long inValueId)
    {
      mValueId = inValueId;
    }
  }

  @Override
  public Location getLocation()
  {
    return mLookup.getLocation();
  }

  @Override
  public String[] getLookupGroups()
  {
    return mLookup.getParameters().split(",");
  }
}