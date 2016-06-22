package net.bootsfaces.healthcheck;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import net.bootsfaces.component.ComponentsEnum;
import net.bootsfaces.utils.FacesMessages;

@RequestScoped
@ManagedBean
public class UITestSuite {
	private List<UITestResult> results = new ArrayList<>();
	public List<UITestResult> getResults() {
		if (results.isEmpty()) {
			ComponentsEnum[] widgets = ComponentsEnum.values();
			for (ComponentsEnum widget: widgets) {
				UITestResult result = new UITestResult();
				results.add(result);
				result.setWidget(widget.name());
				String clazz = widget.name();
				String testClass = "net.bootsfaces.healthcheck." + toFirstLowercase(clazz) + "." + toFirstUppercase(clazz) + "Test";
				try {
					Class<?> widgetTestClass = Class.forName(testClass);
					UITest widgetTest = (UITest)widgetTestClass.newInstance();
					result.setResult("test available");
					String test1 = widgetTest.check1();
					result.setHasPassed("passed".equals(test1));
					result.setResult(test1);

				} catch (ReflectiveOperationException notThere) {
					result.setResult("test missing");
				}
			}
		}
		return results;
	}
	private String toFirstLowercase(String s) {
		return s.substring(0, 1).toLowerCase() + s.substring(1);
	}
	private String toFirstUppercase(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	public void record(UITestResult test) {
		FacesMessages.info("Todo");
	}
}
