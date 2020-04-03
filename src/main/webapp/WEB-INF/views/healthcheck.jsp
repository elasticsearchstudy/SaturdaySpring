<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="EUC-KR">
	<title>Health Check</title>
</head>

<body>
	<h2>Health Check</h2>
	<input type="radio" name="group1" id="coronamap" value="15.165.110.67">
	<label for="coronamap">https://coronamap.site/</label>
	<br>
	<input type="radio" name="group1" id="google" value="172.217.175.68" checked="checked">
	<label for="google">https://www.google.com/</label>
	<br>
	<br>
	<button type="button" onclick="checkHealth()">Check</button>
	<br>
	<br>
	<textarea id="healthchecktext" rows="30" cols="50"></textarea>
	<script>
		function checkHealth() {
			var xhttp = new XMLHttpRequest();
			var group1 = document.getElementsByName("group1");
			var ip;

			for (let i = 0; i < group1.length; i++) {
				if (group1[i].checked) {
					ip = group1[i].value;
				}
			}

			xhttp.onreadystatechange = function () {
				if (this.readyState == 4 && this.status == 200) {
					document.getElementById("healthchecktext").value += this.responseText + '\n';
				}
			};
			xhttp.open("GET", "../SaturdaySpring/ajax.health?ip=" + ip, true);
			xhttp.send();
		}
	</script>
</body>

</html>