package net.bootsfaces.healthcheck.image;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import net.bootsfaces.component.image.Image;
import net.bootsfaces.component.image.ImageRenderer;
import net.bootsfaces.healthcheck.StringResponseWriter;

@ManagedBean
public class ImageTest {
	public void testImage(FacesContext context) throws IOException {
		Image image = new Image();
		image.setValue("123");
		new ImageRenderer().encodeBegin(context, image);
		new ImageRenderer().encodeChildren(context, image);
		new ImageRenderer().encodeEnd(context, image);
	}

	public String check() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			ResponseWriter rw = new StringResponseWriter();
			FacesContext.getCurrentInstance().setResponseWriter(rw);
			testImage(context);
			System.out.println(rw.toString());
		} catch (Exception e) {
			return "not passed: " + e.getClass().getName() + " " + e.getMessage();
		}
		return "passed";
	}
}
