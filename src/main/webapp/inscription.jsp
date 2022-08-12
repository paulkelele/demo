 <jsp:directive.include file="header.jsp" />

<h1>Inscription</h1>
<form action="inscription" method="post">
    <input type="email" name="email" id="nom">
    <input type="password" name="password" id="password">
    <button class="btn btn-primary" type="submit">Envoyer</button>
</form>
<% 
 
if(request.getAttribute("email") != null){
    String nom = (String) request.getAttribute("email");
    %>
<div><%= nom %></div>
 <%
}
 %>
 <jsp:directive.include file="footer.jsp" />