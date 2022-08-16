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
 <h4>Votre espace personnel</h4>
 <div class="d-table col-12">
	<div class="col-4 d-table-cell   p-2">
	  Bacon ipsum dolor amet leberkas pork pig kielbasa shankle ribeye meatball, salami alcatra venison.
	</div>
	<!--
	-->
	<div class="col-4 d-table-cell   p-2">
		<form action="acount" method="post">
           <!-- <input class="form-control" type="text" name="comment" placeholder="comment" id="prenom"> -->
			<textarea class="form-control" style="resize: none;"
			name="comment" placeholder="Commentaire.." rows="4" cols="50"></textarea>
		   <button class="btn mt-1" style="color:yellow ;" type="submit">
				Enregistrer</button>
        </form>
	  Pork chop cupim cow turkey frankfurter, landjaeger fatback hamburger meatball salami spare ribs. Rump tenderloin
	  salami, hamburger frankfurter landjaeger andouille.
	</div>
	<!--
	-->
	<div class="col-4 d-table-cell   p-2">
		
	  Brisket tongue frankfurter cupim strip steak rump picanha pancetta pork pig kevin pastrami biltong. Shankle venison
	  meatball swine sausage ground round. Tail pork loin ribeye kielbasa short ribs pork chop.
	Lorem ipsum dolor sit amet consectetur, adipisicing elit. Ea voluptas quibusdam ipsam omnis, 
	earum quaerat beatae sit, vero inventore ipsa nostrum officiis quae magnam. 
	Accusantium facere temporibus officia adipisci exercitationem.
	Lorem, ipsum dolor sit amet consectetur 
	adipisicing elit. Consectetur eveniet, suscipit amet nobis commodi 
	aliquid magnam cupiditate placeat aliquam molestiae, error omnis,
	 eaque asperiores veniam ducimus unde blanditiis numquam adipisci.
	</div>
  </div>
  
</div>
<jsp:directive.include file="footer.jsp" />