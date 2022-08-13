<!DOCTYPE html>
<html lang="fr" data-color-mode="dark" data-dark-theme="dark_dimmed">
<head>
 <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/icone.png" type="image/x-icon"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link href="${pageContext.request.contextPath}/resources/css/milligram.css" rel="stylesheet" > -->
<style type="text/css">
  <%@include file="resources/css/primer.css" %>
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="Header">
 <div class="Header-item Header-item--full">
    bonjour ${s_id}
  </div>
  <div class="Header-item mr-0">
    <a href="logout.jsp" class="Header-link" style="color:yellow ;">Se d&eacute;connecter</a>
  </div>
    
</div>