<%@page import="java.util.*"%>
<jsp:directive.include file="header.jsp" />
 <jsp:directive.page session="false" />

<div class="ml-3">
	<h3>Se connecter</h3>
	<form action="login" method="post">
		<input class="form-control" type="email" placeholder="Email"
			name="email" id="nom"> <input class="form-control"
			type="password" placeholder="Mot de passe" name="password"
			id="password">
		<button class="btn" style="color: yellow;" type="submit">Se
			connecter</button>
	</form>
	<%
	Map<String, String> messages =  (Map)request.getAttribute("messages");
	if (messages != null) {
	%>
	<div class="flash mt-3 flash-warn" style="width: fit-content;">
		<svg class="octicon" xmlns="http://www.w3.org/2000/svg"
			viewBox="0 0 16 16" width="16" height="16">
			<path fill-rule="evenodd"
				d="M4.47.22A.75.75 0 015 0h6a.75.75 0 01.53.22l4.25 4.25c.141.14.22.331.22.53v6a.75.75 0 01-.22.53l-4.25 4.25A.75.75 0 0111 16H5a.75.75 0 01-.53-.22L.22 11.53A.75.75 0 010 11V5a.75.75 0 01.22-.53L4.47.22zm.84 1.28L1.5 5.31v5.38l3.81 3.81h5.38l3.81-3.81V5.31L10.69 1.5H5.31zM8 4a.75.75 0 01.75.75v3.5a.75.75 0 01-1.5 0v-3.5A.75.75 0 018 4zm0 8a1 1 0 100-2 1 1 0 000 2z"></path></svg>
		${messages.error}
	</div>
	<%
	}
	%>



</div>

<jsp:directive.include file="footer.jsp" />
