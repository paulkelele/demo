 <jsp:directive.include file="header.jsp" />

<% String nom = (String) request.getAttribute("nom");
 out.println(nom);
 %>
 <h1>Accueil</h1>
<div class="container">
    <div class="row">
        <div class="column">hello</div>
        <div class="column">how</div>
        <div class="column">lo</div>
    </div>
</div>

<jsp:directive.include file="footer.jsp" />