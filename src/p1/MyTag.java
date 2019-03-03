package p1;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class MyTag extends BodyTagSupport {
	private static final long serialVersionUID = 1L;
	
	private boolean putrs;
	
	public int doAfterBody() throws JspException {
		try {
			if(putrs == true) {
				String str = getBodyContent().getString();
				//str = str.toUpperCase();
				String fr = "";
				if(str.lastIndexOf(".") > 0) {
					fr = str.substring(str.indexOf("."),str.length());
				}
				int n = str.length();
				n -= str.length()-str.indexOf(".");
				StringBuilder inr = new StringBuilder();
				if(n>3) {
					inr.insert(0,str.substring(n-3, n));
					for(int i=n-4;i>=0;i-=2) {
						inr.insert(0,",");
						if(i>=1) 
							inr.insert(0,str.substring(i-1,i+1));
						else inr.insert(0,str.substring(i,i+1));
					
					}
				}
				//inr.reverse();
				if(fr != "") inr.append(fr);
				inr.append(" Rs.");
				JspWriter js = getBodyContent().getEnclosingWriter();
				js.println(inr.toString());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return super.doAfterBody();
	}

	public boolean isPutrs() {
		return putrs;
	}

	public void setPutrs(boolean putrs) {
		this.putrs = putrs;
	}
}
