package model.entities;

import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Dec 12 15:00:01 EST 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class VClientImpl
  extends EntityImpl
{
  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
   */
  public enum AttributesEnum
  {
    Clino
    {
      public Object get(VClientImpl obj)
      {
        return obj.getClino();
      }

      public void put(VClientImpl obj, Object value)
      {
        obj.setClino((Integer)value);
      }
    }
    ,
    Cliprenom
    {
      public Object get(VClientImpl obj)
      {
        return obj.getCliprenom();
      }

      public void put(VClientImpl obj, Object value)
      {
        obj.setCliprenom((String)value);
      }
    }
    ,
    Clinom
    {
      public Object get(VClientImpl obj)
      {
        return obj.getClinom();
      }

      public void put(VClientImpl obj, Object value)
      {
        obj.setClinom((String)value);
      }
    }
    ,
    Clirue
    {
      public Object get(VClientImpl obj)
      {
        return obj.getClirue();
      }

      public void put(VClientImpl obj, Object value)
      {
        obj.setClirue((String)value);
      }
    }
    ,
    Cliville
    {
      public Object get(VClientImpl obj)
      {
        return obj.getCliville();
      }

      public void put(VClientImpl obj, Object value)
      {
        obj.setCliville((String)value);
      }
    }
    ,
    Clitelephone
    {
      public Object get(VClientImpl obj)
      {
        return obj.getClitelephone();
      }

      public void put(VClientImpl obj, Object value)
      {
        obj.setClitelephone((String)value);
      }
    }
    ,
    VContrat
    {
      public Object get(VClientImpl obj)
      {
        return obj.getVContrat();
      }

      public void put(VClientImpl obj, Object value)
      {
        obj.setAttributeInternal(index(), value);
      }
    }
    ;
    private static AttributesEnum[] vals = null;
    private static int firstIndex = 0;

    public abstract Object get(VClientImpl object);

    public abstract void put(VClientImpl object, Object value);

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
  public static final int VCONTRAT = AttributesEnum.VContrat.index();

  /**
   * This is the default constructor (do not remove).
   */
  public VClientImpl()
  {
  }

  /**
   * Gets the attribute value for Clino, using the alias name Clino.
   * @return the value of Clino
   */
  public Integer getClino()
  {
    return (Integer)getAttributeInternal(CLINO);
  }

  /**
   * Sets <code>value</code> as the attribute value for Clino.
   * @param value value to set the Clino
   */
  public void setClino(Integer value)
  {
    setAttributeInternal(CLINO, value);
  }

  /**
   * Gets the attribute value for Cliprenom, using the alias name Cliprenom.
   * @return the value of Cliprenom
   */
  public String getCliprenom()
  {
    return (String)getAttributeInternal(CLIPRENOM);
  }

  /**
   * Sets <code>value</code> as the attribute value for Cliprenom.
   * @param value value to set the Cliprenom
   */
  public void setCliprenom(String value)
  {
    setAttributeInternal(CLIPRENOM, value);
  }

  /**
   * Gets the attribute value for Clinom, using the alias name Clinom.
   * @return the value of Clinom
   */
  public String getClinom()
  {
    return (String)getAttributeInternal(CLINOM);
  }

  /**
   * Sets <code>value</code> as the attribute value for Clinom.
   * @param value value to set the Clinom
   */
  public void setClinom(String value)
  {
    setAttributeInternal(CLINOM, value);
  }

  /**
   * Gets the attribute value for Clirue, using the alias name Clirue.
   * @return the value of Clirue
   */
  public String getClirue()
  {
    return (String)getAttributeInternal(CLIRUE);
  }

  /**
   * Sets <code>value</code> as the attribute value for Clirue.
   * @param value value to set the Clirue
   */
  public void setClirue(String value)
  {
    setAttributeInternal(CLIRUE, value);
  }

  /**
   * Gets the attribute value for Cliville, using the alias name Cliville.
   * @return the value of Cliville
   */
  public String getCliville()
  {
    return (String)getAttributeInternal(CLIVILLE);
  }

  /**
   * Sets <code>value</code> as the attribute value for Cliville.
   * @param value value to set the Cliville
   */
  public void setCliville(String value)
  {
    setAttributeInternal(CLIVILLE, value);
  }

  /**
   * Gets the attribute value for Clitelephone, using the alias name Clitelephone.
   * @return the value of Clitelephone
   */
  public String getClitelephone()
  {
    return (String)getAttributeInternal(CLITELEPHONE);
  }

  /**
   * Sets <code>value</code> as the attribute value for Clitelephone.
   * @param value value to set the Clitelephone
   */
  public void setClitelephone(String value)
  {
    setAttributeInternal(CLITELEPHONE, value);
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

  /**
   * @return the associated entity oracle.jbo.RowIterator.
   */
  public RowIterator getVContrat()
  {
    return (RowIterator) getAttributeInternal(VCONTRAT);
  }

  /**
   * @param clino key constituent

   * @return a Key object based on given key constituents.
   */
  public static Key createPrimaryKey(Integer clino)
  {
    return new Key(new Object[]{clino});
  }

  /**
   * @return the definition object for this instance class.
   */
  public static synchronized EntityDefImpl getDefinitionObject()
  {
    return EntityDefImpl.findDefObject("model.entities.VClient");
  }
}
