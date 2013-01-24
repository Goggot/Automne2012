package model.views;

import java.math.BigDecimal;

import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Timestamp;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jan 18 12:37:39 EST 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SEmpViewRowImpl
  extends ViewRowImpl
{


  public static final int ENTITY_SEMP = 0;

  /**
   * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
   */
  public enum AttributesEnum
  {
    Id
    {
      public Object get(SEmpViewRowImpl obj)
      {
        return obj.getId();
      }

      public void put(SEmpViewRowImpl obj, Object value)
      {
        obj.setId((Integer)value);
      }
    }
    ,
    LastName
    {
      public Object get(SEmpViewRowImpl obj)
      {
        return obj.getLastName();
      }

      public void put(SEmpViewRowImpl obj, Object value)
      {
        obj.setLastName((String)value);
      }
    }
    ,
    FirstName
    {
      public Object get(SEmpViewRowImpl obj)
      {
        return obj.getFirstName();
      }

      public void put(SEmpViewRowImpl obj, Object value)
      {
        obj.setFirstName((String)value);
      }
    }
    ,
    Userid
    {
      public Object get(SEmpViewRowImpl obj)
      {
        return obj.getUserid();
      }

      public void put(SEmpViewRowImpl obj, Object value)
      {
        obj.setUserid((String)value);
      }
    }
    ,
    StartDate
    {
      public Object get(SEmpViewRowImpl obj)
      {
        return obj.getStartDate();
      }

      public void put(SEmpViewRowImpl obj, Object value)
      {
        obj.setStartDate((Timestamp)value);
      }
    }
    ,
    Comments
    {
      public Object get(SEmpViewRowImpl obj)
      {
        return obj.getComments();
      }

      public void put(SEmpViewRowImpl obj, Object value)
      {
        obj.setComments((String)value);
      }
    }
    ,
    ManagerId
    {
      public Object get(SEmpViewRowImpl obj)
      {
        return obj.getManagerId();
      }

      public void put(SEmpViewRowImpl obj, Object value)
      {
        obj.setManagerId((Integer)value);
      }
    }
    ,
    Title
    {
      public Object get(SEmpViewRowImpl obj)
      {
        return obj.getTitle();
      }

      public void put(SEmpViewRowImpl obj, Object value)
      {
        obj.setTitle((String)value);
      }
    }
    ,
    DeptId
    {
      public Object get(SEmpViewRowImpl obj)
      {
        return obj.getDeptId();
      }

      public void put(SEmpViewRowImpl obj, Object value)
      {
        obj.setDeptId((Integer)value);
      }
    }
    ,
    Salary
    {
      public Object get(SEmpViewRowImpl obj)
      {
        return obj.getSalary();
      }

      public void put(SEmpViewRowImpl obj, Object value)
      {
        obj.setSalary((BigDecimal)value);
      }
    }
    ,
    CommissionPct
    {
      public Object get(SEmpViewRowImpl obj)
      {
        return obj.getCommissionPct();
      }

      public void put(SEmpViewRowImpl obj, Object value)
      {
        obj.setCommissionPct((BigDecimal)value);
      }
    }
    ,
    NvSal
    {
      public Object get(SEmpViewRowImpl obj)
      {
        return obj.getNvSal();
      }

      public void put(SEmpViewRowImpl obj, Object value)
      {
        obj.setNvSal((Number)value);
      }
    }
    ,
    SommeCommande
    {
      public Object get(SEmpViewRowImpl obj)
      {
        return obj.getSommeCommande();
      }

      public void put(SEmpViewRowImpl obj, Object value)
      {
        obj.setSommeCommande((Number)value);
      }
    }
    ,
    Nom
    {
      public Object get(SEmpViewRowImpl obj)
      {
        return obj.getNom();
      }

      public void put(SEmpViewRowImpl obj, Object value)
      {
        obj.setNom((String)value);
      }
    }
    ,
    TotalDesSal
    {
      public Object get(SEmpViewRowImpl obj)
      {
        return obj.getTotalDesSal();
      }

      public void put(SEmpViewRowImpl obj, Object value)
      {
        obj.setTotalDesSal((Number)value);
      }
    }
    ,
    TotalDept
    {
      public Object get(SEmpViewRowImpl obj)
      {
        return obj.getTotalDept();
      }

      public void put(SEmpViewRowImpl obj, Object value)
      {
        obj.setTotalDept((Number)value);
      }
    }
    ,
    SEmpView
    {
      public Object get(SEmpViewRowImpl obj)
      {
        return obj.getSEmpView();
      }

      public void put(SEmpViewRowImpl obj, Object value)
      {
        obj.setAttributeInternal(index(), value);
      }
    }
    ,
    SDeptView1
    {
      public Object get(SEmpViewRowImpl obj)
      {
        return obj.getSDeptView1();
      }

      public void put(SEmpViewRowImpl obj, Object value)
      {
        obj.setAttributeInternal(index(), value);
      }
    }
    ,
    SDeptView
    {
      public Object get(SEmpViewRowImpl obj)
      {
        return obj.getSDeptView();
      }

      public void put(SEmpViewRowImpl obj, Object value)
      {
        obj.setAttributeInternal(index(), value);
      }
    }
    ;
    private static AttributesEnum[] vals = null;
    private static int firstIndex = 0;

    public abstract Object get(SEmpViewRowImpl object);

    public abstract void put(SEmpViewRowImpl object, Object value);

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


  public static final int ID = AttributesEnum.Id.index();
  public static final int LASTNAME = AttributesEnum.LastName.index();
  public static final int FIRSTNAME = AttributesEnum.FirstName.index();
  public static final int USERID = AttributesEnum.Userid.index();
  public static final int STARTDATE = AttributesEnum.StartDate.index();
  public static final int COMMENTS = AttributesEnum.Comments.index();
  public static final int MANAGERID = AttributesEnum.ManagerId.index();
  public static final int TITLE = AttributesEnum.Title.index();
  public static final int DEPTID = AttributesEnum.DeptId.index();
  public static final int SALARY = AttributesEnum.Salary.index();
  public static final int COMMISSIONPCT = AttributesEnum.CommissionPct.index();
  public static final int NVSAL = AttributesEnum.NvSal.index();
  public static final int SOMMECOMMANDE = AttributesEnum.SommeCommande.index();
  public static final int NOM = AttributesEnum.Nom.index();
  public static final int TOTALDESSAL = AttributesEnum.TotalDesSal.index();
  public static final int TOTALDEPT = AttributesEnum.TotalDept.index();
  public static final int SEMPVIEW = AttributesEnum.SEmpView.index();
  public static final int SDEPTVIEW1 = AttributesEnum.SDeptView1.index();
  public static final int SDEPTVIEW = AttributesEnum.SDeptView.index();

  /**
   * This is the default constructor (do not remove).
   */
  public SEmpViewRowImpl()
  {
  }

  /**
   * Gets SEmp entity object.
   * @return the SEmp
   */
  public EntityImpl getSEmp()
  {
    return (EntityImpl) getEntity(ENTITY_SEMP);
  }

  /**
   * Gets the attribute value for ID using the alias name Id.
   * @return the ID
   */
  public Integer getId()
  {
    return (Integer) getAttributeInternal(ID);
  }

  /**
   * Sets <code>value</code> as attribute value for ID using the alias name Id.
   * @param value value to set the ID
   */
  public void setId(Integer value)
  {
    setAttributeInternal(ID, value);
  }

  /**
   * Gets the attribute value for LAST_NAME using the alias name LastName.
   * @return the LAST_NAME
   */
  public String getLastName()
  {
    return (String) getAttributeInternal(LASTNAME);
  }

  /**
   * Sets <code>value</code> as attribute value for LAST_NAME using the alias name LastName.
   * @param value value to set the LAST_NAME
   */
  public void setLastName(String value)
  {
    setAttributeInternal(LASTNAME, value);
  }

  /**
   * Gets the attribute value for FIRST_NAME using the alias name FirstName.
   * @return the FIRST_NAME
   */
  public String getFirstName()
  {
    return (String) getAttributeInternal(FIRSTNAME);
  }

  /**
   * Sets <code>value</code> as attribute value for FIRST_NAME using the alias name FirstName.
   * @param value value to set the FIRST_NAME
   */
  public void setFirstName(String value)
  {
    setAttributeInternal(FIRSTNAME, value);
  }

  /**
   * Gets the attribute value for USERID using the alias name Userid.
   * @return the USERID
   */
  public String getUserid()
  {
    return (String) getAttributeInternal(USERID);
  }

  /**
   * Sets <code>value</code> as attribute value for USERID using the alias name Userid.
   * @param value value to set the USERID
   */
  public void setUserid(String value)
  {
    setAttributeInternal(USERID, value);
  }

  /**
   * Gets the attribute value for START_DATE using the alias name StartDate.
   * @return the START_DATE
   */
  public Timestamp getStartDate()
  {
    return (Timestamp) getAttributeInternal(STARTDATE);
  }

  /**
   * Sets <code>value</code> as attribute value for START_DATE using the alias name StartDate.
   * @param value value to set the START_DATE
   */
  public void setStartDate(Timestamp value)
  {
    setAttributeInternal(STARTDATE, value);
  }

  /**
   * Gets the attribute value for COMMENTS using the alias name Comments.
   * @return the COMMENTS
   */
  public String getComments()
  {
    return (String) getAttributeInternal(COMMENTS);
  }

  /**
   * Sets <code>value</code> as attribute value for COMMENTS using the alias name Comments.
   * @param value value to set the COMMENTS
   */
  public void setComments(String value)
  {
    setAttributeInternal(COMMENTS, value);
  }

  /**
   * Gets the attribute value for MANAGER_ID using the alias name ManagerId.
   * @return the MANAGER_ID
   */
  public Integer getManagerId()
  {
    return (Integer) getAttributeInternal(MANAGERID);
  }

  /**
   * Sets <code>value</code> as attribute value for MANAGER_ID using the alias name ManagerId.
   * @param value value to set the MANAGER_ID
   */
  public void setManagerId(Integer value)
  {
    setAttributeInternal(MANAGERID, value);
  }

  /**
   * Gets the attribute value for TITLE using the alias name Title.
   * @return the TITLE
   */
  public String getTitle()
  {
    return (String) getAttributeInternal(TITLE);
  }

  /**
   * Sets <code>value</code> as attribute value for TITLE using the alias name Title.
   * @param value value to set the TITLE
   */
  public void setTitle(String value)
  {
    setAttributeInternal(TITLE, value);
  }

  /**
   * Gets the attribute value for DEPT_ID using the alias name DeptId.
   * @return the DEPT_ID
   */
  public Integer getDeptId()
  {
    return (Integer) getAttributeInternal(DEPTID);
  }

  /**
   * Sets <code>value</code> as attribute value for DEPT_ID using the alias name DeptId.
   * @param value value to set the DEPT_ID
   */
  public void setDeptId(Integer value)
  {
    setAttributeInternal(DEPTID, value);
  }

  /**
   * Gets the attribute value for SALARY using the alias name Salary.
   * @return the SALARY
   */
  public BigDecimal getSalary()
  {
    return (BigDecimal) getAttributeInternal(SALARY);
  }

  /**
   * Sets <code>value</code> as attribute value for SALARY using the alias name Salary.
   * @param value value to set the SALARY
   */
  public void setSalary(BigDecimal value)
  {
    setAttributeInternal(SALARY, value);
  }

  /**
   * Gets the attribute value for COMMISSION_PCT using the alias name CommissionPct.
   * @return the COMMISSION_PCT
   */
  public BigDecimal getCommissionPct()
  {
    return (BigDecimal) getAttributeInternal(COMMISSIONPCT);
  }

  /**
   * Sets <code>value</code> as attribute value for COMMISSION_PCT using the alias name CommissionPct.
   * @param value value to set the COMMISSION_PCT
   */
  public void setCommissionPct(BigDecimal value)
  {
    setAttributeInternal(COMMISSIONPCT, value);
  }

  /**
   * Gets the attribute value for the calculated attribute NvSal.
   * @return the NvSal
   */
  public Number getNvSal()
  {
    return (Number) getAttributeInternal(NVSAL);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute NvSal.
   * @param value value to set the  NvSal
   */
  public void setNvSal(Number value)
  {
    setAttributeInternal(NVSAL, value);
  }

  /**
   * Gets the attribute value for the calculated attribute SommeCommande.
   * @return the SommeCommande
   */
  public Number getSommeCommande()
  {
    return (Number) getAttributeInternal(SOMMECOMMANDE);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute SommeCommande.
   * @param value value to set the  SommeCommande
   */
  public void setSommeCommande(Number value)
  {
    setAttributeInternal(SOMMECOMMANDE, value);
  }

  /**
   * Gets the attribute value for the calculated attribute Nom.
   * @return the Nom
   */
  public String getNom()
  {
    return (String) getAttributeInternal(NOM);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute Nom.
   * @param value value to set the  Nom
   */
  public void setNom(String value)
  {
    setAttributeInternal(NOM, value);
  }

  /**
   * Gets the attribute value for the calculated attribute TotalDesSal.
   * @return the TotalDesSal
   */
  public Number getTotalDesSal()
  {
    return (Number) getAttributeInternal(TOTALDESSAL);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute TotalDesSal.
   * @param value value to set the  TotalDesSal
   */
  public void setTotalDesSal(Number value)
  {
    setAttributeInternal(TOTALDESSAL, value);
  }

  /**
   * Gets the attribute value for the calculated attribute TotalDept.
   * @return the TotalDept
   */
  public Number getTotalDept()
  {
    return (Number) getAttributeInternal(TOTALDEPT);
  }

  /**
   * Sets <code>value</code> as the attribute value for the calculated attribute TotalDept.
   * @param value value to set the  TotalDept
   */
  public void setTotalDept(Number value)
  {
    setAttributeInternal(TOTALDEPT, value);
  }

  /**
   * Gets the associated <code>RowIterator</code> using master-detail link SEmpView.
   */
  public RowIterator getSEmpView()
  {
    return (RowIterator) getAttributeInternal(SEMPVIEW);
  }


  /**
   * Gets the associated <code>Row</code> using master-detail link SDeptView1.
   */
  public Row getSDeptView1()
  {
    return (Row) getAttributeInternal(SDEPTVIEW1);
  }

  /**
   * Sets the master-detail link SDeptView1 between this object and <code>value</code>.
   */
  public void setSDeptView1(Row value)
  {
    setAttributeInternal(SDEPTVIEW1, value);
  }

  /**
   * Gets the associated <code>RowIterator</code> using master-detail link SDeptView.
   */
  public RowIterator getSDeptView()
  {
    return (RowIterator) getAttributeInternal(SDEPTVIEW);
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