<% 
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0"); 
if(session.getAttribute("s_id")== null){
	response.sendRedirect("login");
}
 %>
 <%@page import="java.util.*,java.util.stream.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:directive.include file="header2.jsp" />

 
<div class="d-table col-12">
  <div class="col-4 d-table-cell border p-2">
<form action="settings" method="post">
	    <input class="form-control" type="text" name="pseudo" placeholder="Votre pseudo" id="pseudo">
		<button class="btn mt-1" style="color:yellow ;" type="submit">
			Enregistrer</button>
	   </form>  </div>
	<!--
  -->
	<div class="col-4 d-table-cell border p-2">
   		<form action="acount" method="post">
           <!-- <input class="form-control" type="text" name="comment" placeholder="comment" id="comment"> -->
			<textarea class="form-control" style="resize: none;"
			name="comment" placeholder="Commentaire.." rows="4" cols="50"></textarea>
		   <button class="btn mt-1" style="color:yellow ;" type="submit">
				Enregistrer</button>
        </form>
	   ....
	   <form action="test" method="post">
	    <input class="form-control" type="text" name="feel" placeholder="comment" id="prenom">
		<button class="btn mt-1" style="color:yellow ;" type="submit">
			Enregistrer</button>
	   </form>
	   <%
	   List<String> commentaire = (ArrayList<String>) session.getAttribute("commentaire");
	   if(null != commentaire){
		for(String com:commentaire){%>
			<div class="Box mt-2">
				<ul>
   				 <li class="Box-row">
					<%= com %>
					</li>
				</ul>
			</div>
			<%
		 }
	   }
		%>
		
		
  </div>
  <!--
  -->
  <div class="col-4 d-table-cell border p-2">
    Brisket tongue frankfurter cupim strip steak rump picanha pancetta pork pig kevin pastrami biltong. Shankle venison
    meatball swine sausage ground round. Tail pork loin ribeye kielbasa short ribs pork chop.
  </div>
</div>
<jsp:directive.include file="footer.jsp" />