/**
 *  Copyright (c) 2014 Angelo ZERR.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 * 		Victor Rubezhny - initial API and implementation
 */
package org.eclipse.angularjs.internal.ui;

import org.eclipse.ui.IStartup;

/**
 * Need this to make AngularNatureTester work from early start
 * 
 * @author Victor Rubezhny
 */
public class AngularUIStartup implements IStartup {

	@Override
	public void earlyStartup() {
		// Nothing really to do here, but need this to make AngularNatureTester work from early start
	}

}