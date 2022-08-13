<jsp:directive.include file="header.jsp" />

<div class="ml-3">
    <h3>Cr&eacute;ation de votre compte</h3>
    <form action="inscription" method="post">
        <input class="form-control" type="email" placeholder="Email" name="email" id="nom">
        <input class="form-control" type="password" placeholder="Mot de passe" name="password" id="password">
        <input class="form-control" type="text" name="nom" placeholder="Nom" id="nom">
        <input class="form-control" type="text" name="prenom" placeholder="Prenom" id="prenom">
        <button class="btn" style="color:yellow ;" type="submit">Je cr&eacute;e mon compte</button>
    </form>
   

</div>
<jsp:directive.include file="footer.jsp" />