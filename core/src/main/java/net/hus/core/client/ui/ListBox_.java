package net.hus.core.client.ui;

import java.util.ArrayList;
import java.util.List;

public class ListBox_ extends FocusWidget_
{
  private static final long serialVersionUID = -5860079083731912915L;

  private String[] mLookupParams;

  private Boolean mMultipleSelect;
  private List<Item> mItems = new ArrayList<>();

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

  public String[] getLookupParams()
  {
    return mLookupParams;
  }

  public void setLookupParams(String[] inLookupParams)
  {
    mLookupParams = inLookupParams;
  }

  public void add(String inText)
  {
    mItems.add(new Item(inText));
  }

  public void add(String inText, String inValue)
  {
    mItems.add(new Item(inText, inValue));
  }

  public void add(boolean inSelected, String inText, String inValue)
  {
    mItems.add(new Item(inSelected, inText, inValue));
  }

  public static class Item extends UIObject_
  {
    private static final long serialVersionUID = 227896791340387813L;

    private boolean mSelected;
    private String mText;
    private String mValue;

    public Item()
    {
    }

    public Item(String inText)
    {
      this();
      mText = inText;
    }

    public Item(String inText, String inValue)
    {
      this(inText);
      mValue = inValue;
    }

    public Item(boolean inSelected, String inText, String inValue)
    {
      this(inText, inValue);
      mSelected = inSelected;
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

    public String getValue()
    {
      return mValue;
    }

    public void setValue(String inValue)
    {
      mValue = inValue;
    }
  }
}