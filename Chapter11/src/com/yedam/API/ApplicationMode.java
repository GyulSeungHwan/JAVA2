package com.yedam.API;

public class ApplicationMode {
	public static void main(String[] args) {
		PortableNotebook pn = new PortableNotebook();
		
		pn.changeMode(1);
		pn.writeDocumentaion();
		pn.watchVideo();
		pn.changeMode(2);
		pn.useApp();
		pn.searchInternet();
		
	}
}
