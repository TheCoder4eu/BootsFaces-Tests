package net.bootsfaces.healthcheck;

import java.io.IOException;
import java.io.Writer;

import javax.faces.component.UIComponent;
import javax.faces.context.ResponseWriter;

public class StringResponseWriter extends ResponseWriter {
	private StringBuffer buffer = new StringBuffer();

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public String getCharacterEncoding() {
		return null;
	}

	@Override
	public void flush() throws IOException {

	}

	@Override
	public void startDocument() throws IOException {

	}

	@Override
	public void endDocument() throws IOException {
	}

	@Override
	public void startElement(String name, UIComponent component) throws IOException {
		buffer.append('<');
		buffer.append(name);
		buffer.append('>');
	}

	@Override
	public void endElement(String name) throws IOException {
		buffer.append("<");
		buffer.append(name);
		buffer.append('>');
	}

	@Override
	public void writeAttribute(String name, Object value, String property) throws IOException {
		buffer.append(' ');
		buffer.append(name);
		buffer.append('=');
		buffer.append(value);
	}

	@Override
	public void writeURIAttribute(String name, Object value, String property) throws IOException {
		buffer.append(' ');
		buffer.append(name);
		buffer.append('=');
		buffer.append(value);
	}

	@Override
	public void writeComment(Object comment) throws IOException {
		buffer.append("<!-- ");
		buffer.append(comment);
		buffer.append(" -->");

	}

	@Override
	public void writeText(Object text, String property) throws IOException {
		buffer.append(text);
	}

	@Override
	public void writeText(char[] text, int off, int len) throws IOException {
		buffer.append(text);
	}

	@Override
	public ResponseWriter cloneWithWriter(Writer writer) {
		return this;
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		buffer.append(cbuf, off, len);
	}

	@Override
	public void close() throws IOException {
	}

	public String toString() {
		return buffer.toString();
	}
}
