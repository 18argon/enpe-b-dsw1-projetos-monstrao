<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    
    <style>
	@import url('https://fonts.googleapis.com/css2?family=Dosis&display=swap');
	@font-face { font-family: Dosis; sans-serif; }
	.dosis { font-family: Dosis; font-size: 4.2em; }
	
	.centerElement {
    text-align: center;
	} 
	</style>
        
</head>
<body>

	<div class="centerElement">
		<h2 class="dosis">ProMON$TRÃO</h2>
	
	
    <a href="./login.jsp">
    	<h3>LOGIN</h3>  
    </a>
	
	<br><br>
	<form method="get" action="indexc.jsp">
		<button type="submit" name="l1" value="listaTodos">LISTAR TODOS OS TEATROS</button>
	    <button type="submit" name="l1" value="listaTodosCidade">LISTAR TEATROS POR CIDADE</button>
    </form>
    
    </div>
    
</body>
</html>