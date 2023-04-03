package com.yedam.API;

public class PortableNotebook implements Notebook, Tablet {
	
	private int mode;
	
	@Override
	public void watchVideo() {
		System.out.println("'영상종류'를 시청");
	}

	@Override
	public void useApp() {
		if(mode == 1) {
			mode = 2;
			System.out.println("'앱종류'를 실행");
		}else {
			System.out.println("'앱종류'를 실행");
		}
	}

	@Override
	public void writeDocumentaion() {
		System.out.println("'문서 프로그램'을 통해 문서를 작성");
	}

	@Override
	public void searchInternet() {
		System.out.println("'인터넷 브라우저'를 통해 인터넷을 검색");
	}

	@Override
	public void changeMode(int mode) {
		if(mode == 1) {
			System.out.println("NOTEBOOK_MODE");
		}else {
			System.out.println("TABLET_MODE");
		}
	}
	
}
