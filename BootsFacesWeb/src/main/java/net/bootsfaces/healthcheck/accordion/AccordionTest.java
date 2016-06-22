package net.bootsfaces.healthcheck.accordion;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.bean.ManagedBean;

import net.bootsfaces.healthcheck.StringResponseWriter;
import net.bootsfaces.healthcheck.UITest;
import net.bootsfaces.component.accordion.Accordion;
import net.bootsfaces.component.accordion.AccordionRenderer;

@ManagedBean
public class AccordionTest extends UITest {
	public void test1(FacesContext context) throws IOException {
		Accordion component = new Accordion();
		component.setOffset(6);
		component.setOffsetLg(9);
		component.setOffsetMd(9);
		component.setOffsetSm(9);
		component.setOffsetXs(9);
		component.setRendered(true);
		component.setTooltipDelay(13);
		component.setTooltipDelayHide(18);
		component.setTooltipDelayShow(18);
		new AccordionRenderer().encodeBegin(context, component);
		new AccordionRenderer().encodeChildren(context, component);
		new AccordionRenderer().encodeEnd(context, component);
	}
	public void test2(FacesContext context) throws IOException {
		Accordion component = new Accordion();
		new AccordionRenderer().encodeBegin(context, component);
		new AccordionRenderer().encodeChildren(context, component);
		new AccordionRenderer().encodeEnd(context, component);
	}
	public void test3(FacesContext context) throws IOException {
		// add your own implementation
	}
	public void test4(FacesContext context) throws IOException {
		// add your own implementation
	}
	public void test5(FacesContext context) throws IOException {
		// add your own implementation
	}
}
