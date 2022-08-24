<% 
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0"); 
if(session.getAttribute("s_id")== null){
	response.sendRedirect("login");
}
 %>
 <%@page import="java.util.*" %>
 
<jsp:directive.include file="header2.jsp" />
 
 <div class="d-table col-12">
 <%-- premiere colonne --%>
  <div class="col-4 d-table-cell border p-2">
		<form action="settings" method="post">
			<span style="font-size:22px;vertical-align: bottom;">@</span>
	    	<input class="form-control" type="text" name="pseudo" placeholder="Votre pseudo" id="pseudo">
			<button class="btn mt-1" style="color:yellow ;" type="submit">
				Enregistrer</button>
	   	</form>
	   
		<form action="friend" method="post">
			<span style="font-size:22px;vertical-align: bottom;">@</span>
	    	<input class="form-control" type="text" name="friend" placeholder="Ajouter un ami" id="friend">
			<button class="btn mt-1" style="color:yellow ;" type="submit">
				Enregistrer</button>
	   	</form>
		<% 
		Map<String, String> messagesFromSettings = (Map)session.getAttribute("messagesFromSettings");
                if(messagesFromSettings != null){
                             if(messagesFromSettings.containsKey("error")){

                %>
                <div class="flash mt-3 flash-warn" style="width: fit-content;">
                    <svg class="octicon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16" height="16">
                        <path fill-rule="evenodd"
                            d="M4.47.22A.75.75 0 015 0h6a.75.75 0 01.53.22l4.25 4.25c.141.14.22.331.22.53v6a.75.75 0 01-.22.53l-4.25 4.25A.75.75 0 0111 16H5a.75.75 0 01-.53-.22L.22 11.53A.75.75 0 010 11V5a.75.75 0 01.22-.53L4.47.22zm.84 1.28L1.5 5.31v5.38l3.81 3.81h5.38l3.81-3.81V5.31L10.69 1.5H5.31zM8 4a.75.75 0 01.75.75v3.5a.75.75 0 01-1.5 0v-3.5A.75.75 0 018 4zm0 8a1 1 0 100-2 1 1 0 000 2z">
                        </path>
                    </svg>
                    ${messagesFromSettings.error}
                </div>
                <% } else{
                    %>
                        <div class="flash mt-3 flash-success" style="width: fit-content;">
                    <svg class="octicon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16" height="16">
                        <path fill-rule="evenodd"
                            d="M4.47.22A.75.75 0 015 0h6a.75.75 0 01.53.22l4.25 4.25c.141.14.22.331.22.53v6a.75.75 0 01-.22.53l-4.25 4.25A.75.75 0 0111 16H5a.75.75 0 01-.53-.22L.22 11.53A.75.75 0 010 11V5a.75.75 0 01.22-.53L4.47.22zm.84 1.28L1.5 5.31v5.38l3.81 3.81h5.38l3.81-3.81V5.31L10.69 1.5H5.31zM8 4a.75.75 0 01.75.75v3.5a.75.75 0 01-1.5 0v-3.5A.75.75 0 018 4zm0 8a1 1 0 100-2 1 1 0 000 2z">
                        </path>
                    </svg>
                    ${messagesFromSettings.ok}
                </div>
                    <%
                }
                } 
         %>
	  <%
	   List<String> friends = (ArrayList) session.getAttribute("listfriends");
	   if(null != friends){
		for(String friend:friends){%>
			<div class="Box mt-2">
				<ul>
   				 <li class="Box-row">
					<%= friend %>
					</li>
				</ul>
			</div>
			<%
		 }
	   }
		%>
	   	  
	</div>
	<!--MILIEU
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
	   List<String> commentaire = (ArrayList) session.getAttribute("commentaire");
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