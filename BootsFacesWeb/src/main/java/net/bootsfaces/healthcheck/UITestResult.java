package net.bootsfaces.healthcheck;

public class UITestResult {
	private String widget;

	private String result;

	private boolean isTestPresent;

	private boolean isTestResultPresent;

	private boolean hasPassed;

	public String getWidget() {
		return widget;
	}

	public void setWidget(String widget) {
		this.widget = widget;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean isTestPresent() {
		return isTestPresent;
	}

	public void setTestPresent(boolean isTestPresent) {
		this.isTestPresent = isTestPresent;
	}

	public boolean isTestResultPresent() {
		return isTestResultPresent;
	}

	public void setTestResultPresent(boolean isTestResultPresent) {
		this.isTestResultPresent = isTestResultPresent;
	}

	public boolean isHasPassed() {
		return hasPassed;
	}

	public void setHasPassed(boolean hasPassed) {
		this.hasPassed = hasPassed;
	}

}
