package cn.totoro7.selfEditor;

import java.beans.PropertyEditorSupport;

/**
 * 功能：
 *
 * @author toroto
 * @date 2025/11/22/周六
 */
public class AddressPropertyEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String[] s = text.split("_");
		Address address = new Address();
		address.setProvince(s[0]);
		address.setCity(s[1]);
		address.setTown(s[2]);
		this.setValue(address);
	}
}
