/*******************************************************************************
 * Copyright (c) 2008, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     
 *******************************************************************************/
package org.eclipse.angularjs.internal.ui.preferences.html;

import org.eclipse.angularjs.internal.ui.AngularUIMessages;
import org.eclipse.angularjs.internal.ui.AngularUIPlugin;
import org.eclipse.angularjs.internal.ui.preferences.AngularUIPreferenceNames;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.wst.sse.ui.internal.preferences.ui.AbstractPreferencePage;
import org.eclipse.wst.xml.ui.internal.XMLUIMessages;

public class HTMLAngularTypingPreferencePage extends AbstractPreferencePage {

	private Button fCloseEndEL;

	protected Control createContents(Composite parent) {
		Composite composite = super.createComposite(parent, 1);

		createEndELGroup(composite);

		setSize(composite);
		loadPreferences();

		return composite;
	}

	private void createEndELGroup(Composite parent) {
		Group group = createGroup(parent, 2);

		group.setText(AngularUIMessages.AngularTyping_Auto_Complete);

		fCloseEndEL = createCheckBox(group,
				AngularUIMessages.AngularTyping_Close_EL);
		((GridData) fCloseEndEL.getLayoutData()).horizontalSpan = 2;
	}

	public boolean performOk() {
		boolean result = super.performOk();

		AngularUIPlugin.getDefault().savePluginPreferences();

		return result;
	}

	protected void initializeValues() {
		initCheckbox(fCloseEndEL,
				AngularUIPreferenceNames.TYPING_COMPLETE_END_EL);
	}

	protected void performDefaults() {
		defaultCheckbox(fCloseEndEL,
				AngularUIPreferenceNames.TYPING_COMPLETE_END_EL);
	}

	protected void storeValues() {
		getPreferenceStore().setValue(
				AngularUIPreferenceNames.TYPING_COMPLETE_END_EL,
				(fCloseEndEL != null) ? fCloseEndEL.getSelection() : false);
	}

	protected IPreferenceStore doGetPreferenceStore() {
		return AngularUIPlugin.getDefault().getPreferenceStore();
	}

}
