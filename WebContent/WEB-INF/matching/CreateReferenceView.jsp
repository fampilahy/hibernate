<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Matching - Create Reference</title>
</head>
<body>




	<fieldset>
		<legend>Reference details</legend>
		
		<form method ="post" action="/platform/matching/createreference">
<!-- 		<form method ="post" action="createreference"> -->

			<label for="brand">Brand <span class="required">*</span></label><input type="text" name="brand" id="brand" /> ${requestScope.errors.brand }<br />
			<label for="model">Model <span class="required">*</span></label><input type="text" name="model" id="model" /> ${requestScope.errors['model'] }<br />
			<label for="title">Title <span class="required">*</span></label><input type="text" name="title" id="title" /> ${errors.title }<br />
			
			<label for="url">Url <span class="required">*</span></label><input type="text" name="url" id="url" /> ${errors.url }<br />
			<label for="image">Image <span class="required">*</span></label><input type="text" name="image" id="image" /> ${errors.image }<br />
			
			<label for="ean">Ean </label><input type="text" name="ean" id="ean" /> ${errors.ean }<br />
			
			<label for="color">Color </label><input type="text" name="color" id="color" /> ${errors.color }<br />
			<label for="size">Size </label><input type="text" name="size" id="size" /><br />
			<label for="capacity">Capacity </label><input type="text" name="capacity" id="capacity" /> ${errors.capacity }<br />
			<label for="memory">Memory </label><input type="text" name="memory" id="memory" /><br />
			<label for="description">Description </label><input type="text" name="description" id="description" /> ${errors.description }<br />
			<label for="price">Price </label><input type="text" name="price" id="price" /> ${errors.price }<br />
			
			<!-- 			<label for="image1">Image1 </label><input type="text" name="image1" id="image1" /><br /> -->
<!-- 			<label for="image2">Image2 </label><input type="text" name="image2" id="image2" /><br /> -->
<!-- 			<label for="image3">Image3 </label><input type="text" name="image3" id="image3" /><br /> -->
<!-- 			<label for="image4">Image4 </label><input type="text" name="image4" id="image4" /><br /> -->
			
			
			 <input type="submit" value="Create" /> <input type="reset" value="Cancel" />

<c:choose>
<c:when test="${empty requestScope.errors['daoerror'] && empty requestScope.initializedaoerror}">
${requestScope.message} ${requestScope.reference.title} 

</c:when>
<c:when test="${ empty requestScope.initializedaoerror && not empty requestScope.errors['daoerror']}">
${requestScope.message} ${requestScope.errors['daoerror']}

</c:when>
<c:otherwise>
${requestScope.message} ${requestScope.initializedaoerror} 
</c:otherwise>
</c:choose>


</form>
	
		</fieldset>
<div id="overlay"></div>
<script>

var xhr = new XMLHttpRequest();
xhr.open('GET', 'http://localhost:8080/platform/matching/listreference',true);
xhr.setRequestHeader('Content-Type', 'text/html; charset=UTF-8');
	xhr.send(null);
	var overlay = document.getElementById('overlay');
	var overlay;
	xhr.addEventListener('readystatechange', function() {
		if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
// 			alert('statut 200');
			 overlay = document.getElementById('overlay');
			 overlay.innerHTML = xhr.responseText;
		} else if (xhr.readyState === XMLHttpRequest.DONE) {
// 			alert('status here ' + xhr.status);
		} else {
// 			alert('xhr ready state ' + xhr.readyState);
// 			alert('xhr status ' + xhr.status);
		}
	});
	


	
</script> 

</body>
</html>