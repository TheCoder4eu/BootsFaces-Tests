package net.bootsfaces.healthcheck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

public abstract class UITest {
	public abstract void test1(FacesContext context) throws Exception;

	public abstract void test2(FacesContext context) throws Exception;

	public abstract void test3(FacesContext context) throws Exception;

	public abstract void test4(FacesContext context) throws Exception;

	public abstract void test5(FacesContext context) throws Exception;

	public String check1() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			ResponseWriter old = context.getResponseWriter();
			ResponseWriter rw = new StringResponseWriter();
			FacesContext.getCurrentInstance().setResponseWriter(rw);
			test1(context);
			FacesContext.getCurrentInstance().setResponseWriter(old);
			String actual = rw.toString();
			if (actual == null) {
				return "component is renderd to null";
			}
			File expectedFile = new File(this.getClass().getName());

			if (expectedFile.exists()) {
				String expected = readFile(this.getClass().getName());
				if (actual.equals(expected)) {
					return "passed";
				} else {
					return "differences detected";
				}

			} else {
				return "no expected test results available";
			}
		} catch (Exception e) {
			return "not passed: " + e.getClass().getName() + " " + e.getMessage();
		}
	}

	public String check2() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			ResponseWriter old = context.getResponseWriter();
			ResponseWriter rw = new StringResponseWriter();
			FacesContext.getCurrentInstance().setResponseWriter(rw);
			test2(context);
			FacesContext.getCurrentInstance().setResponseWriter(old);
			System.out.println(rw.toString());
		} catch (Exception e) {
			return "not passed: " + e.getClass().getName() + " " + e.getMessage();
		}
		return "passed";
	}

	public String check3() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			ResponseWriter old = context.getResponseWriter();
			ResponseWriter rw = new StringResponseWriter();
			FacesContext.getCurrentInstance().setResponseWriter(rw);
			test3(context);
			FacesContext.getCurrentInstance().setResponseWriter(old);
			System.out.println(rw.toString());
		} catch (Exception e) {
			return "not passed: " + e.getClass().getName() + " " + e.getMessage();
		}
		return "passed";
	}

	public String check4() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			ResponseWriter old = context.getResponseWriter();
			ResponseWriter rw = new StringResponseWriter();
			FacesContext.getCurrentInstance().setResponseWriter(rw);
			test4(context);
			FacesContext.getCurrentInstance().setResponseWriter(old);
			System.out.println(rw.toString());
		} catch (Exception e) {
			return "not passed: " + e.getClass().getName() + " " + e.getMessage();
		}
		return "passed";
	}

	public String check5() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			ResponseWriter old = context.getResponseWriter();
			ResponseWriter rw = new StringResponseWriter();
			FacesContext.getCurrentInstance().setResponseWriter(rw);
			test5(context);
			FacesContext.getCurrentInstance().setResponseWriter(old);
			System.out.println(rw.toString());
		} catch (Exception e) {
			return "not passed: " + e.getClass().getName() + " " + e.getMessage();
		}
		return "passed";
	}

	public String readFile(String filename) {
		StringBuffer result = new StringBuffer();
		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("C:\\testing.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				if (result.length() > 0) {
					result.append("\n");
				}
				result.append(sCurrentLine);
			}
			return result.toString();

		} catch (IOException e) {
			return null;
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}
