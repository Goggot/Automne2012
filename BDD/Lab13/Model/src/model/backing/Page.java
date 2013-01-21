package model.backing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.fragment.RichPageTemplate;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.output.RichMessages;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;

@ManagedBean(name="backing_page")
@RequestScoped
public class Page
{
  private RichPageTemplate pt1;
  private RichForm f1;
  private RichDocument d1;
  private RichMessages m1;
  private RichPanelFormLayout pfl1;
  private RichPanelCollection pc1;
  private RichTable t1;

  public void setPt1(RichPageTemplate pt1)
  {
    this.pt1 = pt1;
  }

  public RichPageTemplate getPt1()
  {
    return pt1;
  }

  public void setF1(RichForm f1)
  {
    this.f1 = f1;
  }

  public RichForm getF1()
  {
    return f1;
  }

  public void setD1(RichDocument d1)
  {
    this.d1 = d1;
  }

  public RichDocument getD1()
  {
    return d1;
  }

  public void setM1(RichMessages m1)
  {
    this.m1 = m1;
  }

  public RichMessages getM1()
  {
    return m1;
  }

  public void setPfl1(RichPanelFormLayout pfl1)
  {
    this.pfl1 = pfl1;
  }

  public RichPanelFormLayout getPfl1()
  {
    return pfl1;
  }


  public void setPc1(RichPanelCollection pc1)
  {
    this.pc1 = pc1;
  }

  public RichPanelCollection getPc1()
  {
    return pc1;
  }

  public void setT1(RichTable t1)
  {
    this.t1 = t1;
  }

  public RichTable getT1()
  {
    return t1;
  }


}
