<%@taglib prefix="s" uri="/struts-tags"%>

<s:form action="login">
	<s:textfield name="email" label="Email" />
	<s:textfield name="password" label="Password" />
	<s:submit value="Login"/>
</s:form>
<a href="register.jsp">register</a>
<a href="forget.jsp">forget</a>