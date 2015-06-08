package com.enablee.db.bo;

import java.util.Date;
import java.util.List;

/**
 * Recommendation is a shorten view of product that is sent as response from
 * recommendation engine. Recommendations are built out of product listing and
 * mapped against a user query and stored in system. Recommendation will expire
 * after some time. Initially to keep it simple expiration logic is not
 * included.
 * 
 * @author chetan
 * 
 */
public class Recommendation {
	private String title;
	private String description;
	private Float price;
	private Float mrp;
	private List<String> images;
	private Date startDate;
	private Date endDate;
}
