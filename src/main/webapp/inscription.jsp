<jsp:directive.include file="header.jsp" />

<div class="ml-3">
    <h1>Inscription</h1>
    <form action="inscription" method="post">
        <input class="form-control" type="email" placeholder="Email" name="email" id="nom">
        <input class="form-control" type="password" placeholder="Mot de passe" name="password" id="password">
        <input class="form-control" type="text" name="nom" placeholder="Nom" id="nom">
        <input class="form-control" type="text" name="prenom" placeholder="Prenom" id="prenom">
        <button class="btn" style="color:yellow ;" type="submit">S'inscrire</button>
    </form>
    <% if(request.getAttribute("email") !=null){ String nom=(String) request.getAttribute("email"); %>
        <div>
            <%= nom %>
        </div>
        <% } %>

</div>
<jsp:directive.include file="footer.jsp" />