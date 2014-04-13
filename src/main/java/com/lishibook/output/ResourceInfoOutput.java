package com.lishibook.output;

/**
 * 资源的基本信息
 * @author mengtao
 *
 */
public class ResourceInfoOutput {
	
	private int id;
	
	private String name;

    private String iconurl;
    
    private String description;
    
    private int views;
    
    private boolean isfocus;//是否被当前资源关注

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIconurl() {
		return iconurl;
	}

	public void setIconurl(String iconurl) {
		this.iconurl = iconurl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public boolean isIsfocus() {
		return isfocus;
	}

	public void setIsfocus(boolean isfocus) {
		this.isfocus = isfocus;
	}
    
    
}
