<% 
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0"); 
if(session.getAttribute("s_id")== null){
	response.sendRedirect("login");
}
 %>
<jsp:directive.include file="header2.jsp" />

<div class="ml-1">
 <h1>Welcome</h1>
  
 
</div>
<jsp:directive.include file="footer.jsp" />