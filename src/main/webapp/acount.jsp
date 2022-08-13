<% 
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0"); 
if(session.getAttribute("s_id")== null){
	response.sendRedirect("login");
}
 %>
<jsp:directive.include file="header.jsp" />

<div class="ml-1">
 <h1>Welcome: ${s_id}</h1>
  

 <a href="logout.jsp">logout</a>
</div>
<jsp:directive.include file="footer.jsp" />