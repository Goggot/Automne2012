package model.view;

import model.entities.VClientImpl;

import oracle.jbo.RowIterator;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Dec 12 15:00:19 EST 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class VClientViewRowImpl
  extends ViewRowImpl
{
  public static final int ENTITY_VCLIENT = 0;

  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
   */
  public enum AttributesEnum
  {
    Clino
    {
      public Object get(VClientViewRowImpl obj)
      {
        return obj.getClino();
      }

      public void put(VClientViewRowImpl obj, Object value)
      {
        obj.setClino((Integer)value);
      }
    }
    ,
    Cliprenom
    {
      public Object get(VClientViewRowImpl obj)
      {
        return obj.getCliprenom();
      }

      public void put(VClientViewRowImpl obj, Object value)
      {
        obj.setCliprenom((String)value);
      }
    }
    ,
    Clinom
    {
      public Object get(VClientViewRowImpl obj)
      {
        return obj.getClinom();
      }

      public void put(VClientViewRowImpl obj, Object value)
      {
        obj.setClinom((String)value);
      }
    }
    ,
    Clirue
    {
      public Object get(VClientViewRowImpl obj)
      {
        return obj.getClirue();
      }

      public void put(VClientViewRowImpl obj, Object value)
      {
        obj.setClirue((String)value);
      }
    }
    ,
    Cliville
    {
      public Object get(VClientViewRowImpl obj)
      {
        return obj.getCliville();
      }

      public void put(VClientViewRowImpl obj, Object value)
      {
        obj.setCliville((String)value);
      }
    }
    ,
    Clitelephone
    {
      public Object get(VClientViewRowImpl obj)
      {
        return obj.getClitelephone();
      }

      public void put(VClientViewRowImpl obj, Object value)
      {
        obj.setClitelephone((String)value);
      }
    }
    ,
    VContratView
    {
      public Object get(VClientViewRowImpl obj)
      {
        return obj.getVContratView();
      }

      public void put(VClientViewRowImpl obj, Object value)
      {
        obj.setAttributeInternal(index(), value);
      }
    }
    ;
    private static AttributesEnum[] vals = null;
    private static int firstIndex = 0;

    public abstract Object get(VClientViewRowImpl object);

    public abstract void put(VClientViewRowImpl object, Object value);

    public int index()
    {
      return AttributesEnum.firstIndex() + ordinal();
    }

    public static int firstIndex()
    {
      return firstIndex;
    }

    public static int count()
    {
      return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
    }

    public static AttributesEnum[] staticValues()
    {
      if (vals == null)
      {
        vals = AttributesEnum.values();
      }
      return vals;
    }
  }
  public static final int CLINO = AttributesEnum.Clino.index();
  public static final int CLIPRENOM = AttributesEnum.Cliprenom.index();
  public static final int CLINOM = AttributesEnum.Clinom.index();
  public static final int CLIRUE = AttributesEnum.Clirue.index();
  public static final int CLIVILLE = AttributesEnum.Cliville.index();
  public static final int CLITELEPHONE = AttributesEnum.Clitelephone.index();
  public static final int VCONTRATVIEW = AttributesEnum.VContratView.index();

  /**
   * This is the default constructor (do not remove).
   */
  public VClientViewRowImpl()
  {
  }

  /**
   * Gets VClient entity object.
   * @return the VClient
   */
  public VClientImpl getVClient()
  {
    return (VClientImpl) getEntity(ENTITY_VCLIENT);
  }

  /**
   * Gets the attribute value for CLINO using the alias name Clino.
   * @return the CLINO
   */
  public Integer getClino()
  {
    return (Integer) getAttributeInternal(CLINO);
  }

  /**
   * Sets <code>value</code> as attribute value for CLINO using the alias name Clino.
   * @param value value to set the CLINO
   */
  public void setClino(Integer value)
  {
    setAttributeInternal(CLINO, value);
  }

  /**
   * Gets the attribute value for CLIPRENOM using the alias name Cliprenom.
   * @return the CLIPRENOM
   */
  public String getCliprenom()
  {
    return (String) getAttributeInternal(CLIPRENOM);
  }

  /**
   * Sets <code>value</code> as attribute value for CLIPRENOM using the alias name Cliprenom.
   * @param value value to set the CLIPRENOM
   */
  public void setCliprenom(String value)
  {
    setAttributeInternal(CLIPRENOM, value);
  }

  /**
   * Gets the attribute value for CLINOM using the alias name Clinom.
   * @return the CLINOM
   */
  public String getClinom()
  {
    return (String) getAttributeInternal(CLINOM);
  }

  /**
   * Sets <code>value</code> as attribute value for CLINOM using the alias name Clinom.
   * @param value value to set the CLINOM
   */
  public void setClinom(String value)
  {
    setAttributeInternal(CLINOM, value);
  }

  /**
   * Gets the attribute value for CLIRUE using the alias name Clirue.
   * @return the CLIRUE
   */
  public String getClirue()
  {
    return (String) getAttributeInternal(CLIRUE);
  }

  /**
   * Sets <code>value</code> as attribute value for CLIRUE using the alias name Clirue.
   * @param value value to set the CLIRUE
   */
  public void setClirue(String value)
  {
    setAttributeInternal(CLIRUE, value);
  }

  /**
   * Gets the attribute value for CLIVILLE using the alias name Cliville.
   * @return the CLIVILLE
   */
  public String getCliville()
  {
    return (String) getAttributeInternal(CLIVILLE);
  }

  /**
   * Sets <code>value</code> as attribute value for CLIVILLE using the alias name Cliville.
   * @param value value to set the CLIVILLE
   */
  public void setCliville(String value)
  {
    setAttributeInternal(CLIVILLE, value);
  }

  /**
   * Gets the attribute value for CLITELEPHONE using the alias name Clitelephone.
   * @return the CLITELEPHONE
   */
  public String getClitelephone()
  {
    return (String) getAttributeInternal(CLITELEPHONE);
  }

  /**
   * Sets <code>value</code> as attribute value for CLITELEPHONE using the alias name Clitelephone.
   * @param value value to set the CLITELEPHONE
   */
  public void setClitelephone(String value)
  {
    setAttributeInternal(CLITELEPHONE, value);
  }

  /**
   * Gets the associated <code>RowIterator</code> using master-detail link VContratView.
   */
  public RowIterator getVContratView()
  {
    return (RowIterator) getAttributeInternal(VCONTRATVIEW);
  }

  /**
   * getAttrInvokeAccessor: generated method. Do not modify.
   * @param index the index identifying the attribute
   * @param attrDef the attribute

   * @return the attribute value
   * @throws Exception
   */
  protected Object getAttrInvokeAccessor(int index,
                                         AttributeDefImpl attrDef)
    throws Exception
  {
    if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count()))
    {
      return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
    }
    return super.getAttrInvokeAccessor(index, attrDef);
  }

  /**
   * setAttrInvokeAccessor: generated method. Do not modify.
   * @param index the index identifying the attribute
   * @param value the value to assign to the attribute
   * @param attrDef the attribute

   * @throws Exception
   */
  protected void setAttrInvokeAccessor(int index, Object value,
                                       AttributeDefImpl attrDef)
    throws Exception
  {
    if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count()))
    {
      AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
      return;
    }
    super.setAttrInvokeAccessor(index, value, attrDef);
  }
}