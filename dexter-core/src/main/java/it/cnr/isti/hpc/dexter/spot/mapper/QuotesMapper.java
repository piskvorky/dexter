/**
 *  Copyright 2012 Diego Ceccarelli
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package it.cnr.isti.hpc.dexter.spot.mapper;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * QuotesMapper.java add text between quotes that appears in the labels 
 * and text appearing outsite
 * the labels (e.g. dave "baby" cortez -> baby, dave cortez) 
 *
 * @author Diego Ceccarelli, diego.ceccarelli@isti.cnr.it
 * created on 20/lug/2012
 */
public class QuotesMapper implements Mapper {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(QuotesMapper.class);

	String pattern = "^([^\"]*)[\"]([^\"]+)[\"]([^\"]+)$";

	Pattern regex = Pattern.compile(pattern);
	
	
	public Set<String> mapper(String spot) {
		Set<String> mappings = new HashSet<String>();
		Matcher m = regex.matcher(spot);
		if (m.find()){
			String p0 = m.group(1)+" "+m.group(3);
			mappings.add(p0);
			
			String p1= m.group(2);
			mappings.add(p1);
			logger.debug("adding {} ",p0);
			logger.debug("adding {} ",p1);
		}
		
		return mappings;
		
	}
	

	

}