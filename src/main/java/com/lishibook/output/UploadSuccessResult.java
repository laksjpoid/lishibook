package com.lishibook.output;

import java.util.List;

public class UploadSuccessResult extends UploadResult{
	
	private List<SuccessOutput> files;

	public List<SuccessOutput> getFiles() {
		return files;
	}

	public void setFiles(List<SuccessOutput> files) {
		this.files = files;
	}
	
}
