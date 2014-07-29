package com;

import javax.faces.bean.*;

@ManagedBean
public class Navigator {
	public String choosePage() {
		if (Math.random() > 0.5) {
			return ("result-page-1");
		} else {
			return ("result-page-2");
		}
	}
}