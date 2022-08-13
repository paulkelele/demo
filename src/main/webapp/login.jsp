
 <jsp:directive.include file="header.jsp" />
 
 <div class="ml-1">
    <h1>Se connecter</h1>
    <form action="login" method="post">
        <input class="form-control" type="email" placeholder="Email" name="email" id="nom">
        <input class="form-control" type="password" placeholder="Mot de passe" name="password" id="password">
        <button class="btn" style="color:yellow;" type="submit">Se connecter</button>
    </form>
    <div style="color:red;">${messages.error}</div>
</div>

<jsp:directive.include file="footer.jsp" />
