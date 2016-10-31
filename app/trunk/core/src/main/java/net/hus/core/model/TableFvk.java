package net.hus.core.model;

import java.io.Serializable;

/**
 * Understands how to query FIELD_GROUP for a set of FIELDS to update
 * Components.
 *
 * Understands how to update FIELD_VALUE for a FVK (FIELD_VALUE mKey).
 *
 * Page.Name manages which Page should be loaded for Components.
 *
 * @author simeonhearring
 * @since October 2016
 */
public class TableFvk implements Serializable
{
  private static final long serialVersionUID = 908199922488294162L;

  private String mFvt;
  private String mFvk;

  private String mFgg;

  private Page.Name mPage;

  TableFvk()
  {
  }

  public TableFvk(String inTable, String inFvk, String inGroup)
  {
    mFvt = inTable;
    mFvk = inFvk;
    mFgg = inGroup;
  }

  public String getFvt()
  {
    return mFvt;
  }

  public void setFvt(String inTable)
  {
    mFvt = inTable;
  }

  public String getFvk()
  {
    return mFvk;
  }

  public void setFvk(String inFvk)
  {
    mFvk = inFvk;
  }

  public String getFgg()
  {
    return mFgg;
  }

  public void setFgg(String inGroup)
  {
    mFgg = inGroup;
  }

  public Page.Name getPage()
  {
    return mPage;
  }

  public void setPage(Page.Name inPage)
  {
    mPage = inPage;
  }
}