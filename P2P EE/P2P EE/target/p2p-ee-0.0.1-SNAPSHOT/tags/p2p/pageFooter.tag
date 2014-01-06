<%@tag %>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class='b49_footer'>

<c:if test="${not session.user.authenticated}">
	<div id='loginDialog' style='display:none'>
		<div class='b128_login'>
			<div class='b128_login__field'>
				<span class='b128_login__field__label'>User Name</span>
				<input id='un' class='b128_login__field__text' id='un' type='text' onClick="javascript:$('.b128_login__fail').css('display','none');" style='width:240px;' value='' autocomplete='off'>
			</div>
			<div class='b128_login__field'>
				<span class='b128_login__field__label'>Password</span>
				<input id='pw' class='b128_login__field__text' id='un' type='password' onClick="javascript:$('.b128_login__fail').css('display','none');" style='width:240px;' value='' autocomplete='off'>
			</div>
			<div class='b128_login__control'>
				<a class='b128_login__control__button m1_button' href='javascript:c6_login()'>Login</a>
				<input class='b128_login__control__checkBox' id='rm' checked type='checkbox'>
				<span class='b128_login__control__checkbox__text'>Remember me.</span>
			</div>
			<div class='b128_login__fail'><b>Login failed:</b>&nbsp;please check user name and password.</div>
		</div>
	</div>	
</c:if>
</div>
	</body>
</html>

